package com.chexing.bootstrap;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.apache.coyote.Adapter;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.apache.tomcat.util.buf.ByteChunk;
import org.apache.tomcat.util.net.SocketStatus;

public class MyHandler implements Adapter{

	@Override  
    public void service(Request req, Response res) throws Exception {  
        // 请求处理  
        System.out.println("Hi, Boss. I am handling the reuqest!");  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();     
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(baos));     
        writer.println("Not Hello World");     
        writer.flush();     
    
        ByteChunk byteChunk = new ByteChunk();     
        byteChunk.append(baos.toByteArray(), 0, baos.size());     
        res.doWrite(byteChunk);    
  
    }  
  
    @Override  
    public boolean event(Request req, Response res, SocketStatus status)  
            throws Exception {  
    	if(status.equals(SocketStatus.OPEN_READ)){
    		System.out.println("开始打开阅读！");
    		
    	}else if(status.equals(SocketStatus.OPEN_WRITE)){
    		System.out.println("等待阅读！");
    	}
        System.out.println("Event-Event");  
        return false;  
    }  
  
    @Override  
    public boolean asyncDispatch(Request req, Response res, SocketStatus status)  
            throws Exception {  
        // TODO Auto-generated method stub  
        return false;  
    }  
  
    @Override  
    public void log(Request req, Response res, long time) {  
        // TODO Auto-generated method stub  
  
    }  
  
    @Override  
    public String getDomain() {  
        // TODO Auto-generated method stub  
        return null;  
    }

	@Override
	public void errorDispatch(Request request, Response response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkRecycled(Request req, Response res) {
		// TODO Auto-generated method stub
		
	}  

}
