package com.acidcarpet.hydroponist.ref.lamp;

import com.acidcarpet.hydroponist.Wrench;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LampGenerator {

    private static final int multiplier = 100;


    public static void main(String[] args){
        int I = 0;
        int II = 0;
        int III = 0;
        int IV = 0;
        int V = 0;
        int VI = 0;
        int VII = 0;
        int VIII = 0;
        int IX = 0;
        int X = 0;

        for (int i = 0; i<2000;i++){
            Lamp current = generate_random();

            switch (current.getTier()){
                case TIER_100: I++; break;
                case TIER_200: II++; break;
                case TIER_300: III++; break;
                case TIER_400: IV++; break;
                case TIER_500: V++; break;
                case TIER_600: VI++; break;
                case TIER_700: VII++; break;
                case TIER_800: VIII++; break;
                case TIER_900: IX++; break;
                case TIER_1000: X++; break;

            }
            System.out.println(current.get_name());
            System.out.println(current.get_description());
            System.out.println("_______________________________________");
        }
        System.out.println("I   "+I);
        System.out.println("II  "+II);
        System.out.println("III "+III);
        System.out.println("IV  "+IV);
        System.out.println("V   "+V);
        System.out.println("VI  "+VI);
        System.out.println("VII "+VII);
        System.out.println("VIII"+VIII);
        System.out.println("IX  "+IX);
        System.out.println("X   "+X);

    }


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

        List<Tier> array = new ArrayList<>();

        for (int i = 0; i<Tier.values().length; i++){
            for (int o= 0; o<Tier.values()[i].chance*multiplier; o++){
                array.add(Tier.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);

        return out;
    }
    private static Type generate_type(){
        Type out;

        List<Type> array = new ArrayList<>();

        for (int i = 0; i<Type.values().length; i++){
            for (int o= 0; o<Type.values()[i].chance*multiplier; o++){
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
            for (int o= 0; o<EnergyQuality.values()[i].chance*multiplier; o++){
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
            for (int o= 0; o<TemperatureQuality.values()[i].chance*multiplier; o++){
                array.add(TemperatureQuality.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
}
