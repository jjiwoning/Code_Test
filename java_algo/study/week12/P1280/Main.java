package study.week12.P1280;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private final static int MOD_CONST = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long[] sumArr = new long[n + 1];

        for (int i = 1; i < n; i++) {
            sumArr[i] = Math.abs(arr[i] - arr[i - 1]);
        }

        SegmentTree segmentTree = new SegmentTree(n);
        segmentTree.initial(sumArr, 1, 1, n);

        long answer = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                answer *= segmentTree.sum(1, 1, n, j, i);
                answer %= MOD_CONST;
            }
        }

        System.out.println(answer);
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
