import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> arr = new Stack<>();
        arr.push(s.charAt(0));
        for(int i = 1; i<s.length(); i++){
            char ch = s.charAt(i);
            if (!arr.isEmpty() && ch == arr.peek())
                arr.pop();
            else
                arr.push(ch);
        }
        if (arr.isEmpty())
            return 1;
        else
            return 0;
    }
}