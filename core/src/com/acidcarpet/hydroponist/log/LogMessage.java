package com.acidcarpet.hydroponist.log;

import java.util.Date;

public class LogMessage {

    Type type;
    String thread_name;
    String class_name;
    String message;
    long date;

    public LogMessage(Type type,  String message, String thread_name, String class_name) {
        this.type = type;
        this.thread_name = thread_name;
        this.class_name = class_name;
        this.message = message;
        date = new Date().getTime();
    }

    public enum Type{
        NORMAL,
        ERROR,
        DEBUG,
        WARNING,
        VERBOSE,
        INFO
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "type=" + type +
                ", thread_name='" + thread_name +
                ", class_name='" + class_name +
                ", message='" + message +
                ", date=" + date +
                '}';
    }
}
