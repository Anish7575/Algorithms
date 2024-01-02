class FenwickTree {
    int[] biTree;
    FenwickTree(int n) {
        biTree = new int[n + 1];
    }

    public void updateTree(int idx, int val) {
        idx += 1;
        while (idx < biTree.length) {
            biTree[idx] += val;
            idx += (idx & -idx);
        }
    }

    public void buildTree(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.updateTree(i, arr[i]);
        }
    }

    public int getSum(int idx) {
        idx += 1;
        int sum = 0;
        while (idx > 0) {
            sum += biTree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }
}

public class FenwickTreeSolver {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, -9, 11, 13, 45};
        FenwickTree ft = new FenwickTree(arr.length);
        ft.buildTree(arr);
        System.out.println(ft.getSum(5));
        System.out.println(ft.getSum(6));
        ft.updateTree(3, 9);
        System.out.println(ft.getSum(5));

    }
}
