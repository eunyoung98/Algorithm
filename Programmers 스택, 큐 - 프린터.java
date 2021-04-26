import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<priorities.length; i++) {
        	arr.add(priorities[i]);
        }
        while (arr.size() != 0) {
	        int max = arr.get(0);
	        int temp = 0;
	        for(int i = 1; i<arr.size(); i++) {
	        	if (max < arr.get(i)) {
	        		max = arr.get(i);
	        		temp = i;
	        	}
	        }
	        if (temp <= location) {
	    		location= location - temp;
	    	}
	    	else {
	    		location= location + arr.size() -temp;
	    	}
	        
	        int s = 0;
	        while (temp>0) {
	        	arr.add(arr.get(s));
	        	arr.remove(s);
	        	temp--;
	        }
	        arr.remove(0);
	        answer++;
	        location--;
	        if(location == -1) {
	        	break;
	        }
        }
//        for(int i = 0; i<arr.size(); i++) {
//        	System.out.println(arr.get(i));
//        }
        System.out.println(answer);
        return answer;
    }
}
