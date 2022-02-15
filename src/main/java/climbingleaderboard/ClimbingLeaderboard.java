package climbingleaderboard;

import boilerplate.Lists;
import boilerplate.Metrics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClimbingLeaderboard {


    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        return climbingLeaderboardSlow(ranked, player);
    }

    public static List<Integer> climbingLeaderboardSlow2(List<Integer> ranked, List<Integer> player) {
        Map<Integer, Integer> rankedMap = ranked.stream().collect(Collectors.toMap(e -> e, e -> e, (a, b) -> a));
        TreeMap<Integer, Integer> sortedRanked = new TreeMap<>(rankedMap);
        LinkedList<Integer> in = new LinkedList<>(sortedRanked.keySet());
        in.sort(Comparator.reverseOrder());
        Integer[] rank = in.toArray(new Integer[0]);
        Integer added = 0;
        return player.stream().map(score -> getOrInsertReallyFaster(rank, score, added)).collect(Collectors.toList());
    }

    public static List<Integer> climbingLeaderboardSlow(List<Integer> ranked, List<Integer> player) {
        Map<Integer, Integer> rankedMap = ranked.stream().collect(Collectors.toMap(e -> e, e -> e, (a, b) -> a));
        TreeMap<Integer, Integer> sortedRanked = new TreeMap<>(rankedMap);
        return player.stream().map(score -> getOrInsertFaster(sortedRanked, score)).collect(Collectors.toList());
    }

    private static int getOrInsert(TreeMap<Integer, Integer> ranked, Integer playerScore) {
        ranked.put(playerScore, playerScore);
        int returnValue = 0;
        for (Integer elem : ranked.keySet()) {
            if (Objects.equals(elem, playerScore)) {
                return ranked.size() - returnValue;
            }
            returnValue++;
        }
        return ranked.size() - returnValue;
    }

    private static int getOrInsertFaster(TreeMap<Integer, Integer> ranked, Integer playerScore) {
        ranked.put(playerScore, playerScore);

        Set<Integer> keysGreaterThanEqTo = ranked.headMap(playerScore).keySet();

        return ranked.size() - keysGreaterThanEqTo.size();
    }


    private static int getOrInsertReallyFaster(Integer[] ranked, Integer playerScore, Integer added) {

        // check del primo elem
        // se sono più grande del primo, allora metto in testa e ritorno 1
        if (playerScore > ranked[0]) {
            added++;
            return 1;
        }
        if (playerScore.equals(ranked[0])) {
            return 1;
        }

        // check dell'ultimo elem
        // se sono più piccolo metto in coda e ritorno ranked.size() -1
        if (playerScore < ranked[ranked.length-1]) {
            //ranked.addLast(playerScore);
            return ranked.length +1 +added;
        }
        if (playerScore.equals(ranked[ranked.length-1])) {
            return ranked.length +added;
        }

        // binary search sulla lista per trovare il più piccolo intervallo dove posso entrare
        // inserisco in pos dell'indice

        int returnValue = search(playerScore, ranked);

        return returnValue +1 +added;
    }

    public static int search(int elem, Integer[] elements) {
        return binSearch(elem, elements, 0, elements.length - 1);
    }

    private static int binSearch(int elem, Integer[] elements, int start, int end) {
        int middle = (start + end) / 2;
        if (elem == elements[middle]) {
            return middle;
        } else if (Objects.equals(elements[start + 1], elements[end]) ) { // solo due elementi rimasti
            return start + 1;
        } else if (elem < elements[middle]) {
            return binSearch(elem, elements, middle , end);
        } else {
            return binSearch(elem, elements, start, middle);
        }
    }


    public static void main(String[] args) {
        List<Integer> ranked = new ArrayList<>(Arrays.asList(100, 90, 90, 80));
        List<Integer> player = new ArrayList<>(Arrays.asList(70, 80, 105)); // 4, 3, 1

        List<Integer> ranked2 = new ArrayList<>(Arrays.asList(100, 90, 90, 80, 75, 60));
        List<Integer> player2 = new ArrayList<>(Arrays.asList(50, 65, 77, 90, 102)); // 6 5 4 2 1

        System.out.println(climbingLeaderboardSlow2(ranked2, player2));



//        List<Integer>  ranked1 = IntStream.generate(() -> new Random().nextInt(1000)).limit(10000000).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        List<Integer>  player5 = IntStream.generate(() -> new Random().nextInt(1000)).limit(10000000).boxed().sorted().collect(Collectors.toList());
//        System.out.println(Metrics.getDuration(() -> climbingLeaderboardSlow(ranked1, player5)));
//        System.out.println(Metrics.getDuration(() -> climbingLeaderboardSlow2(ranked1, player5)));



    }

}
