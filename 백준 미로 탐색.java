import java.util.*;

public class Main {
	static boolean[][] checked;
	static Queue<Integer> que_x;
	static Queue<Integer> que_y;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int m;
	static int n;
	static int[][] maze;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		maze = new int[m][n];
		checked = new boolean[m][n];
		for(int i = 0; i < m; i++) {
		    String temp = sc.next();
		    for(int j = 0; j < n; j++) {
		      maze[i][j] = (int)temp.charAt(j) - 48;
		    }
		}
		bfs();
		System.out.println(maze[m-1][n-1]);
	}
	
	public static void bfs() {
		que_x = new LinkedList<>();
		que_y = new LinkedList<>();
		
		que_x.offer(0);
		que_y.offer(0);
		
		checked[0][0] = true;
		while (!que_x.isEmpty()) {
			int x = que_x.poll();
			int y = que_y.poll();
			
			for(int i = 0; i<4; i++) {
				int temp_x = x + dx[i];
				int temp_y = y + dy[i];
				
				if (temp_x >= 0 && temp_y >=0 && temp_x < m && temp_y <n && maze[temp_x][temp_y] == 1) {
					if (checked[temp_x][temp_y] == false) {
						que_x.offer(temp_x);
						que_y.offer(temp_y);
					}
					checked[temp_x][temp_y] = true;
					
					maze[temp_x][temp_y] = maze[x][y] + 1;
				}
			}
		}
	}
}
