package com.acidcarpet.hydroponist.ref.lamp;

import com.acidcarpet.hydroponist.Wrench;

public class LampGenerator {

    public static Lamp generate_random(){
        Lamp out;

        Tier tier;
        Type type;
        EnergyQuality energyQuality;
        TemperatureQuality temperatureQuality;

        tier = generate_tier();




        out = new Lamp(type,tier,temperatureQuality,energyQuality);

        return out;

    }

    private static Tier generate_tier(){

    }
    private static Tier generate_type(){

    }
    private static Tier generate_energyQuality(){

    }
    private static Tier generate_temperatureQuality(){

    }
}
