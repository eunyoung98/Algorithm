import java.util.Arrays;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        for(int i = 0; i<commands.length; i++) {
	       	int a = commands[i][1];
        	int b = commands[i][0];
        	int[] temp = Arrays.copyOfRange(array, b-1, a);
        	Arrays.sort(temp);
        	answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}
