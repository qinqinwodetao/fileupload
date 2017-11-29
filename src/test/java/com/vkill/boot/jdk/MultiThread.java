package com.vkill.boot.jdk;

public class MultiThread extends Thread {


	private volatile String uuid;

	public MultiThread(String uuid) {
		this.uuid = uuid;
	}


	public void run(){

		boolean  stop =  false ;
		while (!stop){
			System.out.println(uuid);
		}
		stop =  true ;


	}


	public static void main(String[] args) {
		MultiThread multiThread = new MultiThread("AAA");
		multiThread.start();
		MultiThread multiThread1 = new MultiThread("BBB");
		multiThread1.start();
		MultiThread multiThread2= new MultiThread("CCC");
		multiThread2.start();
		MultiThread multiThread3 = new MultiThread("DDD");
		multiThread3.start();
	}




}
