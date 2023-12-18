package baekjoon_java.P9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	private static final int[] DX = new int[] {1, -1, 0, 0};
	private static final int[] DY = new int[] {0, 0, 1, -1};

	private static int n;
	private static int m;
	private static char[][] map;
	private static boolean[][][][] visited; // doorCount, findPerson, x, y

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		for (int testCase = 0; testCase < t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken()) + 2;
			m = Integer.parseInt(st.nextToken()) + 2;

			map = new char[n][m];
			int doorCount = 0;
			Arrays.fill(map[0], '.');
			Arrays.fill(map[n - 1], '.');

			for (int i = 1; i < n - 1; i++) {
				Arrays.fill(map[i], '.');
				char[] chars = br.readLine().toCharArray();
				for (int j = 1; j < m - 1; j++) {
					map[i][j] = chars[j - 1];
					if (chars[j - 1] == '#') {
						doorCount++;
					}
				}
			}

			visited = new boolean[doorCount + 1][3][n][m];

			answer.append(bfs()).append("\n");
		}

		System.out.println(answer);
	}

	private static int bfs() {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.visitedDoor.size()));

		priorityQueue.add(new Node(0, 0));
		visited[0][0][0][0] = true;

		while (!priorityQueue.isEmpty()) {
			Node node = priorityQueue.poll();

			if (node.findPerson.size() == 2) {
				return node.visitedDoor.size();
			}

			for (int i = 0; i < 4; i++) {
				int mx = node.x + DX[i];
				int my = node.y + DY[i];

				if (mx < 0 || mx >= n || my < 0 || my >= m) {
					continue;
				}

				if (visited[node.visitedDoor.size()][node.findPerson.size()][mx][my]) {
					continue;
				}

				if (map[mx][my] == '*') {
					continue;
				}

				if (map[mx][my] == '#') {
					if (node.visitedDoor.contains(new Point(mx, my))) {
						if (!visited[node.visitedDoor.size()][node.findPerson.size()][mx][my]) {
							visited[node.visitedDoor.size()][node.findPerson.size()][mx][my] = true;
							HashSet<Point> doors = new HashSet<>(node.visitedDoor);
							doors.add(new Point(mx, my));
							priorityQueue.add(new Node(mx, my, doors, new HashSet<>(node.findPerson)));
						}
					} else {
						if (!visited[node.visitedDoor.size() + 1][node.findPerson.size()][mx][my]) {
							visited[node.visitedDoor.size() + 1][node.findPerson.size()][mx][my] = true;
							HashSet<Point> doors = new HashSet<>(node.visitedDoor);
							doors.add(new Point(mx, my));
							priorityQueue.add(new Node(mx, my, doors, new HashSet<>(node.findPerson)));
						}
					}
				}

				if (map[mx][my] == '.') {
					if (!visited[node.visitedDoor.size()][node.findPerson.size()][mx][my]) {
						visited[node.visitedDoor.size()][node.findPerson.size()][mx][my] = true;
						priorityQueue.add(new Node(mx, my, new HashSet<>(node.visitedDoor), new HashSet<>(node.findPerson)));
					}
				}

				if (map[mx][my] == '$') {
					if (node.findPerson.contains(new Point(mx, my))) {
						continue;
					}
					visited[node.visitedDoor.size()][node.findPerson.size() + 1][mx][my] = true;
					HashSet<Point> people = new HashSet<>(node.findPerson);
					people.add(new Point(mx, my));
					if (people.size() == 2) {
						return node.visitedDoor.size();
					}
					priorityQueue.add(new Node(mx, my, node.visitedDoor, people));
				}
			}
		}

		return 1;
	}
}

class Node {
	int x;
	int y;
	Set<Point> visitedDoor;
	Set<Point> findPerson;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.visitedDoor = new HashSet<>();
		this.findPerson = new HashSet<>();
	}

	public Node(int x, int y, Set<Point> visitedDoor, Set<Point> findPerson) {
		this.x = x;
		this.y = y;
		this.visitedDoor = visitedDoor;
		this.findPerson = findPerson;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Point point = (Point)o;
		return x == point.x && y == point.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
