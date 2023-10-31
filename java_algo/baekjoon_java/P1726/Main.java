package baekjoon_java.P1726;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int m;

	private static int[][] map;
	private static int[][][] visited;

	private static int[] dx = new int[] {0, 0, 0, 1, -1};
	private static int[] dy = new int[] {0, 1, -1, 0, 0};
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = parseInt(st.nextToken());
		m = parseInt(st.nextToken());

		map = new int[n][m];
		visited = new int[5][n][m];

		answer = MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int value = parseInt(st.nextToken());
				if (value == 1) {
					map[i][j] = value * -1;
					continue;
				}
				map[i][j] = MAX_VALUE;
				visited[1][i][j] = MAX_VALUE;
				visited[2][i][j] = MAX_VALUE;
				visited[3][i][j] = MAX_VALUE;
				visited[4][i][j] = MAX_VALUE;
			}
		}

		st = new StringTokenizer(br.readLine());
		Node start = new Node(parseInt(st.nextToken()) - 1, parseInt(st.nextToken()) - 1, 0, parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Node end = new Node(parseInt(st.nextToken()) - 1, parseInt(st.nextToken()) - 1, 0, parseInt(st.nextToken()));

		System.out.println(bfs(start, end));
	}

	private static int bfs(Node start, Node end) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		priorityQueue.add(start);

		while (!priorityQueue.isEmpty()) {
			Node now = priorityQueue.poll();
			int x = now.x;
			int y = now.y;

			if (now.x == end.x && now.y == end.y && now.direction == end.direction) {
				return now.cost;
			}

			// 직진하기
			for (int i = 0; i < 3; i++) {
				x += dx[now.direction];
				y += dy[now.direction];

				if (x < 0 || x >= n || y < 0 || y >= m) {
					break;
				}

				if (map[x][y] == -1) {
					break;
				}

				if (visited[now.direction][x][y] < now.cost + 1) {
					break;
				}

				visited[now.direction][x][y] = now.cost + 1;

				priorityQueue.add(new Node(x, y, now.cost + 1, now.direction));
			}

			// 회전 시키기
			if (now.direction / 3 == 0) {
				if (now.direction == 1) {
					if (visited[2][now.x][now.y] > now.cost + 2) {
						visited[2][now.x][now.y] = now.cost + 2;
						priorityQueue.add(new Node(now.x, now.y, now.cost + 2, 2));
					}
				}
				if (now.direction == 2) {
					if (visited[1][now.x][now.y] > now.cost + 2) {
						visited[1][now.x][now.y] = now.cost + 2;
						priorityQueue.add(new Node(now.x, now.y, now.cost + 2, 1));
					}
				}
				if (visited[3][now.x][now.y] > now.cost + 1) {
					priorityQueue.add(new Node(now.x, now.y, now.cost + 1, 3));
				}
				if (visited[4][now.x][now.y] > now.cost + 1) {
					priorityQueue.add(new Node(now.x, now.y, now.cost + 1, 4));
				}
			}

			if (now.direction / 3 == 1) {
				if (now.direction == 3) {
					if (visited[4][now.x][now.y] > now.cost + 2) {
						visited[4][now.x][now.y] = now.cost + 2;
						priorityQueue.add(new Node(now.x, now.y, now.cost + 2, 4));
					}
				}
				if (now.direction == 4) {
					if (visited[3][now.x][now.y] > now.cost + 2) {
						visited[3][now.x][now.y] = now.cost + 2;
						priorityQueue.add(new Node(now.x, now.y, now.cost + 2, 3));
					}
				}
				if (visited[1][now.x][now.y] > now.cost + 1) {
					priorityQueue.add(new Node(now.x, now.y, now.cost + 1, 1));
				}
				if (visited[2][now.x][now.y] > now.cost + 1) {
					priorityQueue.add(new Node(now.x, now.y, now.cost + 1, 2));
				}
			}
		}

		return answer;
	}
}

class Node {
	int x;
	int y;
	int cost;
	int direction; // 동 : 1, 서 : 2, 남 : 3, 북 : 4

	public Node(int x, int y, int cost, int direction) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.direction = direction;
	}
}
