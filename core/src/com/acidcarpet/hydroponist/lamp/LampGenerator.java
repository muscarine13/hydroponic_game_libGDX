package com.acidcarpet.hydroponist.lamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        com.acidcarpet.hydroponist.lamp.Type type;
        com.acidcarpet.hydroponist.lamp.EnergyQuality energyQuality;
        com.acidcarpet.hydroponist.lamp.TemperatureQuality temperatureQuality;

        tier = generate_tier();
        type = generate_type();
        energyQuality = generate_energyQuality();
        temperatureQuality = generate_temperatureQuality();

        out = new Lamp(type,tier,temperatureQuality,energyQuality);

        return out;

    }
    public static Lamp generate_random(Tier tier){
        Lamp out;

        com.acidcarpet.hydroponist.lamp.Type type;
        com.acidcarpet.hydroponist.lamp.EnergyQuality energyQuality;
        com.acidcarpet.hydroponist.lamp.TemperatureQuality temperatureQuality;

        type = generate_type();
        energyQuality = generate_energyQuality();
        temperatureQuality = generate_temperatureQuality();

        out = new Lamp(type,tier,temperatureQuality,energyQuality);

        return out;

    }
    public static Lamp generate_random(com.acidcarpet.hydroponist.lamp.Type type){
        Lamp out;

        Tier tier;
        com.acidcarpet.hydroponist.lamp.EnergyQuality energyQuality;
        com.acidcarpet.hydroponist.lamp.TemperatureQuality temperatureQuality;

        tier = generate_tier();
        energyQuality = generate_energyQuality();
        temperatureQuality = generate_temperatureQuality();

        out = new Lamp(type,tier,temperatureQuality,energyQuality);

        return out;
    }
    public static Lamp generate_random(Tier tier, com.acidcarpet.hydroponist.lamp.Type type){
        Lamp out;

        com.acidcarpet.hydroponist.lamp.EnergyQuality energyQuality;
        com.acidcarpet.hydroponist.lamp.TemperatureQuality temperatureQuality;

        energyQuality = generate_energyQuality();
        temperatureQuality = generate_temperatureQuality();

        out = new Lamp(type,tier,temperatureQuality,energyQuality);

        return out;

    }
    public static Lamp generate_random(Tier tier, com.acidcarpet.hydroponist.lamp.Type type, com.acidcarpet.hydroponist.lamp.EnergyQuality energyQuality, com.acidcarpet.hydroponist.lamp.TemperatureQuality temperatureQuality){
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
    private static com.acidcarpet.hydroponist.lamp.Type generate_type(){
        com.acidcarpet.hydroponist.lamp.Type out;

        List<com.acidcarpet.hydroponist.lamp.Type> array = new ArrayList<>();

        for (int i = 0; i< com.acidcarpet.hydroponist.lamp.Type.values().length; i++){
            for (int o = 0; o< com.acidcarpet.hydroponist.lamp.Type.values()[i].chance*multiplier; o++){
                array.add(Type.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
    private static com.acidcarpet.hydroponist.lamp.EnergyQuality generate_energyQuality(){
        com.acidcarpet.hydroponist.lamp.EnergyQuality out;

        List<com.acidcarpet.hydroponist.lamp.EnergyQuality> array = new ArrayList<>();

        for (int i = 0; i< com.acidcarpet.hydroponist.lamp.EnergyQuality.values().length; i++){
            for (int o = 0; o< com.acidcarpet.hydroponist.lamp.EnergyQuality.values()[i].chance*multiplier; o++){
                array.add(EnergyQuality.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
    private static com.acidcarpet.hydroponist.lamp.TemperatureQuality generate_temperatureQuality(){
        com.acidcarpet.hydroponist.lamp.TemperatureQuality out;

        List<com.acidcarpet.hydroponist.lamp.TemperatureQuality> array = new ArrayList<>();

        for (int i = 0; i< com.acidcarpet.hydroponist.lamp.TemperatureQuality.values().length; i++){
            for (int o = 0; o< com.acidcarpet.hydroponist.lamp.TemperatureQuality.values()[i].chance*multiplier; o++){
                array.add(TemperatureQuality.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
}
