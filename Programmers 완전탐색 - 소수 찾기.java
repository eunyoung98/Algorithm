import java.util.*;

class Solution {
	public static String[] map;
	public static String[] result;
	public static boolean[] visit;
	public static HashSet<Integer> list;
    public static int solution(String numbers) {
    	
    	map = new String [numbers.length()];
    	map = numbers.split("");
    	visit = new boolean [numbers.length()];
    	list = new HashSet();
    	for(int i = 1; i<=numbers.length(); i++) {
    		result = new String[i];
    		cycle(0, i, numbers.length());
    	}
    	System.out.println(list.size());
    	return list.size();
    }
    
    static void cycle(int start, int end, int length) {
    	if (start == end) {
    		prime();
    	}
    	
    	else {
    		for(int i = 0; i<length; i++)
    		{
    			if (visit[i] != true) {
    				visit[i] = true;
    				result[start] = map[i];
    				cycle(start+1, end, length);
    				visit[i] = false;
    			}
    		}
    	}
    }
    
    static void prime() {
    	String str = "";
    	for(int i = 0; i<result.length; i++) {
    		str+=result[i];
    	}
    	int num = Integer.parseInt(str);
    	if (num<=1)
    		return ;
    	boolean flag = false;
    	if (num == 2)
    		list.add(num);
    	else
    	{
    		for(int s = 2; s<=Math.sqrt(num); s++) {
    			if (num % s == 0) {
    				flag = true;
    			}
    		}
    		if (flag!=true) {
    			list.add(num);
    		}
    	}
    }
       
}
