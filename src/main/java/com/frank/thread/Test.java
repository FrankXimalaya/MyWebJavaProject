package com.frank.thread;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.itextpdf.text.BadElementException;

public class Test {
	
	public static void main(String[] args) throws BadElementException, MalformedURLException, IOException, InterruptedException {

		final ReadWriteLock lock = new ReentrantReadWriteLock();
		
		
		//首先加读锁
//		new Thread(() -> {
//			
//			lock.readLock().lock();
//			
//			
//			
//		}).start();
		
		
		lock.writeLock().lock();
		
		new Thread(() -> {
			
			lock.readLock().lock();
			System.out.println("异步线程成功获取锁");
			
		}).start();
		
		
		
		
		
		
		System.out.println("这是什么");
		
		
		
		
		
		
	}

}
