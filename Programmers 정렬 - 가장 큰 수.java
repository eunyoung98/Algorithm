import java.util.*;

class Solution {
    public static String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = new String[numbers.length];
        for(int i = 0; i<arr.length; i++){
            arr[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);//내림차순
            }
        });
        for(int i = 0; i<arr.length; i++) {
        	answer+=arr[i];
        }
        if(answer.startsWith("0"))
        	answer = "0";
        return answer;
    }
}
