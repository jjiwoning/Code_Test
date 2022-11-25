package baekjoon_java.programmers.find_prime_number;

public class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String findNum = findNum(n, k);
        String[] strings = findNum.split("0");

        for (String string : strings) {
            if(string.equals("")){
                continue;
            }
            long number = Long.parseLong(string);
            if(isPrime(number)){
                answer += 1;
            }
        }
        return answer;
    }

    public String findNum(int n, int k){
        StringBuilder findNum = new StringBuilder();
        while (n > 0){
            findNum.append(n % k);
            n /= k;
        }
        findNum.reverse();
        String result = findNum.toString();
        return result;
    }

    public boolean isPrime(long number){
        if(number <= 1){
            return false;
        }
        if(number == 2){
            return true;
        }
        for (int i = 2; i <= (int)Math.sqrt(number); i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(110011, 10));
    }
}
