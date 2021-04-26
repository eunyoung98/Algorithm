class Solution {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i<prices.length-1; i++) {
        	int temp = prices[i];
        	for(int j = i+1; j<prices.length;j++) {
        		if (temp<=prices[j]) {
        			answer[i]++;
        		}
        		else {
        			answer[i]=j-i;
        			break;
        		}
        	}
        }
        return answer;
    }
}
