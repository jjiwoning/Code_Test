package baekjoon_java.P2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(n);
        FenwickTree fenwickTree = new FenwickTree(n + 1);

        long[] arr = new long[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Long.parseLong(br.readLine());
            fenwickTree.update(i, arr[i]);
        }

        segmentTree.initial(arr, 1, 1, n);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                int index = Integer.parseInt(st.nextToken());
                long changeValue = Long.parseLong(st.nextToken());
                segmentTree.updateByValue(1, 1, n, index, changeValue);
                fenwickTree.update(index, changeValue - arr[index]);
                arr[index] = changeValue;
            }
            if (num == 2) {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
//                System.out.println(segmentTree.sum(1, 1, n, left, right));
                System.out.println(fenwickTree.sum(right) - fenwickTree.sum(left - 1));
            }
        }
    }
}

class SegmentTree {
    long[] tree;
    int size;

    public SegmentTree(int arrayLength) { // constructor -> make tree
        int height = (int) Math.ceil(Math.log(arrayLength) / Math.log(2));
        this.size = (int) Math.pow(2, height + 1);
        tree = new long[this.size];
    }

    public long initial(long[] arr, int nodeIndex, int start, int end) {
        if (start == end) { // leaf node
            return tree[nodeIndex] = arr[start];
        }

        return tree[nodeIndex] = initial(arr, nodeIndex * 2, start, (start + end) / 2)
                + initial(arr, nodeIndex * 2 + 1, (start + end) / 2 + 1, end);
    }

    public void updateByDifference(int nodeIndex, int start, int end, int updateIndex, long difference) {
        if (updateIndex < start || updateIndex > end) {
            return; // array out of bound
        }

        tree[nodeIndex] += difference;

        if (start != end) {
            updateByDifference(nodeIndex * 2, start, (start + end) / 2, updateIndex, difference); // left node
            updateByDifference(nodeIndex * 2 + 1, (start + end) / 2, end, updateIndex, difference); // right node
        }
    }

    public long updateByValue(int nodeIndex, int start, int end, int updateIndex, long changeValue) {
        if (updateIndex < start || end < updateIndex) {
            return tree[nodeIndex];
        }

        if (start == updateIndex && end == updateIndex) {
            return tree[nodeIndex] = changeValue;
        }

        return tree[nodeIndex] = updateByValue(nodeIndex * 2, start, (start + end) / 2, updateIndex, changeValue)
                + updateByValue(nodeIndex * 2 + 1, (start + end) / 2 + 1, end, updateIndex, changeValue);
    }

    public long sum(int nodeIndex, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return 0; // array out of bound
        }

        if (left <= start && end <= right) {
            return tree[nodeIndex];
        }

        return sum(nodeIndex * 2, start, (start + end) / 2, left, right)
                + sum(nodeIndex * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }
}

class FenwickTree {
    long[] tree;

    public FenwickTree(int size) {
        this.tree = new long[size];
    }

    public void update(int index, long data) {
        while (index < tree.length) {
            tree[index] += data;
            index += (index & -index);
        }
    }

    public long sum(int index) {
        long sum = 0L;
        while (index > 0) {
            sum += tree[index];
            index -= (index & -index);
        }
        return sum;
    }
}
