package com.frank.forkjoin;

import java.util.concurrent.RecursiveTask;

public class Task  extends RecursiveTask<Long>{

	private static final long serialVersionUID = 1L;
	
	//总是要定义一些成员变量来描述怎么操作处理事情
	long[] data;
    int start;
    int end;
	
    private int THRESHOLD = 50;
    
    
    public Task(long[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }
	
	//TODO 有些地方用到了pool，有些地方没有用到pool，这点让本人很诧异，如果使用ForkJoinPool,则直接使用invoke方法就好了

	@Override
	protected Long compute() {
		
		long sum = 0;
		if(end - start < THRESHOLD){
			for (int i = start; i <=end; i++) {
				sum += data[i];
			}
		}else{
			//最关键的任务是怎么分割任务，即怎么用程序语言去描述分割任务
			int middle = (start + end) / 2;
            Task left = new Task(data,start,middle);
            Task right = new Task(data,middle + 1,end);
            left.fork();//fork 操作
            right.fork();//fork 操作
            sum = left.join() + right.join();//join操作
		}
		return sum;
	}

}
