import java.util.*;

class Solution {
    static Queue<Integer> que_x;
    static Queue<Integer> que_y;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        maze(maps);
        if (visited[maps.length-1][maps[0].length-1] == false)
            return -1;
        else
            return maps[maps.length-1][maps[0].length-1];
    }
    public void maze(int[][] maps){
        que_x = new LinkedList<>();
        que_y = new LinkedList<>();
        que_x.offer(0);
        que_y.offer(0);
        visited[0][0] = true;
        while (!que_x.isEmpty()){
            int x = que_x.poll();
            int y = que_y.poll();
            for(int i = 0; i<4; i++){
                int temp_x = x + dx[i];
                int temp_y = y + dy[i];
                if (temp_x >= 0 && temp_x < maps.length && temp_y >= 0 && temp_y < maps[0].length && maps[temp_x][temp_y] == 1 && visited[temp_x][temp_y] == false){
                    que_x.offer(temp_x);
                    que_y.offer(temp_y);
                    maps[temp_x][temp_y] = maps[x][y] + 1;
                    visited[temp_x][temp_y]= true;
                }
            }
        }
    }
}