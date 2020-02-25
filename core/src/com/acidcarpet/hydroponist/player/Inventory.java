package com.acidcarpet.hydroponist.player;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.Lamp;
import com.acidcarpet.hydroponist.genered.test_pack.TestLamp;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static Inventory instance;
    public static Inventory getInstance(){
        if(instance==null) instance = new Inventory();
        return instance;
    }


    private Inventory(){

        lamp_inventory = new ArrayList<>();
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());




    }

    private List<Lamp> lamp_inventory;
    public synchronized List<Lamp> get_lamp_inventory(){
        return lamp_inventory;
    }
    public synchronized void equip_lamp(Lamp lamp){
       if(lamp_inventory.contains(lamp)){
           Lamp lamp_from_box = Box.getInstance().getLamp();
           Lamp lamp_to_box = lamp_inventory.get(lamp_inventory.indexOf(lamp));


           Box.getInstance().setLamp(lamp_to_box);
           lamp_inventory.remove(lamp_inventory.indexOf(lamp));


           lamp_inventory.add(lamp_from_box);

           refresh();
       }
    }
    public synchronized void takeoff_lamp(){

        if (Box.getInstance().getLamp()!=null){

            Lamp temp = Box.getInstance().getLamp();
            lamp_inventory.add(temp);
            Box.getInstance().setLamp(null);
        }


        refresh();

    }
    public synchronized void add_lamp(Lamp lamp){
        lamp_inventory.add(lamp);
        refresh();

    }
    public synchronized void delete_lamp(Lamp lamp){

        if(lamp_inventory.contains(lamp)){
            lamp_inventory.remove(lamp);
        }


        refresh();
    }
    public synchronized void refresh(){
        List<Lamp> new_array = new ArrayList<>();

        if(!lamp_inventory.isEmpty()){

            for (Lamp lamp : lamp_inventory){
                if(lamp!=null){
                    new_array.add(lamp);
                }
            }

        }
        lamp_inventory = new_array;
    }








}
