import java.util.Scanner;

public class Search {
    public static int[] sortedNums = {
            1, 2, 3, 4, 9, 10,
            24, 25, 27, 28, 29,
            31, 33, 34, 37, 39,
            41, 43, 45, 48, 59,
            61, 63, 64, 79, 81,
            82, 83, 91, 92, 94
    };

    public int linearSearch(int[] searchList, int searchNum) {
        for (int i=0; i < searchList.length; i++) {
            if (searchList[i] == searchNum) {
                System.out.println("Found " + searchNum + " at index " + i);
                return i;
            }
        }
        System.out.println("Did not find " + searchNum);
        return -1;
    }

    public int binarySearch(int[] searchList, int searchNum) {
       int leftIndex = 0;
       int middleIndex = searchList.length/2;
       int rightIndex = searchList.length - 1;

       while (leftIndex <= rightIndex) {
           if (sortedNums[middleIndex] == searchNum) {
               System.out.println("Found " + searchNum + " at index " + middleIndex);
               return middleIndex;
           } else if (searchNum < sortedNums[middleIndex]) {
               rightIndex = middleIndex - 1;
               middleIndex = (rightIndex + leftIndex) / 2;
           } else {
               leftIndex = middleIndex + 1;
               middleIndex = (rightIndex + leftIndex) / 2;
           }
       }
        System.out.println("Did not find " + searchNum);
        return -1;
    }

//    public int recursiveBinarySearch(int[] searchList, int searchNum, int leftIndex, int rightIndex) {
//    }

    public static void main(String[] args) {
        Search search = new Search();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What number do you want to search for?");
        int numToFind = scanner.nextInt();

        long startTime = System.nanoTime();
        search.linearSearch(sortedNums, numToFind);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000.0;
        System.out.println("Linear search completed in " + duration + " milliseconds");

        startTime = System.nanoTime();
        search.binarySearch(sortedNums, numToFind);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;
        System.out.println("Binary search completed in " + duration + " milliseconds");
//
//        startTime = System.nanoTime();
//        search.recursiveBinarySearch(sortedNums, numToFind, 0, sortedNums.length - 1);
//        endTime = System.nanoTime();
//        duration = (endTime - startTime) / 1000000.0;
//        System.out.println("Recursive binary search completed in " + duration + " milliseconds");
    }
}
