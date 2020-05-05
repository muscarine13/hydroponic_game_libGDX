package com.acidcarpet.hydroponist.ref.plant.leave;

public class Leave {

    private LeavesType type;

    private double length;
    private double width;

    public int cm(){
        return (int)(1+(length*width));
    }
    public Leave(LeavesType type) {
        this.type = type;
        length = 1*type.percent_height;
        width = 1*type.percent_width;
    }
    public synchronized void grow(){
        length+=length*type.percent_height;
        width+=width*type.percent_width;
    }

    public int water_consumption(){
        return (int)(cm()*type.water_multiplier);
    }
    public int energy_consumption(){
        return (int)(cm()*type.energy_multiplier);
    }
    public int oxygen_consumption(){
        return (int)(cm()*type.water_multiplier);
    }
    public int minimum_temperature(){
        return type.min_temperature;
    }
    public int maximum_temperature(){
        return type.max_temperature;
    }
    public int dark_energy(){
        return cm()*type.dark_energy;
    }
    public int light_energy(){
        return cm()*type.light_energy;
    }


}
