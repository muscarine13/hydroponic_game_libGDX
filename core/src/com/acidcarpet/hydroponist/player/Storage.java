package com.acidcarpet.hydroponist.player;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage instance;
    public static Storage getInstance(){
        if(instance==null) instance = new Storage();
        return instance;
    }
    public static void reset(){
        instance = null;
    }

    Storage(){

        inventory = new ArrayList<>();

    }

    private List<Storable> inventory;
    public synchronized void add_to_inventory(Storable item){
        try{
            inventory.add(item);
        }catch (Exception e){

        }
    }
    public synchronized List<Storable> get_inventory(){
        try{
            return inventory;
        }catch (Exception e){
            return null;
        }
    }
    public synchronized void remove_from_inventory(Storable item){
        try{
            inventory.remove(item);
        }catch (Exception e){

        }
    }

    private Storable current_item;
    public void set_item(int index){
        current_item = inventory.get(index);
    }
    public Storable get_current_item(){
        return current_item;
    }



}
