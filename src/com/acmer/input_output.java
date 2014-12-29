package com.acmer;

import java.io.*;

public class input_output {

	public static void main(String[] args) throws IOException {
		
		StreamTokenizer cin=new StreamTokenizer(new InputStreamReader(new FileInputStream("./file/ab.dat")));
		int a,b;
		PrintWriter cout=new PrintWriter(new OutputStreamWriter(System.out));
		while(cin.nextToken()!=StreamTokenizer.TT_EOF){
			a=(int) cin.nval;
			cin.nextToken();
			b=(int) cin.nval;
			cout.println(a+b);
			cout.println();
		}
		cout.flush();
	}

}
