import java.util.Scanner;

public class Main {
	static boolean[] visit;
	static int[] arr;
	static int num;
	static int len;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		len = sc.nextInt();
		visit = new boolean[num];
		arr = new int [num];
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = i + 1;
		}
		
		dfs(0, num, len);
	}
	
	public static void dfs(int start, int num, int r) {
		if (r == 0) {
			print();
			return;
		}
		
		for(int i = start; i<num; i++) {
				visit[i] = true;
				dfs(i+1, num, r-1);
				visit[i] = false;
		}
	}
	
	public static void print() {
		for(int i = 0; i<num; i++) {
			if (visit[i])
				System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}

}
