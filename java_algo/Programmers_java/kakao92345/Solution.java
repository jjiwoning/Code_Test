package Programmers_java.kakao92345;

import java.util.*;

/**
 * 캐릭터는 발판이 있는 곳으로만 이동할 수 있으며, 보드 밖으로 이동할 수 없습니다.
 * 양 플레이어는 번갈아가며 자기 차례에 자신의 캐릭터를 상하좌우로 인접한 4개의 칸 중에서 발판이 있는 칸으로 옮겨야 합니다.
 * 움직일 차례인데 캐릭터의 상하좌우 주변 4칸이 모두 발판이 없거나 보드 밖이라서 이동할 수 없는 경우, 해당 차례 플레이어는 패배합니다.
 * 두 캐릭터가 같은 발판 위에 있을 때, 상대 플레이어의 캐릭터가 다른 발판으로 이동하여 자신의 캐릭터가 서있던 발판이 사라지게 되면 패배합니다.
 */

public class Solution {

	private static final int[] dx = new int[]{1, -1, 0, 0};
	private static final int[] dy = new int[]{0, 0, 1, -1};

	private int n;
	private int m;
	private int[][] board;
	private int minMove;
	private int maxMove;
	private Boolean whoWin;
	private List<int[]> answers;

	public int solution(int[][] board, int[] aloc, int[] bloc) {
		this.n = board.length;
		this.m = board[0].length;
		this.board = board;
		this.minMove = Integer.MIN_VALUE;
		this.maxMove = -1;
		this.answers = new ArrayList<>();

		User userA = new User(aloc[0], aloc[1], true);
		User userB = new User(bloc[0], bloc[1], false);

		whoWin(userA, userB, true);

		dfs(userA, userB, true, 0, 0); // A부터 움직인다.

		// 승리하는 플레이어는 최소한의 이동으로 승리하고 패배하는 플레이어는 최대한의 이동으로 패배해야 합니다.
		answers.sort((o1, o2) -> {
			if (this.whoWin.equals(Boolean.FALSE)) { // A가 이긴 경우
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
			if (this.whoWin.equals(Boolean.TRUE)) { // B가 이긴 경우
				if (o1[1] == o2[1]) {
					return o2[0] - o1[0];
				}
				return o1[1] - o2[1];
			}
			throw new IllegalArgumentException();
		});

		return answers.get(0)[0] + answers.get(0)[1];
	}

	private void whoWin(User userA, User userB, boolean turn) {

		if (whoWin != null) {
			return;
		}

		if (turn) {
			// userA
			if (userA.canNotMove(board)) {
				this.whoWin = Boolean.TRUE;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int mx = userA.x + dx[i];
				int my = userA.y + dy[i];

				if (mx < 0 || mx >= board.length || my < 0 || my >= board[0].length) {
					continue;
				}

				if (board[mx][my] == 1) {
					board[userA.x][userA.y] = 0;
					whoWin(new User(mx, my, true), new User(userB), !turn);
					board[userA.x][userA.y] = 1;
				}
			}
		}

		if (!turn) {
			// userB
			if (userB.canNotMove(board)) {
				this.whoWin = Boolean.FALSE;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int mx = userB.x + dx[i];
				int my = userB.y + dy[i];

				if (mx < 0 || mx >= board.length || my < 0 || my >= board[0].length) {
					continue;
				}

				if (board[mx][my] == 1) {
					board[userB.x][userB.y] = 0;
					whoWin(new User(userA), new User(mx, my, false), !turn);
					board[userB.x][userB.y] = 1;
				}
			}
		}
	}

	private void dfs(User userA, User userB, boolean turn, int userACount, int userBCount) {
		if (turn) {
			// userA
			if (userA.canNotMove(board)) {
				if (this.whoWin.equals(Boolean.TRUE)) {
					answers.add(new int[]{userACount, userBCount});
				}
				return;
			}

			for (int i = 0; i < 4; i++) {
				int mx = userA.x + dx[i];
				int my = userA.y + dy[i];

				if (mx < 0 || mx >= board.length || my < 0 || my >= board[0].length) {
					continue;
				}

				if (board[mx][my] == 1) {
					board[userA.x][userA.y] = 0;
					dfs(new User(mx, my, true), new User(userB), false, userACount + 1, userBCount);
					board[userA.x][userA.y] = 1;
				}
			}
		}

		if (!turn) {
			// userB
			if (userB.canNotMove(board)) {
				if (this.whoWin.equals(Boolean.FALSE)) {
					answers.add(new int[]{userACount, userBCount});
				}
				return;
			}

			for (int i = 0; i < 4; i++) {
				int mx = userB.x + dx[i];
				int my = userB.y + dy[i];

				if (mx < 0 || mx >= board.length || my < 0 || my >= board[0].length) {
					continue;
				}

				if (board[mx][my] == 1) {
					board[userB.x][userB.y] = 0;
					dfs(new User(userA), new User(mx, my, false), true, userACount, userBCount + 1);
					board[userB.x][userB.y] = 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution(
			new int[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}},
			new int[] {1, 0},
			new int[] {1, 2}
		));
		System.out.println(new Solution().solution(
			new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
			new int[] {1, 0},
			new int[] {1, 2}
		));
	}
}

class User {
	int x;
	int y;
	boolean type; // true: a, false: b

	public User(int x, int y, boolean type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public User(User user) {
		this.x = user.x;
		this.y = user.y;
		this.type = user.type;
	}

	public boolean canNotMove(int[][] board) {
		int[] dx = new int[]{1, -1, 0, 0};
		int[] dy = new int[]{0, 0, 1, -1};

		if (board[this.x][this.y] == 0) {
			return true;
		}

		for (int i = 0; i < 4; i++) {
			int mx = this.x + dx[i];
			int my = this.y + dy[i];

			if (mx < 0 || mx >= board.length || my < 0 || my >= board[0].length) {
				continue;
			}

			if (board[mx][my] == 1) {
				return false;
			}
		}

		return true;
	}
}
