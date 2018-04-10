package cn.pengf.leetcode;

import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		if (temperatures == null) {
			return null;
		}

		int[] result = new int[temperatures.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = temperatures.length - 1; i >= 0; --i) {
			while (!stack.isEmpty()
					&& temperatures[i] >= temperatures[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result[i] = 0;
			} else {
				result[i] = stack.peek() - i;
			}
			stack.push(i);
		}

		return result;
	}
}
