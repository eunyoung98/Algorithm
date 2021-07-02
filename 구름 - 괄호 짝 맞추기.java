import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer> arr;
	static String str;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		arr = new ArrayList<>();
		for(int i = 0; i<str.length(); i++){
			arr.add((int)str.charAt(i));
		}
		while (!arr.isEmpty()){
			int pt = check();
			int i = 0;
			if (pt != -999){
				while (i < 2){
					arr.remove(pt);
					i++;
				}
			}
			else
				break;
		}
		if (arr.isEmpty()){
			System.out.println("True");
		}
		else
			System.out.println("False");
	}
	public static int check(){
		int i = 0;
		int cnt = 0;
		while (i < arr.size()-1){
			cnt = 1;
			Integer temp = arr.get(i);
			Integer temp2 = arr.get(i+1);
			if (temp + 1 == temp2 || temp + 2 == temp2){
				cnt++;
				break;
			}
			i++;
		}
		if (cnt == 2)
			return i;
		else
			return -999;
	}
}