import java.util.ArrayList;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] aw = new int[progresses.length];
        ArrayList<Integer> anw = new ArrayList<>();
        int idx = 0;
        int j = 0;
        
        for(int i = 0; i<progresses.length;i++) {
        	if ((100-progresses[i]) % speeds[i] != 0)
        		aw[i] = (100-progresses[i]) / speeds[i]+1;
        	else
        		aw[i] = (100-progresses[i]) / speeds[i];
        }
        while (idx< aw.length) {
        	int temp = aw[idx];
        	int m = 0;
        	for(int i = idx; i<aw.length; i++) {
        		if(temp>=aw[i]) {
        			m++;
        			idx++;
        		}
        		else {
        			break;
        		}	
        	}
        	anw.add(m);
        }
        int[] answer = new int [anw.size()];
        for(int i = 0; i<anw.size(); i++) {
        	answer[i] = anw.get(i);
        	System.out.println(answer[i]);
        }
        return answer;
    }
}
