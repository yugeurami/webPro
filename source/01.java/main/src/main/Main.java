package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try {
			InputStream in = System.in;
			InputStreamReader ir = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(ir);
			
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0 ; i < N ; i++) {
				String str = br.readLine();
				int target = str.indexOf(" ");
				int result = Integer.parseInt(str.substring(0, target))+Integer.parseInt(str.substring(target+1));
				sb.append(result+"\n");
			}
			br.close();
			System.out.println(sb);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
