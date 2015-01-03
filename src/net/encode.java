package net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class encode {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String bad=URLEncoder.encode("李刚j2ee","GBK");
		System.out.println(bad);
		String good=URLDecoder.decode(bad,"GBK");
		System.out.println(good);
	}

}
