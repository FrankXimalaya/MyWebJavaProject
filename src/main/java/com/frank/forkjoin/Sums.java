package com.frank.forkjoin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sums {
	
	static class Sum implements Callable<Long> {

		private final long from;
		private final long to;

		Sum(long from, long to) {
			this.from = from;
			this.to = to;
		}

		@Override
		public Long call() throws InterruptedException {
			Thread.sleep(10000);
			long acc = 0;
			for (long i = from; i <= to; i++) {
				acc = acc + i;
			}
			return acc;
		}
	}
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
        List <Future<Long>> results = executor.invokeAll(Arrays.asList(
            new Sum(0, 10), new Sum(10, 1_000), new Sum(10_00, 1_000_000)
        ));
        executor.shutdown();
        System.out.println("异步还是同步呢");
        
        for (Future<Long> result : results) {
            System.out.println("获得的值:"+result.get());
        }
		
	}

}
