class Solution {
    public static int[] solution(int[] answers) {
        int count = 0;
        int max;
        int[][] person = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] result = {0, 0, 0};
        for(int i = 0; i<3; i++) {
        	for(int j = 0; j<answers.length; j++)
        	{
        		if (person[i][j % (person[i].length)] == answers[j]) {
        			result[i] = result[i] + 1;
        		}
        	}
        }
        max = result[0];
        for(int i = 0; i<3; i++)
        {
        	if (max <= result[i])
        		max = result[i];
        }
        for(int i = 0; i<3; i++) {
        	if (result[i] == max)
        		count++;
        }
        int[] answer = new int[count];
        count = 0;
        for(int i = 0; i<3; i++) {
        	if (result[i] == max)
        		answer[count++] = i + 1;
        }
        return answer;
    }
}
