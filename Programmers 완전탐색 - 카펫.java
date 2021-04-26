class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int r;
        int s = yellow;
        r = (brown - 4)/2;
        for(int i = 1; i<r; i++) {
        	for(int j = 1; j<r; j++) {
        		if (i + j == r && i * j == s)
        		{
        			answer[0] = i+2;
        			answer[1] = j+2;
        			break;
        		}
        	}
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }
}
