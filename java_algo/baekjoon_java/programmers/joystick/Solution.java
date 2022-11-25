package baekjoon_java.programmers.joystick;

public class Solution {

    public int solution(String name) {
        // ABCDEFGHIJKLM NOPQRSTUVWXYZ -> 26자
        // M까지는 다음 N부터는 이전으로 이동
        int answer = 0;
        char[] nameArray = name.toCharArray();
        int length = nameArray.length;
        int move = length- 1; // 어떻게 움직일지 정하는 변수
        int index; // A 값이 얼마나 연속되는지 확인하는 변수

        for (int i = 0; i < length; i++) {
            if(nameArray[i] <= 'M'){
                answer += nameArray[i] - 'A';
            }
            if(nameArray[i] > 'M'){
                answer += 26 - nameArray[i] + 'A';
            }
            index = i + 1;
            while(index < length && nameArray[index] == 'A'){
                index++;
            }

            //움직이는 경우의 수 최소값 구하는 로직
            // 지금까지 움직인거 되돌아가기 = i *2 + 뒤에서부터 남은 문자 움직이기 = length - index
            move = Math.min(move, i * 2 + length - index);
            // 처음부터 뒤에서 움직이기 -> 뒤에서부터 남은 문자 움직였다가 처음으로 돌아오기 = (length - index) * 2 + 처음에서 A 전까지 움직이기 i
            move = Math.min(move, (length - index) * 2 + i);
        }

        return answer + move;
    }

    public static void main(String[] args) {
        String name1 = "JEROEN";
        String name2 = "JAN";
        Solution s = new Solution();
        int solution = s.solution(name1);
        System.out.println(solution);
    }
}
