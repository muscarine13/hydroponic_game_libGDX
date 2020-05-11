package com.acidcarpet.hydroponist.storage;

import java.util.*;

public class Inventory {


    private static Inventory instance;
    public static Inventory getInstance(){
        if(instance==null) instance = new Inventory();
        return instance;
    }
    private static long last_update;
    public static long last_update(){
        return last_update;
    }
    public static void update(){
        last_update = new Date().getTime();
    }

    private Map<String, List<Storable>> storage;
    private int gold;
    private int diamond;

    private Inventory(){

        last_update = new Date().getTime();

        storage = new HashMap<>();

        List<com.acidcarpet.hydroponist.storage.Storable> lamp_array = new ArrayList<>();
        storage.put(Type.LAMP.line, lamp_array);

        List<com.acidcarpet.hydroponist.storage.Storable> fan_array = new ArrayList<>();
        storage.put(Type.FAN.line, fan_array);

        List<com.acidcarpet.hydroponist.storage.Storable> bottle_array = new ArrayList<>();
        storage.put(Type.BOTTLE.line, bottle_array);


        gold = 155850;
        diamond = 5670;


    }

    public synchronized void add(Storable item_to_add){

        Type item_type = null;

       item_type = item_to_add.getStorableType();


        if(item_type!=null){
           switch (item_type){
               case LAMP:   storage.get(Type.LAMP.line).add(item_to_add);  break;
               case FAN:    storage.get(Type.FAN.line).add(item_to_add);   break;

               case BOTTLE: storage.get(Type.BOTTLE.line).add(item_to_add);break;
               default:
           }
        }

        update();

    }
    public synchronized void delete(Type type, int index){
        if(type!=null){
            switch (type){
                case LAMP:   storage.get(Type.LAMP.line).remove(index);  break;
                case FAN:    storage.get(Type.FAN.line).remove(index);   break;

                case BOTTLE: storage.get(Type.BOTTLE.line).remove(index);break;
                default:
            }
        }
        update();
    }
    public synchronized void delete(Storable item){
        if(item==null) return;

        Iterator<Map.Entry<String, List<Storable>>> it = storage.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, List<Storable>> pair = it.next();

            try{
                if(pair.getValue().remove(item)) return;
            }catch (Exception e){

            }
        }
        update();
    }
    public synchronized Storable get(Type type, int index){
        if(type!=null){
            switch (type){
                case LAMP:   return storage.get(Type.LAMP.line).get(index);
                case FAN:    return storage.get(Type.FAN.line).get(index);

                case BOTTLE: return storage.get(Type.BOTTLE.line).get(index);
                default: return null;
            }
        }else{
            return null;
        }
    }
    public synchronized Storable get_and_remove(Type type, int index){
        update();
        if(type!=null){
            switch (type){
                case LAMP:   return storage.get(Type.LAMP.line).remove(index);
                case FAN:    return storage.get(Type.FAN.line).remove(index);

                case BOTTLE: return storage.get(Type.BOTTLE.line).remove(index);
                default: return null;
            }
        }else{
            return null;
        }

    }
    public synchronized List<Storable> get_list(Type type){
        if(type!=null){
            switch (type){
                case LAMP:   return storage.get(Type.LAMP.line);
                case FAN:    return storage.get(Type.FAN.line);

                case BOTTLE: return storage.get(Type.BOTTLE.line);
                default: return null;
            }
        }else{
            return null;
        }
    }

    public synchronized int getGold() {
        return gold;
    }
    public synchronized void setGold(int gold) {
        this.gold = gold;
        update();
    }
    public synchronized int getDiamond() {
        return diamond;
    }
    public synchronized void setDiamond(int diamond) {
        this.diamond = diamond;
        update();
    }



}
