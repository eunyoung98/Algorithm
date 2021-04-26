import java.util.Scanner;

public class Main {
	static boolean[] visit;
	static int[] result;
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
		result = new int [num];
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = i + 1;
		}
		
		dfs(0, num, len);
	}
	
	public static void dfs(int depth, int num, int r) {
		if (depth == r) {
			print();
			return;
		}
		
		for(int i = 0; i<num; i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[depth] = arr[i];
				dfs(depth+1, num, r);
				visit[i] = false;
			}
		}
	}
	
	public static void print() {
		for(int i = 0; i<len; i++) {
			System.out.print(result[i]+ " ");
		}
		System.out.println();
	}

}
