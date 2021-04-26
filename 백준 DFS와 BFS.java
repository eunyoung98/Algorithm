import java.util.Scanner;

public class Main {
	static int[][] graph;
	static int[] visit;
	static int[] que;
	static int[] visit2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		graph = new int[n+1][n+1];
		visit = new int[n+1];
		que = new int [n+1];
		visit2 = new int [n+1];
		for(int j = 0; j<m; j++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		dfs(v, n);
		System.out.println();
		bfs(v, n);
	}
	
	public static void dfs(int v, int n) {
		System.out.print(v + " ");
		visit[v] = 1;
		
		for(int i = 1; i<=n; i++) {
			if(visit[i] == 0 && graph[v][i] == 1) {
				dfs(i, n);
			}
		}
	}
	
	public static void bfs(int v, int n) {
		int front = 0;
		int rear = 0;
		int pop;
		
		que[0] = v;
		System.out.print(v + " ");
		rear++;
		visit2[v] = 1;
		while (front<rear) {
			pop = que[front];
			front++;
			for(int i = 1; i<=n; i++) {
				if (graph[pop][i] == 1 && visit2[i] == 0) {
					System.out.print(i + " ");
					que[rear] = i;
					rear++;
					visit2[i] = 1;
				}
			}
		}
		System.out.println();
		
	}

}
