import java.io.*;
import java.util.*;

class Main {
	static int[][] arr;
	static Integer[][] dp;
	static int len;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		len = sc.nextInt();
		arr = new int[len][len];
		for(int i = 0; i<len; i++){
			for(int j = 0; j<i+1; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		dp = new Integer[len][len];
		for(int i = 0; i<len; i++){
			dp[len-1][i] = arr[len-1][i];
		}
		System.out.println(find(0,0));
	}
	public static int find(int depth, int idx){
		if (depth == len - 1)
			return dp[depth][idx];
		if (dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(find(depth+1, idx), find(depth+1, idx+1)) + arr[depth][idx];
		}
		return dp[depth][idx];
	}
}
