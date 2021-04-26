class Solution {
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(numbers, 0, 0, target);
        System.out.println(answer);
        return answer;
    }
    
    public static int dfs(int[] numbers, int node, int sum, int target) {
    	if (node == numbers.length) {
    		if(target == sum)
    			return 1;
    		return 0;
    	}
    	return dfs(numbers, node+1, sum+numbers[node], target)+dfs(numbers, node+1, sum-numbers[node], target);
    }
}
