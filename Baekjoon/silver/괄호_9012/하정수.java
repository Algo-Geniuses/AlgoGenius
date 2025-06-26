package 강송이하홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			char[] ps = br.readLine().toCharArray();
			int start = 0;
			boolean able = true;
			for(char input : ps) {
				if(input == '(')
					start++;
				else {
					if(start == 0) able = false;
					else start--;
				}
			}
			if(start != 0) able = false;
			if(able)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
