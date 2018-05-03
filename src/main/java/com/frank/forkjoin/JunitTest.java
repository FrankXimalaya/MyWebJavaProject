package com.frank.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.junit.Test;

public class JunitTest {
	
	long[] data = new long[100000000];
	
	@Test
	public void testJoinTask() throws InterruptedException, ExecutionException{
		
		
        for(int i=0;i<100000000;i++){
        	data[i]=i+1;
        }
        long startTime = System.nanoTime();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = pool.submit(new Task(data, 0, data.length-1));
		long endTime = System.nanoTime();
        System.out.println(task.get());
		System.out.println("消耗时间为--"+String.valueOf(endTime-startTime));
	}
	
	@Test
	public void noJoinTask(){
		
		 for(int i=0;i<100000000;i++){
	        	data[i]=i+1;
	        }
	     long sum = 0;
	     long startTime = System.nanoTime();
	     for(int i=0;i<100000000;i++){
	    	 sum += data[i];
	     }
	     long endTime = System.nanoTime();
	     System.out.println(sum);
		 System.out.println("消耗时间为--"+String.valueOf(endTime-startTime));
	}
	
	
	
	
	
	

}
