package com.acidcarpet.hydroponist.bottle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BottleGenerator {

    public final int multiplier = 1000;
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
            Bottle current = new BottleGenerator().generate_bottle();

            System.out.println(current.name());
            System.out.println(current.description());
            System.out.println("_______________________________________");
        }


    }

    public Bottle generate_bottle(){

        VolumeType volume_type = generate_volume_type();
        PurityType purityType = generate_purity_type();

        MacroPrimaryType macroPrimaryType = generate_macro_primary_type();
        MacroSecondaryType macroSecondaryType = generate_macro_secondary_type();
        MicroPrimaryType microPrimaryType = generate_micro_primary_type();
        MicroSecondaryType microSecondaryType = generate_micro_secondary_type();

        return
                new Bottle(volume_type,purityType,macroPrimaryType,macroSecondaryType,microPrimaryType,microSecondaryType);


    }
    public Bottle generate_bottle(VolumeType volumeType){


        PurityType purityType = generate_purity_type();

        MacroPrimaryType macroPrimaryType = generate_macro_primary_type();
        MacroSecondaryType macroSecondaryType = generate_macro_secondary_type();
        MicroPrimaryType microPrimaryType = generate_micro_primary_type();
        MicroSecondaryType microSecondaryType = generate_micro_secondary_type();

        return
                new Bottle(volumeType,purityType,macroPrimaryType,macroSecondaryType,microPrimaryType,microSecondaryType);


    }
    public Bottle generate_bottle(PurityType purityType){

        VolumeType volume_type = generate_volume_type();


        MacroPrimaryType macroPrimaryType = generate_macro_primary_type();
        MacroSecondaryType macroSecondaryType = generate_macro_secondary_type();
        MicroPrimaryType microPrimaryType = generate_micro_primary_type();
        MicroSecondaryType microSecondaryType = generate_micro_secondary_type();

        return
                new Bottle(volume_type,purityType,macroPrimaryType,macroSecondaryType,microPrimaryType,microSecondaryType);


    }
    public Bottle generate_bottle(MacroPrimaryType macroPrimaryType){

        VolumeType volume_type = generate_volume_type();
        PurityType purityType = generate_purity_type();


        MacroSecondaryType macroSecondaryType = generate_macro_secondary_type();
        MicroPrimaryType microPrimaryType = generate_micro_primary_type();
        MicroSecondaryType microSecondaryType = generate_micro_secondary_type();

        return
                new Bottle(volume_type,purityType,macroPrimaryType,macroSecondaryType,microPrimaryType,microSecondaryType);


    }
    public Bottle generate_bottle(MacroSecondaryType macroSecondaryType){

        VolumeType volume_type = generate_volume_type();
        PurityType purityType = generate_purity_type();

        MacroPrimaryType macroPrimaryType = generate_macro_primary_type();
        MicroPrimaryType microPrimaryType = generate_micro_primary_type();
        MicroSecondaryType microSecondaryType = generate_micro_secondary_type();

        return
                new Bottle(volume_type,purityType,macroPrimaryType,macroSecondaryType,microPrimaryType,microSecondaryType);


    }
    public Bottle generate_bottle(MicroPrimaryType microPrimaryType){

        VolumeType volume_type = generate_volume_type();
        PurityType purityType = generate_purity_type();

        MacroPrimaryType macroPrimaryType = generate_macro_primary_type();
        MacroSecondaryType macroSecondaryType = generate_macro_secondary_type();
        MicroSecondaryType microSecondaryType = generate_micro_secondary_type();

        return
                new Bottle(volume_type,purityType,macroPrimaryType,macroSecondaryType,microPrimaryType,microSecondaryType);


    }
    public Bottle generate_bottle(MicroSecondaryType microSecondaryType){

        VolumeType volume_type = generate_volume_type();
        PurityType purityType = generate_purity_type();

        MacroPrimaryType macroPrimaryType = generate_macro_primary_type();
        MacroSecondaryType macroSecondaryType = generate_macro_secondary_type();
        MicroPrimaryType microPrimaryType = generate_micro_primary_type();


        return
                new Bottle(volume_type,purityType,macroPrimaryType,macroSecondaryType,microPrimaryType,microSecondaryType);


    }
    public Bottle generate_bottle(VolumeType volumeType, PurityType purityType, MacroPrimaryType macroPrimaryType, MacroSecondaryType macroSecondaryType, MicroPrimaryType microPrimaryType, MicroSecondaryType microSecondaryType){
        return
                new Bottle(volumeType,purityType,macroPrimaryType,macroSecondaryType,microPrimaryType,microSecondaryType);


    }

    public VolumeType generate_volume_type(){
        VolumeType out;

        List<VolumeType> array = new ArrayList<>();

        for (int i = 0; i< VolumeType.values().length; i++){
            for (int o = 0; o< VolumeType.values()[i].chance*multiplier; o++){
                array.add(VolumeType.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
    public PurityType generate_purity_type(){
        PurityType out;

        List<PurityType> array = new ArrayList<>();

        for (int i = 0; i< PurityType.values().length; i++){
            for (int o = 0; o< PurityType.values()[i].chance*multiplier; o++){
                array.add(PurityType.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
    public MacroPrimaryType generate_macro_primary_type(){
        MacroPrimaryType out;

        List<MacroPrimaryType> array = new ArrayList<>();

        for (int i = 0; i< MacroPrimaryType.values().length; i++){
            for (int o = 0; o< MacroPrimaryType.values()[i].chance*multiplier; o++){
                array.add(MacroPrimaryType.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
    public MacroSecondaryType generate_macro_secondary_type(){
        MacroSecondaryType out;

        List<MacroSecondaryType> array = new ArrayList<>();

        for (int i = 0; i< MacroSecondaryType.values().length; i++){
            for (int o = 0; o< MacroSecondaryType.values()[i].chance*multiplier; o++){
                array.add(MacroSecondaryType.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
    public MicroPrimaryType generate_micro_primary_type(){
        MicroPrimaryType out;

        List<MicroPrimaryType> array = new ArrayList<>();

        for (int i = 0; i< MicroPrimaryType.values().length; i++){
            for (int o = 0; o< MicroPrimaryType.values()[i].chance*multiplier; o++){
                array.add(MicroPrimaryType.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
    public MicroSecondaryType generate_micro_secondary_type(){
        MicroSecondaryType out;

        List<MicroSecondaryType> array = new ArrayList<>();

        for (int i = 0; i< MicroSecondaryType.values().length; i++){
            for (int o = 0; o< MicroSecondaryType.values()[i].chance*multiplier; o++){
                array.add(MicroSecondaryType.values()[i]);
            }
        }
        Collections.shuffle(array);

        out = array.get(0);
        return out;
    }
}
