package com.frank.thread;

import java.util.Random;

public class ThreadScopeShareData {
	
	    private static int data = 0;
	
		public static void main(String[] args) {
			//共启动2个线程
			for(int i=0;i<2;i++){
				//启动一个线程
				new Thread(new Runnable(){
					@Override
					public void run() {
						data = new Random().nextInt();
						System.out.println(Thread.currentThread().getName() 
								+ " has put data :" + data);
						//以当前线程为key值放入到map中，当取值时根据各自的线程取各自的数据
						new A().get();
						new B().get();
					}
				}).start();
			}
		}
	
		static class A{
			public void get(){
				System.out.println("A from " + Thread.currentThread().getName() 
						+ " get data :" + data);
			}
		}
		
		static class B{
			public void get(){
				System.out.println("B from " + Thread.currentThread().getName() 
						+ " get data :" + data);
			}		
		}
}
