import java.util.*;

public class SortSort {
        public int[] bubbleSort(int[] nums) {
            for (int i=0; i < nums.length; i++) {
                for (int j=i+1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }

            System.out.println(Arrays.toString(nums));

            return nums;
        }

        public int[] selectionSort(int[] nums) {
            for (int i=0; i < nums.length; i++) {
                int minIndex = i;
                for (int j=i+1; j < nums.length; j++) {
                    if (nums[j] < nums[minIndex]) {
                        minIndex = j;
                    }
                }
                int minValue = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = minValue;
            }
            return nums;
        }

        public int[] merge(int nums[], int leftIndex, int middleIndex, int rightIndex)
        {
            // Find sizes of left and right arrays to be merged
            int leftArraySize = middleIndex - leftIndex + 1;
            int rightArraySize = rightIndex - middleIndex;

            // Create left and right arrays
            int[] left = new int[leftArraySize];
            int[] right = new int[rightArraySize];

            // Copy elements into left and right arrays
            for (int i=0; i < leftArraySize; i++) {
                left[i] = nums[leftIndex + i];
            }
            for (int j=0; j < rightArraySize; j ++) {
                right[j] = nums[middleIndex + 1 + j];
            }

            // Merge left and right arrays
            //
            // Initial indexes of left and right arrays
            int l = 0, r = 0;
            //
            // Initial index of merged array
            int k = leftIndex;
            while (l < leftArraySize && r < rightArraySize) {
                if (left[l] <= right[r]) {
                    nums[k] = left[l];
                    l++;
                }
                else {
                    nums[k] = right[r];
                    r++;
                }
                k++;
            }
            //
            // Copy remaining elements of left array if any
            while (l < leftArraySize) {
                nums[k] = left[l];
                l++;
                k++;
            }
            //
            // Copy remaining elements of right array if any
            while (r < rightArraySize) {
                nums[k] = right[r];
                r++;
                k++;
            }
            return nums;
        }

        public int[] mergeSort(int nums[], int leftIndex, int rightIndex) {
            if (leftIndex < rightIndex) {
                int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

                mergeSort(nums, leftIndex, middleIndex);
                mergeSort(nums, middleIndex + 1, rightIndex);

                return merge(nums, leftIndex, middleIndex, rightIndex);
            }
            return nums;
        }

        public static void main(String[] args) {
            SortSort sort = new SortSort();
            Scanner scanner = new Scanner(System.in);

            System.out.println("How many tests do you want to run?");
            int numTests = scanner.nextInt();

            int[] randNums = new int[1000];
            for (int j = numTests; j > 0; j--) {
                for (int i = 0; i < 1000; i++) {
                    int rand = (int)(Math.random() * 200) - 100;

                    randNums[i] = rand;
                }
            }

            long startTime = System.nanoTime();
            sort.bubbleSort(randNums);
            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1000000.0;
            System.out.println("Bubble search completed in " + duration + " milliseconds");

            startTime = System.nanoTime();
            sort.selectionSort(randNums);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000.0;
            System.out.println("Selection search completed in " + duration + " milliseconds");

            startTime = System.nanoTime();
            sort.mergeSort(randNums, 0, randNums.length - 1);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000.0;
            System.out.println("Bubble search completed in " + duration + " milliseconds");


            // One "test" should call bubbleSort, selectionSort, and mergeSort with arrays of
            // 1000 random integers and print out the runtime of each algorithm.
            // If numTests is 13, for example, repeat the test 13 times, and print out the average
            // runtime of each algorithm. Here's an outline of what you need to do to run a test:
            //
            // First generate an array of 1000 random integers
            // Then, your code will look something like this:
            //
            // long startTime = System.nanoTime();
            // sort.bubbleSort(randomArray);
            // long endTime = System.nanoTime();
            // double duration = (endTime - startTime) / 1000000.0;
            // System.out.println("Bubble search completed in " + duration + " milliseconds");
            //
            // When running more than one test, you'll want to put the code above in a loop,
            // and print out the average duration of all the test runs, rather than the duration
            // of just one test run.
        }
    }



