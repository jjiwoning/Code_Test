package leetcode.P38;

public class Solution {
	public String countAndSay(int n) {
		String s = "1";
		for (int i = 1; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			char start = s.charAt(0);
			int count = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == start) {
					count++;
				}
				if (s.charAt(j) != start) {
					sb.append(count).append(start);
					count = 1;
					start = s.charAt(j);
				}
			}
			sb.append(count).append(start);
			s = sb.toString();
		}
		return s;
	}
}
