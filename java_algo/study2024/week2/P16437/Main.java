package study2024.week2.P16437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	private static Node[] info;
	private static List<List<Integer>> edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<Integer> lastNodes = new HashSet<>();
		edges = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			edges.add(new ArrayList<>());
			if (i >= 1) {
				lastNodes.add(i);
			}
		}

		info = new Node[n + 1];
		info[1] = new Node(1, "S", 0);

		for (int i = 2; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			long count = Long.parseLong(st.nextToken());
			info[i] = new Node(i, type, count);
			int parentNodeNum = Integer.parseInt(st.nextToken());
			edges.get(parentNodeNum).add(i);
		}

		long answer = dfs(1, 0);

		System.out.println(answer);
	}

	private static long dfs(int index, long sheepCount) {

		long find = 0;

		if (edges.get(index).isEmpty()) {
			if (info[index].type.equals("S")) {
				return info[index].count + sheepCount;
			}
		}

		for (Integer next : edges.get(index)) {
			find += dfs(next, sheepCount);
		}

		if (info[index].type.equals("W")) {
			if (find >= info[index].count) {
				find -= info[index].count;
				info[index].count = 0;
			} else {
				info[index].count -= find;
				find = 0;
			}
			return find + sheepCount;
		}

		sheepCount += find;

		return sheepCount + info[index].count;
	}
}

class Node {
	int index;
	String type; // S: 양, W: 늑대
	long count;

	public Node(int index, String type, long count) {
		this.index = index;
		this.type = type;
		this.count = count;
	}
}
