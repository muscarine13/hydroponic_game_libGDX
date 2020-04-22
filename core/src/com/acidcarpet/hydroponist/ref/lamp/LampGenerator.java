package com.acidcarpet.hydroponist.ref.lamp;

import com.acidcarpet.hydroponist.Wrench;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LampGenerator {

    public static void main(String[] args){
        for (int i = 0; i<200;i++){
            Lamp current = generate_random(Tier.TIER_200);
            System.out.println(current.get_name());
            System.out.println(current.get_description());
            System.out.println("_______________________________________");
        }
    }
    private static final int multiplier = 10000;

    public static Lamp generate_random(){
        Lamp out;

        Tier tier;
        Type type;
        EnergyQuality energyQuality;
        TemperatureQuality temperatureQuality;

        tier = generate_tier();
        type = generate_type();
        energyQuality = generate_energyQuality();
        temperatureQuality = generate_temperatureQuality();

        out = new Lamp(type,tier,temperatureQuality,energyQuality);

        return out;

    }
    public static Lamp generate_random(Tier tier){
        Lamp out;

        Type type;
        EnergyQuality energyQuality;
        TemperatureQuality temperatureQuality;

        type = generate_type();
        energyQuality = generate_energyQuality();
        temperatureQuality = generate_temperatureQuality();

        out = new Lamp(type,tier,temperatureQuality,energyQuality);

        return out;

    }
    public static Lamp generate_random(Type type){
        Lamp out;

        Tier tier;
        EnergyQuality energyQuality;
        TemperatureQuality temperatureQuality;

        tier = generate_tier();
        energyQuality = generate_energyQuality();
        temperatureQuality = generate_temperatureQuality();

        out = new Lamp(type,tier,temperatureQuality,energyQuality);

        return out;
    }
    public static Lamp generate_random(Tier tier, Type type){
        Lamp out;

        EnergyQuality energyQuality;
        TemperatureQuality temperatureQuality;

        energyQuality = generate_energyQuality();
        temperatureQuality = generate_temperatureQuality();

        out = new Lamp(type,tier,temperatureQuality,energyQuality);

        return out;

    }
    public static Lamp generate_random(Tier tier, Type type, EnergyQuality energyQuality, TemperatureQuality temperatureQuality){
        Lamp out;

        out = new Lamp(type,tier,temperatureQuality,energyQuality);

        return out;

    }

    private static Tier generate_tier(){
        Tier out;

        out = Tier.values()[Wrench.random_int(0, Tier.values().length-1)];

        return out;
    }
    private static Type generate_type(){
        Type out;

        List<Type> array = new ArrayList<>();

        for (int i = 0; i<Type.values().length; i++){
            for (int o= 0; o<Type.values()[i].chance*10000; o++){
                array.add(Type.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
    private static EnergyQuality generate_energyQuality(){
        EnergyQuality out;

        List<EnergyQuality> array = new ArrayList<>();

        for (int i = 0; i<EnergyQuality.values().length; i++){
            for (int o= 0; o<EnergyQuality.values()[i].chance*10000; o++){
                array.add(EnergyQuality.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
    private static TemperatureQuality generate_temperatureQuality(){
        TemperatureQuality out;

        List<TemperatureQuality> array = new ArrayList<>();

        for (int i = 0; i<TemperatureQuality.values().length; i++){
            for (int o= 0; o<TemperatureQuality.values()[i].chance*10000; o++){
                array.add(TemperatureQuality.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
}
