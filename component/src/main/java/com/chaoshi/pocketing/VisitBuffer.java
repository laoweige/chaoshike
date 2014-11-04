package com.chaoshi.pocketing;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class VisitBuffer {
    Queue<String> queue = new ConcurrentLinkedQueue<>();
    private volatile int size=0;
    public void put(String url,String ip){
        if(size>1000){
            return;
        }
        queue.offer(url);
        size++;
    }
    public void post(){


    }
}
