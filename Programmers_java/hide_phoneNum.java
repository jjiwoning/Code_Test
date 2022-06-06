package Programmers_java;

class Test{
    public static void main(String[] args) {
        Solution aa = new Solution();
        System.out.println(aa.solution("01012345678"));
    }
}

class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        String answer = "";
        for(int i = 0; i < len - 4; i++){
            answer += '*';
        } 
        answer += phone_number.substring(len - 4, len);
        
        return answer;
    }
}