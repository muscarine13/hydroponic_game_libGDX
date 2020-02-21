package com.acidcarpet.hydroponist.player;

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
    public static void reset(){
        instance = null;
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
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());
        lamp_inventory.add(new TestLamp());



    }

    private List<Lamp> lamp_inventory;

    public List<Lamp> get_lamp_inventory(){
        return lamp_inventory;
    }







}
