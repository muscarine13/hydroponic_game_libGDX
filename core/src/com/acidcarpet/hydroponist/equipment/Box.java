package com.acidcarpet.hydroponist.equipment;


import com.acidcarpet.hydroponist.genered.test_pack.*;
import com.acidcarpet.hydroponist.plant.Plant;
import com.acidcarpet.hydroponist.storage.Inventory;


import java.util.Date;

public class Box {

    private static long last_update;
    public static synchronized void update(){
        last_update = new Date().getTime();
    }
    public static long get_last_update(){
        return last_update;
    }

    private static Box instance;
    public static Box getInstance(){
        if(instance==null) instance = new Box();
        return instance;
    }

    private double box_ordinary_temperature;

    private Lamp lamp;
    private Fan fan;

    private Plant plant;
    private Pot pot;
    private Pump pump;

    public Box(
    ){

        this.box_ordinary_temperature = 24;
        this.lamp = TestPack.getInstance().get_test_lamp();
        this.fan = TestPack.getInstance().get_test_fan();
        this.pot = TestPack.getInstance().get_test_pot();
        this.pump = TestPack.getInstance().get_test_pump();

        this.plant = TestPack.getInstance().get_test_plant();

        last_update = new Date().getTime();
    }

    public double actual_t(){
        return box_ordinary_temperature +lamp.getT_add()-fan.getT_reduce();
    }

    public Lamp getLamp() {
        return lamp;
    }
    public Fan getFan() {
        return fan;
    }
    public Plant getPlant() {
        return plant;
    }
    public Pot getPot() {
        return pot;
    }
    public Pump getPump() {
        return pump;
    }

    public void setLamp(Lamp lamp) {
        this.lamp = lamp;
    }
    public void setFan(Fan fan) {
        this.fan = fan;
    }
    public void setPlant(Plant plant) {
        this.plant = plant;
    }
    public void setPot(Pot pot) {
        this.pot = pot;
    }
    public void setPump(Pump pump) {
        this.pump = pump;
    }

    public synchronized void equip(Lamp lamp) {
        if(this.lamp!=null){
            take_off_lamp();
        }
        this.lamp = lamp;
        Inventory.getInstance().delete(lamp);

        last_update = new Date().getTime();
    }
    public synchronized void equip(Fan fan) {
        if(this.fan!=null){
            take_off_fan();
        }
        this.fan = fan;
        Inventory.getInstance().delete(fan);

        last_update = new Date().getTime();
    }
    public synchronized void equip(Plant plant) {
        kill_plant();
        this.plant = plant;
        last_update = new Date().getTime();
    }
    public synchronized void equip(Pot pot) {
        if(this.pot!=null){
            take_off_pot();
        }
        this.pot = pot;
        Inventory.getInstance().delete(pot);

        last_update = new Date().getTime();
    }
    public synchronized void equip(Pump pump) {
        if(this.pump!=null){
            take_off_pump();
        }
        this.pump = pump;
        Inventory.getInstance().delete(pump);

        last_update = new Date().getTime();
    }

    public synchronized void take_off_lamp() {
        if(lamp!=null)Inventory.getInstance().add(lamp);
        lamp=null;
        last_update = new Date().getTime();
    }
    public synchronized void take_off_fan() {
        if(fan!=null)Inventory.getInstance().add(fan);
        fan=null;
        last_update = new Date().getTime();
    }
    public synchronized void kill_plant() {
        plant=null;
        last_update = new Date().getTime();
    }
    public synchronized void take_off_pot() {
        if(pot!=null)Inventory.getInstance().add(pot);
        pot=null;
        last_update = new Date().getTime();
    }
    public synchronized void take_off_pump() {
        if(pump!=null)Inventory.getInstance().add(pump);
        pump=null;
        last_update = new Date().getTime();
    }
    public synchronized void harvest_plant(){

        plant=null;
        last_update = new Date().getTime();
    }

}
