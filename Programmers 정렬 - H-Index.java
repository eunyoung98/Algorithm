import java.util.*;

class Solution {
    public static int solution(int[] citations) {
        int answer = 0;
        //int[] - > Integer[]
        Integer[] cit = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(cit , Collections.reverseOrder());
        citations = Arrays.stream(cit).mapToInt(Integer::intValue).toArray();
        for(int i = 0; i<citations.length;i++) {
        	if(citations[i] == i+1) {
        		answer = i+1;
        		break;
        	}
        	else if(citations[i] < i+1)
        	{
        		answer = i;
        		break;
        	}
        	else if (i == citations.length-1)
        		answer = citations.length;
        	else
        		continue;
        }
        return answer;
    }
}
