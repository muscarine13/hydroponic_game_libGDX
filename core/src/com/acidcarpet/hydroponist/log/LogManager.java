package com.acidcarpet.hydroponist.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogManager {
    Map<LogMessage.Type, List<LogMessage>> log;
    private static LogManager instance;
    public static LogManager getInstance(){
        if(instance==null) instance = new LogManager();
        return instance;
    }
    private LogManager(){

        log = new HashMap<>();

        for(LogMessage.Type type : LogMessage.Type.values()){
            log.put(type, new ArrayList<LogMessage>());
        }


    }

    public void add(LogMessage.Type type, String message, String thread_name, String class_name){
        LogMessage created = new LogMessage(type,message, thread_name, class_name);

        log.get(type).add(created);
        System.err.println(created.toString());
    }
}
