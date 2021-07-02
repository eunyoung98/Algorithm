import java.io.*;
import java.util.*;

class Main {
	static int a;
	static int[][] arr;
	static Integer[][] dp;
	static Integer[][] dp2;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		int cnt = 1;
		arr = new int [(a-1)*2+1][a];
		dp = new Integer[(a-1)*2+1][a];
		for(int i = 0; i<a; i++){
			for(int j = 0; j<i+1; j++){
				arr[i][j] = sc.nextInt();
				dp[i][j] = arr[i][j];
			}
		}
		for(int i = a; i<(a-1)*2+1; i++){
			for(int j = 0; j<a-cnt; j++){
				arr[i][j] = sc.nextInt();
				dp[i][j] = arr[i][j];
			}
			cnt++;
		}
		cnt = a-1;
		for(int i = (a-1)*2-1; i>=a-1; i--){
			for(int j = 0; j<=a-cnt; j++){
				if (j == 0)
					dp[i][j] = arr[i][j] + dp[i+1][j];
				else if (j == a-cnt)
					dp[i][j] = arr[i][j] + dp[i+1][j-1];
				else
					dp[i][j] = arr[i][j] + Math.max(dp[i+1][j], dp[i+1][j-1]);
			}
			cnt--;
		}
		dp2 = new Integer[a][a];
		for(int i = 0; i<a; i++){
			dp2[a-1][i] = dp[a-1][i];
		}
		System.out.println(find(0,0));
}
	public static int find(int depth, int idx){
		if (depth == a - 1)
			return dp2[depth][idx];
		if (dp2[depth][idx] == null) {
			dp2[depth][idx] = Math.max(find(depth+1, idx), find(depth+1, idx+1)) + arr[depth][idx];
		}
		return dp2[depth][idx];
	}
}
