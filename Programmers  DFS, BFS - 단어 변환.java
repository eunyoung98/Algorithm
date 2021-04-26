class Solution {
	static int answer;
	static int[] visit;
    public static int solution(String begin, String target, String[] words) {
        answer = words.length + 1;
        visit = new int[words.length];
        int idx = 0;
        dfs(idx, begin, target, words);
        if (answer == words.length + 1) {
        	answer = 0;
        }
        System.out.println(answer);     
        return answer;
    }
    
    public static void dfs(int count, String begin, String target, String[] words) {
		if(begin.equals(target)) {
			if (answer > count)
				answer = count;
			return ;
    	}
    	for(int i = 0; i<words.length; i++) {
    		if (visit[i]==0 && check(begin, words[i])) {
    			visit[i] = 1;
    			dfs(count+1, words[i], target, words);
    			visit[i] = 0;
    		}
    	}
    }
    
    public static boolean check(String begin, String next) {
    	int count = 0;
    	for(int i = 0; i<begin.length(); i++) {
    		if (begin.charAt(i) == next.charAt(i))
    			count++;
    	}
    	if (count == begin.length()-1)
    		return true;
    	else
    		return false;
    }
}
