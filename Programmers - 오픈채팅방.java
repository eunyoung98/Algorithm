import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> arr = new ArrayList();
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i<record.length; i++){
            String[] cmd = record[i].split(" ");
            if (cmd[0].equals("Enter")){
                arr.add(cmd[1]+ "님이 들어왔습니다.");
                map.put(cmd[1], cmd[2]);
            }
            else if (cmd[0].equals("Change")){
                map.put(cmd[1], cmd[2]);
            }
            else{
                arr.add(cmd[1]+ "님이 나갔습니다.");
            }
        }
        String[] answer = new String[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            int idx = arr.get(i).indexOf("님");
            String id = arr.get(i).substring(0, idx);
            answer[i] = map.get(id) + arr.get(i).substring(idx, arr.get(i).length());
        }
        return answer;
    }
}