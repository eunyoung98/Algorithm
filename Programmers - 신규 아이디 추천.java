import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        new_id = remove(new_id);
        new_id = replace_dot(new_id);
        new_id = step_forth(new_id);
        if (new_id.length() >= 16){
            if (new_id.charAt(14) == '.')
                new_id = new_id.substring(0, 14);
            else
                new_id = new_id.substring(0, 15);
        }
        if (new_id.length() <= 2){
            char last = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3){
                new_id += last;
            }
        }
        return new_id;
    }
    public String remove(String id){
        String newid = "";
        for(int i = 0; i<id.length(); i++){
            char idx = id.charAt(i);
            if ((idx >= '0' && idx <= '9') || Character.isLowerCase(idx))
                newid += idx;
            else if (idx == '-' || idx == '_' || idx == '.')
                    newid += idx;
        }
        return newid;
    }
    public String replace_dot(String id){
        String newid = "";
        int cnt = 0;
        for(int i = 0; i<id.length(); i++){
            char idx = id.charAt(i);
            if (idx == '.'){
                cnt = 0;
                for(int j = i; j<id.length(); j++){
                    if (id.charAt(j) == '.')
                        cnt++;
                    else
                        break;
                }
                if (cnt >= 2){
                    i += (cnt - 1);
                    newid += '.';
                    continue;
                }
                else
                    newid += idx;
            }
            else
                newid += idx;
        }
        return newid;
    }
    public String step_forth(String id){
        String answer = "";
        if (id.charAt(0) == '.' && id.length() == 1){
            answer = "a";
        }
        else if(id.charAt(0) == '.'){
            answer = id.replaceFirst(".", "");
        }
        else
            answer = id;
        if (answer.charAt(answer.length() - 1) == '.' && answer.length() == 1)
            answer = "a";
        else if (answer.charAt(answer.length() - 1) == '.')
            answer = answer.substring(0, answer.length() - 1);
        return (answer);
    }
}