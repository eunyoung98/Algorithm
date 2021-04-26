import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int max = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i<truck_weights.length; i++) {
        	while (true) {
        		if (que.isEmpty()) {
        			que.offer(truck_weights[i]);
        			max += truck_weights[i];
        			answer++;
        			break;
        		}
        		else if(que.size()==bridge_length) {
        			max -= que.poll();
        		}
        		else {
        			if (max + truck_weights[i] > weight) {
        				que.offer(0);
        				answer++;
        			}
        			else {
        				que.offer(truck_weights[i]);
        				max+=truck_weights[i];
        				answer++;
        				break;
        			}
        		}
        		
        	}
        }
        System.out.println(answer+bridge_length);
        return answer + bridge_length;
    }
}
