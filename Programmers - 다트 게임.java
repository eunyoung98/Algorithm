import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int before = 0;
        int i = 0;
        while (true){
            int num = dartResult.charAt(i++) - '0';
            while (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9'){
                num = num * 10 + (dartResult.charAt(i++) - '0');
            }
            if (dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T'){
                if (dartResult.charAt(i) == 'S'){
                    num = num;
                }
                else if (dartResult.charAt(i) == 'D'){
                    num = num * num;
                }
                else {
                    num = num * num * num;
                }
                i++;
            }
            if (i == dartResult.length()){
                answer += num;
                break;
            }
            if (dartResult.charAt(i) == '#' || dartResult.charAt(i) == '*'){
                if (dartResult.charAt(i) == '#'){
                    num = -num;
                    answer += num;
                }
                else{
                    num = num * 2;
                    answer = answer + before + num;
                }
                i++;
            }
            else
                answer += num;
            before = num;
            if (i == dartResult.length())
                break;
        }
        return answer;
    }
}