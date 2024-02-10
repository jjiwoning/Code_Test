package baekjoon_java.P13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static final int[] dx = new int[] {1, -1, 0, 0};
	private static final int[] dy = new int[] {0, 0, 1, -1};

	private static int n;
	private static int m;
	private static char[][] board;

	private static boolean[][][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new char[n][m];
		visited = new boolean[n][m][n][m]; // redX, redY, blueX, blueY 방문 체크

		Node start = new Node(-1, -1, -1, -1, 0);

		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'R') {
					start.redX = i;
					start.redY = j;
					board[i][j] = '.';
				}

				if (board[i][j] == 'B') {
					start.blueX = i;
					start.blueY = j;
					board[i][j] = '.';
				}
			}
		}

		System.out.println(bfs(start));
	}

	private static int bfs(Node start) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
		priorityQueue.add(start);
		visited[start.redX][start.redY][start.blueX][start.blueY] = true;

		while (!priorityQueue.isEmpty()) {
			Node now = priorityQueue.poll();

			if (now.count >= 10) { // 10번 넘어가면 0
				return -1;
			}

			for (int i = 0; i < 4; i++) {

				boolean redFlag = false;
				boolean blueFlag = false;

				// blue move
				int nowBlueX = now.blueX;
				int nowBlueY = now.blueY;

				int nowRedX = now.redX;
				int nowRedY = now.redY;

				boolean blueCanMove = true;
				boolean redCanMove = true;

				boolean samePosition = false;

				while (true) {
					if (blueCanMove) {
						nowBlueX += dx[i];
						nowBlueY += dy[i];
					}
					if (redCanMove) {
						nowRedX += dx[i];
						nowRedY += dy[i];
					}
					if (blueCanMove) {

						if (isOutBound(nowBlueX, nowBlueY) || board[nowBlueX][nowBlueY] == '#') {
							nowBlueX -= dx[i];
							nowBlueY -= dy[i];
							blueCanMove = false;
						}

						if (!isOutBound(nowBlueX, nowBlueY) && board[nowBlueX][nowBlueY] == 'O') {
							blueFlag = true;
							break;
						}
					}

					if (redCanMove) {

						if (isOutBound(nowRedX, nowRedY) ||  board[nowRedX][nowRedY] == '#') {
							nowRedX -= dx[i];
							nowRedY -= dy[i];
							redCanMove = false;
						}

						if (!isOutBound(nowRedX, nowRedY) && board[nowRedX][nowRedY] == 'O') {
							redFlag = true;
						}
					}

					if (!redCanMove && !blueCanMove) {
						break;
					}
				}

				if (redFlag && !blueFlag) {
					return now.count + 1;
				}

				if (blueFlag) {
					continue;
				}

				if (nowRedX == nowBlueX && nowRedY == nowBlueY) {
					switch (i) {
						case 0:
							if (now.redX > now.blueX) {
								nowBlueX -= dx[i];
							}
							if (now.redX < now.blueX) {
								nowRedX -= dx[i];
							}
							break;
						case 1:
							if (now.redX > now.blueX) {
								nowRedX -= dx[i];
							}
							if (now.redX < now.blueX) {
								nowBlueX -= dx[i];
							}
							break;
						case 2:
							if (now.redY > now.blueY) {
								nowBlueY -= dy[i];
							}
							if (now.redY < now.blueY) {
								nowRedY -= dy[i];
							}
							break;
						case 3:
							if (now.redY < now.blueY) {
								nowBlueY -= dy[i];
							}
							if (now.redY > now.blueY) {
								nowRedY -= dy[i];
							}
							break;
					}
				}

				if (visited[nowRedX][nowRedY][nowBlueX][nowBlueY]) {
					continue;
				}

				visited[nowRedX][nowRedY][nowBlueX][nowBlueY] = true;

				priorityQueue.add(new Node(nowRedX, nowRedY, nowBlueX, nowBlueY, now.count + 1));
			}
		}

		return -1;
	}

	private static boolean isOutBound(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= m;
	}
}

class Node {
	int redX;
	int redY;
	int blueX;
	int blueY;

	int count;

	public Node(int redX, int redY, int blueX, int blueY, int count) {
		this.redX = redX;
		this.redY = redY;
		this.blueX = blueX;
		this.blueY = blueY;
		this.count = count;
	}
}
