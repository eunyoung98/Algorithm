import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        ArrayList<String> inter = new ArrayList<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        int flag = 0;
        for(int i = 0; i<str1.length()-1; i++){
            String temp = str1.substring(i, i+2);
            if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z')
            {
                if (temp.charAt(1) >= 'A' && temp.charAt(1) <= 'Z')
                    arr1.add(temp);
            }
        }
        for(int i = 0; i<str2.length()-1; i++){
            String temp = str2.substring(i, i+2);
            if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z')
            {
                if (temp.charAt(1) >= 'A' && temp.charAt(1) <= 'Z')
                    arr2.add(temp);
            }
        }
        if (arr1.size() == 0 && arr2.size() == 0)
            return 65536;
        else{
            int size = arr1.size() + arr2.size();
            for(int i = 0; i<arr1.size(); i++){
                for(int j = 0; j<arr2.size(); j++){
                    if (arr1.get(i).equals(arr2.get(j))){
                        inter.add(arr1.get(i));
                        arr2.remove(j);
                        break;
                    }
                }
            }
            answer = (65536 * inter.size() / (size - inter.size()));
        }
        return (int) answer;
    }
}