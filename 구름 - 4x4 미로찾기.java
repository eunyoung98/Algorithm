import java.io.*;
import java.util.*;

class Main {
	static int[][] maze;
	static int[][] result;
	static boolean[][] checked;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static Queue<Integer> que_x;
	static Queue<Integer> que_y;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		maze = new int[4][4];
		result = new int[4][4];
		checked = new boolean[4][4];
		for(int i = 0; i<4; i++){
			for(int j = 0; j<4; j++){
				maze[i][j] = sc.nextInt();
			}
		}
		bfs();
		find();
		for(int i = 0; i<4; i++){
			for(int j = 0; j<4; j++){
					System.out.print(" " +result[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void find(){
		int cnt = 1;
		que_x = new LinkedList<>();
		que_y = new LinkedList<>();
		que_x.offer(0);
		que_y.offer(0);
		while (!que_x.isEmpty()){
			int x = que_x.poll();
			int y = que_y.poll();
			if (maze[x][y] == cnt++){
				result[x][y] = 1;
				for(int i = 0; i<4; i++){
					int temp_x = x+dx[i];
					int temp_y = y+dy[i];
					if (temp_x>=0 && temp_y>=0 && temp_x <4 && temp_y<4 &&maze[temp_x][temp_y]==cnt){
						que_x.offer(temp_x);
						que_y.offer(temp_y);
					}
				}
			}
		}
		result[3][3] = 1;
	}
	public static void bfs(){
		que_x = new LinkedList<>();
		que_y = new LinkedList<>();
		que_x.offer(0);
		que_y.offer(0);
		checked[0][0] = true;
		while (!que_x.isEmpty()){
			int x = que_x.poll();
			int y = que_y.poll();
			for(int i = 0; i<4; i++){
				int temp_x = x+dx[i];
				int temp_y = y+dy[i];
				if (temp_x>=0 && temp_y>=0 && temp_x <4 && temp_y<4 &&maze[temp_x][temp_y]==1&&checked[temp_x][temp_y] == false){
					que_x.offer(temp_x);
					que_y.offer(temp_y);
					checked[temp_x][temp_y]= true;
					maze[temp_x][temp_y] = maze[x][y] + 1;
				}
			}
		}
	}
}
