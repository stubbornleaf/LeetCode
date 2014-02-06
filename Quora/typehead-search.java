import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public enum Type {
        USER, TOPIC, QUESTION, BOARD;
    }

    public enum Command {
        ADD, DEL, QUERY, WQUERY;
    }

    public static class Item {
        private String id;
        private Type type;
        private float score;
        private String data;
        private long time;

        public Item(String id, Type type, float score, String data, long time) {
            this.id = id;
            this.type = type;
            this.score = score;
            this.data = data;
            this.time = time;
        }
    }

    public static class SortableItem {
        private String id;
        private float score;
        private long time;

        public SortableItem(String id, float score, long time) {
            this.id = id;
            this.score = score;
            this.time = time;
        }
    }

    public static class ItemComparator implements Comparator<SortableItem> {

        @Override
        public int compare(SortableItem o1, SortableItem o2) {
            if (o1.score == o2.score) {
                return o1.time > o2.time ? -1 : 1;
            } else {
                return o1.score > o2.score ? -1 : 1;
            }
        }

    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int lines = 0, numOfResults = 0;
        long time = 0;
        float score = 0;
        String id = null, data = null;
        Command command = null;
        Type type = null;
        Item item = null;
        HashMap<String, Item> items = new HashMap<>();
        HashMap<String, HashSet<String>> tokenIdsMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lines = Integer.valueOf(br.readLine());
        StringBuilder sb;
        HashSet<String> ids;
        ArrayList<SortableItem> results;
        for (int lineIndex = 0; lineIndex < lines; lineIndex++) {
            String[] tmpTokens = br.readLine().split(" +");

            if (tmpTokens.length == 0)
                continue;

            command = Command.valueOf(tmpTokens[0].toUpperCase());
            switch (command) {
            case ADD:
                if (tmpTokens.length < 4)
                    continue;

                type = Type.valueOf(tmpTokens[1].toUpperCase());
                id = tmpTokens[2];
                score = Float.valueOf(tmpTokens[3]);

                sb = new StringBuilder();
                for (int tokenIndex = 4; tokenIndex < tmpTokens.length; tokenIndex++) {
                    String token = tmpTokens[tokenIndex];

                    for (int charIndex = 1; charIndex <= token.length(); charIndex++) {
                        String prefix = token.substring(0, charIndex)
                                .toLowerCase();

                        if (tokenIdsMap.containsKey(prefix)) {
                            tokenIdsMap.get(prefix).add(id);
                        } else {
                            ids = new HashSet<>();
                            ids.add(id);
                            tokenIdsMap.put(prefix, ids);
                        }
                    }

                    sb.append(token);
                    sb.append(" ");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }

                data = sb.toString();
                item = new Item(id, type, score, data, time++);
                items.put(id, item);

                break;

            case DEL:
                if (tmpTokens.length < 2)
                    continue;

                id = tmpTokens[1];

                item = items.get(id);
                if (item == null) {
                    continue;
                }

                tmpTokens = item.data.split(" +");
                for (int tokenIndex = 0; tokenIndex < tmpTokens.length; tokenIndex++) {
                    String token = tmpTokens[tokenIndex];

                    for (int charIndex = 1; charIndex <= token.length(); charIndex++) {
                        String prefix = token.substring(0, charIndex)
                                .toLowerCase();
                        ids = tokenIdsMap.get(prefix);
                        if (ids.size() == 1) {
                            tokenIdsMap.remove(prefix);
                        } else {
                            ids.remove(id);
                        }
                    }
                }

                items.remove(id);

                break;

            case QUERY:
                if (tmpTokens.length < 2)
                    continue;

                numOfResults = Integer.valueOf(tmpTokens[1]);
                ids = findMatchedIds(tokenIdsMap, tmpTokens, 2);

                if (ids.size() == 0) {
                    System.out.println();
                    continue;
                }

                results = new ArrayList<>();
                for (String tmpId : ids) {
                    item = items.get(tmpId);
                    results.add(new SortableItem(item.id, item.score, item.time));
                }
                Collections.sort(results, new ItemComparator());

                printResult(numOfResults, results);

                break;

            case WQUERY:
                if (tmpTokens.length < 2)
                    continue;

                numOfResults = Integer.valueOf(tmpTokens[1]);
                int numOfBoosts = Integer.valueOf(tmpTokens[2]);

                HashMap<String, Float> boosts = new HashMap<>();
                int tokenIndex = 3;
                for (int boostIndex = 0; boostIndex < numOfBoosts; boostIndex++, tokenIndex++) {
                    String[] boostVals = tmpTokens[tokenIndex].split(":");
                    boosts.put(boostVals[0].toUpperCase(),
                            Float.valueOf(boostVals[1]));
                }

                ids = findMatchedIds(tokenIdsMap, tmpTokens, tokenIndex);

                if (ids.size() == 0) {
                    System.out.println();
                    continue;
                }

                results = new ArrayList<>();
                for (String tmpId : ids) {
                    item = items.get(tmpId);
                    float tmpScore = item.score;
                    if (boosts.containsKey(item.id)) {
                        tmpScore *= boosts.get(item.id);
                    }
                    if (boosts.containsKey(item.type.toString())) {
                        tmpScore *= boosts.get(item.type.toString());
                    }
                    results.add(new SortableItem(item.id, tmpScore, item.time));
                }
                Collections.sort(results, new ItemComparator());

                printResult(numOfResults, results);

                break;

            default:
                break;
            }
        }
    }

    private static HashSet<String> findMatchedIds(
            HashMap<String, HashSet<String>> tokenIdsMap, String[] tmpTokens,
            int from) {
        ArrayList<HashSet<String>> idsCollection = new ArrayList<>();

        for (int tokenIndex = from; tokenIndex < tmpTokens.length; tokenIndex++) {
            String token = tmpTokens[tokenIndex].toLowerCase();
            if (tokenIdsMap.containsKey(token)) {
                idsCollection.add(tokenIdsMap.get(token));
            } else {
                idsCollection.clear();
                break;
            }
        }

        if (idsCollection.size() == 0) {
            return new HashSet<String>();
        }

        HashSet<String> ids = new HashSet<>(idsCollection.get(0));
        for (HashSet<String> tmpIds : idsCollection) {
            ids.retainAll(tmpIds);
        }
        return ids;
    }

    private static void printResult(int numOfResults,
            ArrayList<SortableItem> results) {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < numOfResults && index < results.size(); index++) {
            sb.append(results.get(index).id);
            sb.append(" ");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }

}

