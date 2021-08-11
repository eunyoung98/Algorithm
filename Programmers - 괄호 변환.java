import java.util.*;

class Solution {
    static String real;
    static String answer;
    public String solution(String p) {
        answer = "";
        real = p;
        if (p == "")
            return answer;
        else if (chk(p))
            return p;
        else{
            answer = recur(p);
            System.out.println(answer);
        }
        return answer;
    }
    public String recur(String s){
        String res = "";
        String u;
        String v;
        if (chk(s) == true)
            return s;
        while (s != ""){
            u = "";
            v = "";
            int left = 0;
            int right = 0;
            for(int i = 0; i<s.length(); i++){
                if (s.charAt(i) == '(')
                    left++;
                else
                    right++;
                if (left == right)
                    break;
            }
            u = s.substring(0, left+right);
            if (left+right+1 <= s.length())
                v = s.substring(left+right, s.length());
            if (chk(u) == true){
                res = u;
                res += recur(v);
            }
            else{
                String temp = "(";
                temp += recur(v);
                temp += ")";
                if (u.length() >= 2)
                {
                    for(int i = 1; i<u.length()-1; i++){
                        if (u.charAt(i) == '(')
                            temp += ")";
                        else
                            temp += "(";
                    }
                }
                return temp;
            }
        }
        return res;
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