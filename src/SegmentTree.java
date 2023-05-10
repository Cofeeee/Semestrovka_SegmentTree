public class SegmentTree {
    private int[] tree;

    public SegmentTree(int[] nums) {
        tree = new int[2 * nums.length];
        buildTree(nums);
    }

    private void buildTree(int[] nums) {
        int length = nums.length;

        for (int i = length, j = 0;  i < 2 * length; i++, j++) {
            tree[i] = nums[j];
        }
        for (int i = length - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(0, tree.length / 2 - 1, i, j, 0);
    }

    private int sumRange(int start, int end, int i, int j, int index) {
        if (i <= start && j >= end) {
            return tree[index];
        } else if (i > end || j < start) {
            return 0;
        } else {
            int mid = (start + end) / 2;
            return sumRange(start, mid, i, j, 2 * index + 1) + sumRange(mid + 1, end, i, j, 2 * index + 2);
        }
    }

    public void update(int i, int val) {
        int diff = val - tree[i];
        tree[i] = val;
        update(0, tree.length / 2 - 1, i, diff, 0);
    }

    private void update(int start, int end, int i, int diff, int index) {
        if (i < start || i > end) {
            return;
        }
        tree[index] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(start, mid, i, diff, 2 * index + 1);
            update(mid + 1, end, i, diff, 2 * index + 2);
        }
    }
}

