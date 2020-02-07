package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.equipment.Box;

public abstract class Leave {

    Box box;
    private boolean alive;

    private double height;
    private double width;

    private double height_grow_length;
    private double width_grow_length;

    private double energy_production;
    private double water_consumption;

    private double CO2_consumption;

    private double t_minimum;
    private double t_maximum;

    private double lm_consumption;

    private int current_health;
    private int maximum_health;

    public Leave(
            int maximum_health,
            double height,
            double width,

            double height_grow_length,
            double width_grow_length,
            double energy_production,
            double water_consumption,

            double CO2_consumption,
            double t_minimum,
            double t_maximum,
            double lm_consumption
    ){

        alive = true;
        this.maximum_health = maximum_health;
        this.current_health = maximum_health/2;

        this.height = height;
        this.width = width;

        this.height_grow_length = height_grow_length;
        this.width_grow_length = width_grow_length;
        this.energy_production = energy_production;
        this.water_consumption = water_consumption;

        this.CO2_consumption = CO2_consumption;
        this.t_minimum = t_minimum;
        this.t_maximum = t_maximum;
        this.lm_consumption = lm_consumption;

    }

    void photosynthesis(){
        if(!alive) return;

        double actual_water_consumption = water_consumption * (int)(height*width);
        if(
                        box.getPlant().drink(actual_water_consumption)
                        &&
                        box.getFan().reduce_CO2(CO2_consumption *(int)(height*width))
                        &&
                        (box.actual_t()< t_maximum &&box.actual_t()> t_minimum)

                ){

            current_health++;
            if (current_health>maximum_health) current_health = maximum_health;

            if(box.getLamp().isOn()&&box.getLamp().reduce_lm(lm_consumption *(int)(height*width))){
                box.getPlant().add_light_energy( energy_production * (int)(height*width));
            }else{
               box.getPlant().add_dark_energy( energy_production * (int)(height*width));
            }

        }else{

           current_health--;
           if(current_health<0) alive=false;

        }



    }
    void grow(){
        if(!alive) return;

        height+= height_grow_length;
        width+= width_grow_length;
    }

    abstract String name();
    abstract String description();

}
