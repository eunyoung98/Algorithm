import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] success = new int[N];
        int[] people = new int[N];
        double[] percent = new double[N];
        ArrayList arr = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i<stages.length; i++){
            if (stages[i] > N)
                continue;
            success[stages[i] - 1]++;
        }
        people[0] = stages.length;
        for(int i = 1; i<people.length; i++){
            people[i] = people[i-1] - success[i - 1];
        }
        for(int i = 0; i<people.length; i++){
            if (success[i] == 0)
                percent[i] = 0;
            else
                percent[i] = (double) success[i] / people[i];
            arr.add(percent[i]);
        }
        Collections.sort(arr, Collections.reverseOrder());
        int idx = 0;
        while (idx < N){
            for(int i = 0; i<arr.size(); i++){
                if ((double)arr.get(cnt) == percent[i])
                    answer[idx++] = i + 1;
            }
            cnt = idx;
        }
        return answer;
    }
}