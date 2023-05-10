//class SecondSegmentTree {
//    private int[] tree;
//    private int n;
//
//    public SecondSegmentTree(int[] nums) {
//        n = nums.length;
//        tree = new int[2 * n];
//        buildTree(nums);
//    }
//
//    private void buildTree(int[] nums) {
//        for (int i = n, j = 0;  i < 2 * n; i++, j++) {
//            tree[i] = nums[j];
//        }
//        for (int i = n - 1; i > 0; i--) {
//            tree[i] = tree[i * 2] + tree[i * 2 + 1];
//        }
//    }
//
//    public void update(int index, int value) {
//        index += n;
//        tree[index] = value;
//        while (index > 0) {
//            int left = index;
//            int right = index;
//            if (index % 2 == 0) {
//                right = index + 1;
//            } else {
//                left = index - 1;
//            }
//            tree[index / 2] = tree[left] + tree[right];
//            index /= 2;
//        }
//    }
//
//    public int sumRange(int left, int right) {
//        left += n;
//        right += n;
//        int sum = 0;
//        int count = 0;
//        while (left <= right) {
//            if (left % 2 == 1) {
//                sum += tree[left];
//                left++;
//                count++;
//            }
//            if (right % 2 == 0) {
//                sum += tree[right];
//                right--;
//                count++;
//            }
//            left /= 2;
//            right /= 2;
//            count++;
//        }
//        System.out.println("Iterations in sumRange: " + count);
//        return sum;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 7, 9, 11};
//        SecondSegmentTree st = new SecondSegmentTree(nums);
//
//        long startTime = System.nanoTime();
//        int sum = st.sumRange(1, 4);
//        long endTime = System.nanoTime();
//
//        System.out.println("Sum of elements in range [1, 4]: " + sum);
//        System.out.println("Time taken by sumRange: " + (endTime - startTime) + " nanoseconds");
//
//        startTime = System.nanoTime();
//        st.update(3, 8);
//        endTime = System.nanoTime();
//
//        System.out.println("Time taken by update: " + (endTime - startTime) + " nanoseconds");
//    }
//}
