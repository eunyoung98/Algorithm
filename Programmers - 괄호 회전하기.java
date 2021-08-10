import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int i = 0;
        while (i < s.length()){
            if (chk(s) == true)
                answer++;
            s += s.charAt(0);
            s = s.substring(1, s.length());
            i++;
        }
        return answer;
    }
    
    public boolean chk(String s) {
        boolean answer = true;
        Stack<Character> arr = new Stack<>();
        int i = 0;
        while (i < s.length()){
            if (arr.isEmpty()){
                arr.push(s.charAt(i));
            }
            else{
                if (s.charAt(i) == ')' && arr.peek() == '(')
                    arr.pop();
                else if (s.charAt(i) == ']' && arr.peek() == '[')
                    arr.pop();
                else if (s.charAt(i) == '}' && arr.peek() == '{')
                    arr.pop();
                else
                    arr.push(s.charAt(i));
            }
            i++;
        }
        if (arr.isEmpty())
            answer = true;
        else
            answer = false;
        return answer;
    }
}