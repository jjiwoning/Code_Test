package Programmers_java.kakao118667;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	// 1 ≤ queue1의 원소, queue2의 원소 ≤ 10^9
	// -> 음수는 존재하지 않는다.
	// -> long type 써야 됨
	public int solution(int[] queue1, int[] queue2) {
		MyQueue firstQueue = new MyQueue(queue1);
		MyQueue secondQueue = new MyQueue(queue2);

		int count = 0;

		if (firstQueue.totalSum + secondQueue.totalSum % 2 == 1) {
			return -1;
		}

		while (count < queue1.length * 3) { // 여기까지 도달한 순간 사이클이 생겼다는 뜻 임
			if (firstQueue.totalSum == secondQueue.totalSum) {
				return count;
			}

			if (firstQueue.totalSum > secondQueue.totalSum) {
				// firstQueue의 원소를 secondQueue로 옮겨줘야 답이 될 가능성이 생긴다.
				secondQueue.add(firstQueue.poll());
				count++;
				continue;
			}

			if (firstQueue.totalSum < secondQueue.totalSum) {
				// secondQueue의 원소를 firstQueue로 옮겨줘야 답이 될 가능성이 생긴다.
				firstQueue.add(secondQueue.poll());
				count++;
			}
		}

		return -1;
	}

}

class MyQueue {
	long totalSum;
	Queue<Long> queue;

	public MyQueue(int[] arr) {
		queue = new LinkedList<>();
		totalSum = 0L;
		for (Integer num : arr) {
			queue.add(Long.valueOf(num));
			totalSum += num;
		}
	}

	public long poll() {
		long num = queue.poll();
		totalSum -= num;
		return num;
	}

	public void add(long num) {
		totalSum += num;
		queue.add(num);
	}
}
