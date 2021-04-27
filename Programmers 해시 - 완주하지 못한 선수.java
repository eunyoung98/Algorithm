import java.util.Arrays;

class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i = 0; i<participant.length-1; i++) {
        	if (!(participant[i].equals(completion[i]))) {
        		System.out.println(participant[i]);
        		return participant[i];
        	}
        }
        System.out.println(participant[participant.length-1]);
        return participant[participant.length-1];
    }
}
