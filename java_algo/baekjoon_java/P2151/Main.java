package baekjoon_java.P2151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	private static int[] dx = new int[] {-1, 1, 0, 0};
	private static int[] dy = new int[] {0, 0, -1, 1};

	private static int n;
	private static char[][] map;
	private static boolean[][][] visited; // 방향, x, y visited

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		visited = new boolean[4][n][n];

		List<Node> doors = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '#') {
					doors.add(new Node(i, j, null, 0));
				}
			}
		}

		System.out.println(bfs(doors));
	}

	private static int bfs(List<Node> nodes) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.mirrorCount));

		Node start = nodes.get(0);
		List<Node> starts = findDirection(start);
		Node end = nodes.get(1);

		priorityQueue.addAll(starts);

		while (!priorityQueue.isEmpty()) {
			Node node = priorityQueue.poll();

			// 거울 설치가 가능한 케이스
			if (map[node.x][node.y] == '!') {
				Node leftNode = node.turnLeft();
				Node rightNode = node.turnRight();

				if (!visited[leftNode.direction.getDirection()][leftNode.x][leftNode.y]) {
					visited[leftNode.direction.getDirection()][leftNode.x][leftNode.y] = true;
					priorityQueue.add(leftNode);
				}

				if (!visited[rightNode.direction.getDirection()][rightNode.x][rightNode.y]) {
					visited[rightNode.direction.getDirection()][rightNode.x][rightNode.y] = true;
					priorityQueue.add(rightNode);
				}
			}

			// 그냥 직진 케이스
			int mx = node.x + dx[node.direction.getDirection()];
			int my = node.y + dy[node.direction.getDirection()];

			if (mx < 0 || mx >= n || my < 0 || my >= n) {
				continue;
			}

			if (map[mx][my] == '*') {
				continue;
			}

			if (mx == end.x && my == end.y) {
				return node.mirrorCount;
			}

			priorityQueue.add(new Node(mx, my, node.direction, node.mirrorCount));
		}

		return 0;
	}

	private static List<Node> findDirection(Node start) {

		List<Node> list = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			int mx = start.x + dx[i];
			int my = start.y + dy[i];

			if (mx < 0 || mx >= n || my < 0 || my >= n) {
				continue;
			}

			if (map[mx][my] == '*') {
				continue;
			}

			DIRECTION direction = DIRECTION.findDirection(i);
			list.add(new Node(start.x, start.y, direction, start.mirrorCount));
		}

		return list;
	}
}

class Node {
	int x;
	int y;
	DIRECTION direction;
	int mirrorCount;

	public Node(int x, int y, DIRECTION direction, int mirrorCount) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.mirrorCount = mirrorCount;
	}

	public Node turnLeft() {
		return new Node(x, y, direction.turnLeft(), mirrorCount + 1);
	}

	public Node turnRight() {
		return new Node(x, y, direction.turnRight(), mirrorCount + 1);
	}
}

enum DIRECTION {

	UP(0) {
		@Override
		public DIRECTION turnRight() {
			return DIRECTION.RIGHT;
		}

		@Override
		public DIRECTION turnLeft() {
			return DIRECTION.LEFT;
		}
	},
	DOWN(1) {
		@Override
		public DIRECTION turnRight() {
			return DIRECTION.LEFT;
		}

		@Override
		public DIRECTION turnLeft() {
			return DIRECTION.RIGHT;
		}
	},
	LEFT(2) {
		@Override
		public DIRECTION turnRight() {
			return DIRECTION.UP;
		}

		@Override
		public DIRECTION turnLeft() {
			return DIRECTION.DOWN;
		}
	},
	RIGHT(3) {
		@Override
		public DIRECTION turnRight() {
			return DIRECTION.DOWN;
		}

		@Override
		public DIRECTION turnLeft() {
			return DIRECTION.UP;
		}
	}
	;

	private final int direction;

	DIRECTION(int num) {
		this.direction = num;
	}

	public int getDirection() {
		return direction;
	}

	public abstract DIRECTION turnRight();

	public abstract DIRECTION turnLeft();

	public static DIRECTION findDirection(int num) {
		for (DIRECTION value : DIRECTION.values()) {
			if (num == value.direction) {
				return value;
			}
		}
		throw new IllegalArgumentException();
	}
}
