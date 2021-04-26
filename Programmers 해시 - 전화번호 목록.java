import java.util.Arrays;

class Solution {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 1; i<phone_book.length; i++){
                if (phone_book[i].startsWith(phone_book[0]))
                    return false;
        }
        return true;
    }
}

