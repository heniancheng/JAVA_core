package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ip {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InetAddress ip=InetAddress.getByName("www.baidu.cn");
		System.out.println("is reacheable?"+ip.isReachable(2000));
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getCanonicalHostName());
		System.out.println(ip.getHostName());
		
		InetAddress local=InetAddress.getByAddress(new byte[] {127,0,0,1});
		System.out.println("is reacheable?"+local.isReachable(2000));
		System.out.println(local.getCanonicalHostName());
		System.out.println(local.getHostName());
		System.out.println(local.getHostAddress());
	}

}
