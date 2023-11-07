package leetcode.P155;

import java.util.LinkedList;

public class MinStack {

	private LinkedList<Integer> numbers;
	private LinkedList<Integer> minNumbers;
	private int minNumber;

	public MinStack() {
		numbers = new LinkedList<>();
		minNumbers = new LinkedList<>();
		minNumber = Integer.MAX_VALUE;
	}

	public void push(int val) {
		minNumbers.add(Math.min(val, minNumber));
		minNumber = Math.min(val, minNumber);
		numbers.add(val);
	}

	public void pop() {
		numbers.pollLast();
		minNumbers.pollLast();
		if (minNumbers.isEmpty()) {
			minNumber = Integer.MAX_VALUE;
			return;
		}
		minNumber = minNumbers.peekLast();
	}

	public int top() {
		return numbers.peekLast();
	}

	public int getMin() {
		return minNumber;
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
