package com.acidcarpet.hydroponist.player;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.Fan;
import com.acidcarpet.hydroponist.equipment.Lamp;
import com.acidcarpet.hydroponist.equipment.Pump;
import com.acidcarpet.hydroponist.genered.test_pack.TestFan;
import com.acidcarpet.hydroponist.genered.test_pack.TestLamp;
import com.acidcarpet.hydroponist.genered.test_pack.TestPump;

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

        fan_inventory = new ArrayList<>();
        fan_inventory.add(new TestFan());
        fan_inventory.add(new TestFan());
        fan_inventory.add(new TestFan());
        fan_inventory.add(new TestFan());
        fan_inventory.add(new TestFan());

        pump_inventory = new ArrayList<>();
        pump_inventory.add(new TestPump());
        pump_inventory.add(new TestPump());
        pump_inventory.add(new TestPump());
        pump_inventory.add(new TestPump());
        pump_inventory.add(new TestPump());

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

           refresh_lamp();
       }
    }
    public synchronized void takeoff_lamp(){

        if (Box.getInstance().getLamp()!=null){

            Lamp temp = Box.getInstance().getLamp();
            lamp_inventory.add(temp);
            Box.getInstance().setLamp(null);
        }


        refresh_lamp();

    }
    public synchronized void add_lamp(Lamp lamp){
        lamp_inventory.add(lamp);
        refresh_lamp();

    }
    public synchronized void delete_lamp(Lamp lamp){

        if(lamp_inventory.contains(lamp)){
            lamp_inventory.remove(lamp);
        }


        refresh_lamp();
    }
    public synchronized void refresh_lamp(){
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

    private List<Fan> fan_inventory;
    public synchronized List<Fan> get_fan_inventory(){
        return fan_inventory;
    }
    public synchronized void equip_fan(Fan fan){
        if(fan_inventory.contains(fan)){
            Fan fan_from_box = Box.getInstance().getFan();
            Fan fan_to_box = fan_inventory.get(fan_inventory.indexOf(fan));

            Box.getInstance().setFan(fan_to_box);
            fan_inventory.remove(fan_inventory.indexOf(fan));

            fan_inventory.add(fan_from_box);

            refresh_fan();
        }
    }
    public synchronized void takeoff_fan(){

        if (Box.getInstance().getFan()!=null){

            Fan temp = Box.getInstance().getFan();
            fan_inventory.add(temp);
            Box.getInstance().setFan(null);
        }


        refresh_fan();

    }
    public synchronized void add_fan(Fan fan){
        fan_inventory.add(fan);
        refresh_fan();

    }
    public synchronized void delete_fan(Fan fan){

        if(fan_inventory.contains(fan)){
            fan_inventory.remove(fan);
        }


        refresh_fan();
    }
    public synchronized void refresh_fan(){
        List<Fan> new_array = new ArrayList<>();

        if(!fan_inventory.isEmpty()){

            for (Fan fan : fan_inventory){
                if(fan!=null){
                    new_array.add(fan);
                }
            }

        }
        fan_inventory = new_array;
    }

    private List<Pump> pump_inventory;
    public synchronized List<Pump> get_pump_inventory(){
        return pump_inventory;
    }
    public synchronized void equip_pump(Pump pump){
        if(pump_inventory.contains(pump)){
            Pump pump_from_box = Box.getInstance().getPump();
            Pump pump_to_box = pump_inventory.get(pump_inventory.indexOf(pump));

            Box.getInstance().setPump(pump_to_box);
            pump_inventory.remove(pump_inventory.indexOf(pump));

            pump_inventory.add(pump_from_box);

            refresh_pump();
        }
    }
    public synchronized void takeoff_pump(){

        if (Box.getInstance().getPump()!=null){

            Pump temp = Box.getInstance().getPump();
            pump_inventory.add(temp);
            Box.getInstance().setPump(null);
        }


        refresh_pump();

    }
    public synchronized void add_pump(Pump pump){
        pump_inventory.add(pump);
        refresh_pump();

    }
    public synchronized void delete_pump(Pump pump){

        if(pump_inventory.contains(pump)){
            pump_inventory.remove(pump);
        }


        refresh_pump();
    }
    public synchronized void refresh_pump(){
        List<Pump> new_array = new ArrayList<>();

        if(!pump_inventory.isEmpty()){

            for (Pump pump : pump_inventory){
                if(pump!=null){
                    new_array.add(pump);
                }
            }

        }
        pump_inventory = new_array;
    }








}
