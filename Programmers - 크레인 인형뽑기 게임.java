import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> arr = new Stack<>();
        int cnt = 0;
        int idx = 0;
        while (cnt++ < moves.length){
            for(int i = 0; i<board.length; i++){
                if (board[i][moves[idx]-1] != 0){
                    if (!arr.isEmpty() && arr.peek() == board[i][moves[idx]-1]){
                        arr.pop();
                        answer += 2;
                    }
                    else{
                        arr.push(board[i][moves[idx]-1]);
                    }
                    board[i][moves[idx]-1] = 0;
                    break;
                }
            }
            idx++;
        }
        return answer;
    }
}