package com.frank.blockingquque;

import static org.hamcrest.CoreMatchers.startsWith;

import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

public class BlockingQueueTest {
	
	@Test
	public void test() throws InterruptedException {
		
		ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
		for(int i=0;i<10;i++) {
			blockingQueue.add(String.valueOf(i));
		}
		
		new Thread(()->{
			try {
				blockingQueue.put("资本主义主义社会");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start(); 
		
		
		
		Thread.sleep(10000);
		
		new Thread(()->{
			try {
				blockingQueue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start(); 
		
		
		Thread.sleep(1000);
		
		System.out.println(blockingQueue.toString());
		
		
	}

}
