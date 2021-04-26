class Solution {
	static int[] dfs_v;
	static int[][] arr;
	static int count = 0;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        arr = new int[n][n];
        dfs_v = new int[n+1];
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j<n; j++) {
        		if(computers[i][j] == 1) {
        			arr[i][j] = 1;
        			arr[j][i] = 1;
        		}
        		else {
        			arr[i][j] = 0;
        		}
        	}
        }
        dfs(0, n);
        count+=1;
        for(int i = 1; i<n; i++) {
        	if (dfs_v[i] == 0) {
        		dfs(i, n);
        		count+=1;
        	}
        }
        System.out.println(count);
        return answer;
    }
    
    static void dfs(int v, int n) {
    	dfs_v[v] = 1;
//    	System.out.println(v);
    	for(int i = 0; i<n; i++) {
    		if(arr[v][i] == 1 && dfs_v[i] == 0) {
//    			System.out.println(i);
    			dfs(i, n);
    		}
    	}
    }
}
