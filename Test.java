import java.util.*;

public class Test {
    private static final int minSize = 1;
    private static final int maxSize = 8;

    private static final int minNumber = 0;
    private static final int maxNumber = 100;

    static Random random = new Random();

    public static void main(String[] args) {
        generateListOfLists(5);
    }

    private static void generateListOfLists(int numberOfLists) {

        if (maxSize - minSize < numberOfLists) {
            System.out.println("the difference between the maximum and minimum size of the array must be greater than the number of required massive");
            return;
        }

        List<ArrayList<Integer>> list = new ArrayList<>();
        for (Integer size : generateDistinctSizes(numberOfLists)) {
            list.add((ArrayList<Integer>) generateRandomList(size));
        }

        sortedList(list);

        System.out.println(list);
    }
    private static Set<Integer> generateDistinctSizes(int numberOfLists) {
        Set<Integer> uniqueSize = new HashSet<>();

        while (uniqueSize.size() < numberOfLists) {
            uniqueSize.add(random.nextInt(maxSize) + minSize);
        }
        return uniqueSize;
    }
    private static List<Integer> generateRandomList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxNumber) + minNumber);
        }
        return list;
    }

    private static void sortedList(List<ArrayList<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            if (i % 2 == 0) {
                Collections.sort(lists.get(i));
            } else {
                lists.get(i).sort(Collections.reverseOrder());
            }
        }
    }
}

