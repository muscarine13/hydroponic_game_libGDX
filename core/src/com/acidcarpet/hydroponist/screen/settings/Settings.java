package com.acidcarpet.hydroponist.screen.settings;

import java.util.Date;

public class Settings {
    private static long last_update;
    public static long getLast_update() {
        return last_update;
    }
    public static void update(){
        last_update = new Date().getTime();
    }

    {
        music = true;
        sound = true;
        vibration = true;
        update();
    }

    private static boolean music;
    private static boolean sound;
    private static boolean vibration;

    public static boolean isMusic() {
        return music;
    }
    public static boolean isSound() {
        return sound;
    }
    public static boolean isVibration() {
        return vibration;
    }

    public static void change_music(){
        if(music==true) music = false;
        else music = true;
        update();
    }
    public static void change_sound(){
        if(sound==true) sound = false;
        else sound = true;
        update();
    }
    public static void change_vibration(){
        if(vibration==true) vibration = false;
        else vibration = true;
        update();
    }


}
