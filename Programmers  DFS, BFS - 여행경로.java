import java.util.ArrayList;
import java.util.Collections;

class Solution {
	static ArrayList<String> answers;
	static int[] visit;
	static int count;
    public static String[] solution(String[][] tickets) {
        visit = new int[tickets.length];
    	answers = new ArrayList<>();
        count = 0;
        dfs(count, "ICN", "ICN", tickets);
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        for(int i = 0; i<answer.length; i++) {
        	System.out.println(answer[i]);
        }
        return answer;
    }
    
    public static void dfs(int count, String cur, String answer, String[][] tickets) {
    	if(count == tickets.length) {
    		answers.add(answer);
    		return;
    	}
    	
    	for(int i = 0; i<tickets.length; i++) {
    		if (visit[i] == 0 && cur.equals(tickets[i][0])) {
    			visit[i] = 1;
    			dfs(count+1, tickets[i][1], answer+" "+ tickets[i][1], tickets);
    			visit[i] = 0;
    		}
    	}
    }
}
