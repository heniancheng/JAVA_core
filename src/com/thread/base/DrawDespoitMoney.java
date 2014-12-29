package com.thread.base;

public class DrawDespoitMoney {
	public static void main(String[] args){
		Account2 acc=new Account2("hechen");
		DrawThread2 draw1=new DrawThread2("draw1",acc,800);
		DespoitThread despoit1=new DespoitThread("despoit1",acc,800);
		DespoitThread despoit2=new DespoitThread("despoit2",acc,800);
		draw1.start();
		despoit1.start();
		despoit2.start();
	}

}

class Account2{
	private String AccountName;
	private long balance;
	private boolean flag;
	private int drawcount=0;
	private int despoitcount=0;
	
	public int getDrawCount(){
		return drawcount;
	}
	
	public int getDespoitCount(){
		return despoitcount;
	}
	
	Account2(String name,long money){
		AccountName=name;
		balance=money;
		flag=false;
	}
	
	Account2(String name){
		AccountName=name;
		balance=0;
		flag=false;
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
		try {
			if (!flag) {
				System.out.println(Thread.currentThread().getName()+" get the lock");
				wait();
			} else {
				if (this.getBalance() >= money) {
					this.drawcount++;
					System.out.println(Thread.currentThread().getName()+ " draw "+this.drawcount);
					System.out.println(Thread.currentThread().getName()
							+ " 取钱成功，取了：" + money);
					this.DrawBalance(money);
					System.out.println(this.AccountName + " 余额为："
							+ this.getBalance());
					flag=false;
					notifyAll();
					System.out.println(Thread.currentThread().getName() + " to give up");
				} else
					System.out.println(Thread.currentThread().getName()
							+ " 取钱失败，余额不足");
			}
		} catch (InterruptedException err) {
			err.printStackTrace();
		}
	}
	public synchronized void despoit(long money){
		try{
			if(flag){
				System.out.println(Thread.currentThread().getName()+" get the lock");
				wait();
			}
			else{
				this.despoitcount++;
				System.out.println(Thread.currentThread().getName()+ " despoit "+this.despoitcount);
				System.out.println(Thread.currentThread().getName()
						+ " 存款了：" + money);
				this.balance=this.balance+money;
				System.out.println(this.AccountName + " 余额为："
						+ this.getBalance());
				flag=true;
				notifyAll();
				System.out.println(Thread.currentThread().getName() + " to give up");
			}
		}catch(InterruptedException err){
			err.printStackTrace();
		}
	}
}

class DrawThread2 extends Thread{
	private Account2 account;
	private long drawMoney;
	DrawThread2(String name,Account2 acc,long drawmoney){
		super(name);
		account=acc;
		this.drawMoney=drawmoney;
	}
	public void run(){
		for(int i=0;i<3;i++){
		System.out.println(Thread.currentThread().getName()+" run the "+(i+1)+" times");
		account.draw(this.drawMoney);
		}
	}
}
class DespoitThread extends Thread{
	private Account2 account;
	private long despoitmoney;
	DespoitThread(String name,Account2 acc,long money){
		super(name);
		this.account=acc;
		this.despoitmoney=money;
	}
	public void run(){
		for(int i=0;i<3;i++){
		System.out.println(Thread.currentThread().getName()+" run the "+(i+1)+" times");
		account.despoit(this.despoitmoney);
		}
	}
}