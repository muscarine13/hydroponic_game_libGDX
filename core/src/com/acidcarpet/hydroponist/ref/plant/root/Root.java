package com.acidcarpet.hydroponist.ref.plant.root;

import com.acidcarpet.hydroponist.Wrench;

public class Root {

    private double length;
    private int side_roots;
    private RootsType type;

    public Root(RootsType type) {
        this.type = type;
        length = 1+1*type.length;
        side_roots++;
    }
    public void grow(){

        if(Wrench.try_percent(25)){
            length+=length*type.length;
        }
        if(Wrench.try_percent(5)){
            if(side_roots<side_roots){
                side_roots++;
            }
        }

    }
    public double min_pH(){
        return type.ph_min;
    }
    public double max_pH(){
        return type.ph_max;
    }
    public int water_production(){
        int out = 0;
        out+=length;
        out+=side_roots;
        return out;
    }
}
