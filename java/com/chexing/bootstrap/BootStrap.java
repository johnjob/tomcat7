package com.chexing.bootstrap;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.coyote.http11.Http11Protocol;

public class BootStrap {
	public static void main(String[] args) throws Exception{  
        Http11Protocol hp = new Http11Protocol();  
        hp.setPort(9000);  
        ThreadPoolExecutor threadPoolExecutor = createThreadPoolExecutor();  
        threadPoolExecutor.prestartCoreThread();  
        hp.setExecutor(threadPoolExecutor);  
        hp.setAdapter(new MyHandler());  
        hp.init();  
        hp.start();  
        System.out.println("My Server has started successfully!");  
          
  
    }  
	
	 public static ThreadPoolExecutor createThreadPoolExecutor() {  
	        int corePoolSite = 2 ;  
	        int maxPoolSite = 10 ;  
	        long keepAliveTime = 60 ;  
	        TimeUnit unit = TimeUnit.SECONDS;  
	        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();  
	        ThreadPoolExecutor threadPoolExecutor =   
	                new ThreadPoolExecutor(corePoolSite, maxPoolSite,  
	                        keepAliveTime, unit, workQueue);  
	        return threadPoolExecutor;  
	    }  
}
