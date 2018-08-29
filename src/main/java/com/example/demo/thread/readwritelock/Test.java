package com.example.demo.thread.readwritelock;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        final DataCache dataCache =     new DataCache();
        ArrayList<Thread> worker = new ArrayList<>();
        for(int i=0;i<300;i++){
            if(i%2==0){
                Writer writer = new Writer("Write"+i,dataCache);
                worker.add(writer);
            }else{
                Reader reader = new Reader("Reader"+i, dataCache);
                worker.add(reader);
            }
        }

        for(int i=0;i<worker.size();i++){
            worker.get(i).start();
        }
    }
}
