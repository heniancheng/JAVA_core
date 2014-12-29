package com.thread.base;

public class DrawMoney {
	public static void main(String[] args){
		Account acc=new Account("hechen",1000);
		DrawThread drawthead1=new DrawThread("thread1",acc,800);
		DrawThread drawthead2=new DrawThread("thread2",acc,800);
		drawthead1.start();
		drawthead2.start();
	}

}

class Account{
	private String AccountName;
	private long balance;
	Account(String name,long money){
		AccountName=name;
		balance=money;
	}
	
	Account(String name){
		AccountName=name;
		balance=0;
	}
	public void setBalance(long money){
		balance=balance+money;
	}
	public long getBalance(){
		return balance;
	}
	public long DrawBalance(long money){
		return balance=balance-money;
	}
	public synchronized void draw(long money){
		if (this.getBalance() > money) {
			System.out.println(Thread.currentThread().getName()+" 取钱成功，取了：" + money);
			// try{
			// Thread.sleep(1000);
			// }catch(InterruptedException error){
			// error.printStackTrace();
			// }
			this.DrawBalance(money);
			System.out.println(this.AccountName + " 余额为：" + this.getBalance());
		} else
			System.out.println(Thread.currentThread().getName()+" 取钱失败，余额不足");
	}
}

class DrawThread extends Thread{
	private Account account;
	private long drawMoney;
	DrawThread(String name,Account acc,long drawmoney){
		super(name);
		account=acc;
		this.drawMoney=drawmoney;
	}
	public void run(){
		account.draw(this.drawMoney);
	}
}
