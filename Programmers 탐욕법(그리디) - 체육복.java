class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        for(int i = 0; i<lost.length; i++) {
        	for(int j = 0; j<reserve.length; j++) {
            	if(reserve[j] == lost[i]) {
            		reserve[j] = -999;
            		lost[i] = 999;
            	}
            	if(reserve[j]-1 == lost[i]) {
            		reserve[j] = -999;
            		lost[i] = 999;
            	}
            	if(reserve[j]+1 == lost[i]) {
            		reserve[j] = -999;
            		lost[i] = 999;
            	}
            }
        }
        
        for(int j = 0; j<lost.length; j++) {
        	if(lost[j]!=999) {
        		answer--;
        	}
        }
        System.out.println(answer);
        return answer;
    }
}
