package com.acidcarpet.hydroponist.ref.plant;

import com.acidcarpet.hydroponist.ContentPack;
import com.acidcarpet.hydroponist.Elements;
import com.acidcarpet.hydroponist.Wrench;


import com.acidcarpet.hydroponist.ref.box.Box;
import com.acidcarpet.hydroponist.ref.plant.flower.Flower;
import com.acidcarpet.hydroponist.ref.plant.flower.FlowersType;
import com.acidcarpet.hydroponist.ref.plant.leave.Leave;
import com.acidcarpet.hydroponist.ref.plant.leave.LeavesType;
import com.acidcarpet.hydroponist.ref.plant.root.Root;
import com.acidcarpet.hydroponist.ref.plant.root.RootsType;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plant {

    LifetimeType lifetimeType;
    GenusType genusType;
    VisumType visumType;

    LeavesType leavesType;
    RootsType rootsType;
    FlowersType flowersType;

    SeedType seedType;
    PreVegetationType preVegetationType;
    PostVegetationType postVegetationType;

    PreBloomType preBloomType;
    PostBloomType postBloomType;


    public Plant(LifetimeType lifetimeType, GenusType genusType, VisumType visumType, LeavesType leavesType, RootsType rootsType, FlowersType flowersType, SeedType seedType, PreVegetationType preVegetationType, PostVegetationType postVegetationType, PreBloomType preBloomType, PostBloomType postBloomType) {
        this.lifetimeType = lifetimeType;
        this.genusType = genusType;
        this.visumType = visumType;
        this.leavesType = leavesType;
        this.rootsType = rootsType;
        this.seedType = seedType;
        this.preVegetationType = preVegetationType;
        this.postVegetationType = postVegetationType;
        this.preBloomType = preBloomType;
        this.postBloomType = postBloomType;
        this.flowersType = flowersType;

        leaves = new ArrayList<>();
        roots = new ArrayList<>();
        flowers = new ArrayList<>();
        stage = Stages.SEED;

        bounty_coin = Wrench.random_int(lifetimeType.coin_minimum, lifetimeType.coin_maximum);
        bounty_diamond = Wrench.random_int(lifetimeType.diamond_minimum, lifetimeType.diamond_maximum);
    }

    private Stages stage;

    private List<Leave> leaves;
    private List<Root> roots;
    private List<Flower> flowers;

    private int bounty_coin;
    private int bounty_diamond;

    private int maximum_score;
    private int current_score;

    private int water;

    private int light;
    private int dark;

    private int light_energy;
    private int dark_energy;

    private int seed_remain;
    private int pre_vegetation_remain;
    private int vegetation_remain;
    private int post_vegetation_remain;
    private int pre_bloom_remain;
    private int bloom_remain;
    private int post_bloom_remain;

    private void roots_action(){
        if(stage==Stages.HARVEST) return;

        for(Root root: roots){
            maximum_score+=3;

            if(Box.getInstance().getPot().getpH()>root.min_pH()&& Box.getInstance().getPot().getpH()<root.max_pH()){
                current_score++;
            }
            if(Box.getInstance().getPot().drain(root.water_production())){
                water+=root.water_production();
                current_score++;
            }
            if(Box.getInstance().getPot().get_all_ppm()>stage.minimum_ppm&& Box.getInstance().getPot().get_all_ppm()<stage.maximum_ppm){
                current_score++;

                double macro_primary_percent = (double)Box.getInstance().getPot().get_macro_primary_ppm()/(double)Box.getInstance().getPot().get_all_ppm();
                double macro_secondary_percent = (double)Box.getInstance().getPot().get_macro_secondary_ppm()/(double)Box.getInstance().getPot().get_all_ppm();
                double micro_primary_percent = (double)Box.getInstance().getPot().get_micro_primary_ppm()/(double)Box.getInstance().getPot().get_all_ppm();
                double micro_secondary_percent = (double)Box.getInstance().getPot().get_micro_secondary_ppm()/(double)Box.getInstance().getPot().get_all_ppm();

                maximum_score+=4;
                if(macro_primary_percent>0.4&&macro_primary_percent<0.6) current_score++;
                if(macro_secondary_percent>0.2&&macro_secondary_percent<0.4) current_score++;
                if((micro_primary_percent>0.05&&micro_primary_percent<0.15)||micro_primary_percent==0) current_score++;
                if((micro_secondary_percent>0.05&&micro_secondary_percent<0.15)||micro_secondary_percent==0) current_score++;
            }

            maximum_score+=4;
            switch (stage){
                case SEED:
                    if(Box.getInstance().getPot().macro_main()==seedType.elements){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().macro_secondary()== Elements.EMPTY){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;

                case PRE_VEGETATION:
                    if(Box.getInstance().getPot().macro_main()==preVegetationType.elements){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().macro_secondary()== genusType.vegetation_element){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;

                case VEGETATION:
                    if(Box.getInstance().getPot().macro_main()==Elements.K){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().macro_secondary()== genusType.vegetation_element){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;
                case POST_VEGETATION:
                    if(Box.getInstance().getPot().macro_main()==postVegetationType.elements){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().macro_secondary()== genusType.vegetation_element){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;
                case PRE_BLOOM:
                    if(Box.getInstance().getPot().macro_main()==preBloomType.elements){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().macro_secondary()== genusType.bloom_element){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;
                case BLOOM:
                    if(Box.getInstance().getPot().macro_main()==Elements.P){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().macro_secondary()== genusType.bloom_element){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;
                case POST_BLOOM:
                    if(Box.getInstance().getPot().macro_main()==postBloomType.elements){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().macro_secondary()== genusType.bloom_element){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Box.getInstance().getPot().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;
                case HARVEST:

                    break;
            }

        }

    }
    private void leaves_action(){
        if(stage==Stages.HARVEST) return;

        maximum_score+=4;

        for(Leave leave : leaves){
            int temperature =(int) (
                    Box.temperature
                            -
                            Box.getInstance().getFan().getTemperature()
                            +
                            Box.getInstance().getLamp().getTemperature());
            if(temperature>leave.minimum_temperature()&&temperature<leave.maximum_temperature()){
                current_score++;
            }

            if(Box.getInstance().getFan().consume(leave.oxygen_consumption())){
                current_score++;
            }



            if(Box.getInstance().getLamp().consume(leave.energy_consumption())){
                if (Box.getInstance().getLamp().isOn()) {
                    light_energy+=leave.light_energy();
                    light++;
                }
                else {
                    dark_energy+=leave.dark_energy();
                    dark++;
                }
                double percent_day = light/(light+dark);
                double percent_leave = genusType.percent_day;
                double difference = percent_leave - percent_day;

                if(difference<0.2&&difference>-0.2){
                    current_score++;
                }

                if(water>=leave.water_consumption()){
                    water-=leave.water_consumption();
                    current_score++;
                }
            }
        }



    }
    private void flowers_action(){
        if(stage==Stages.HARVEST) return;

        if(flowers.isEmpty()) {
            for (Flower flower : flowers){
                if(flower.light_energy_consumption()<=light_energy&&
                flower.dark_energy_consumption()<=dark_energy){
                    light_energy-=flower.light_energy_consumption();
                    dark_energy-=flower.dark_energy_consumption();
                    flower.grow();
                }
            }
        }
    }
    private void grow(){

        if(stage==Stages.HARVEST) return;

        if(stage==Stages.SEED){

            if(Wrench.try_percent(2)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(2)) roots.add(new Root(rootsType));

        }
        if(stage==Stages.PRE_VEGETATION){

            if(Wrench.try_percent(5)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(5)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(5)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(2)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(2)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(2)) roots.add(new Root(rootsType));

        }
        if(stage==Stages.VEGETATION){

            if(Wrench.try_percent(10)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(10)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(10)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(5)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(5)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(5)) roots.add(new Root(rootsType));

        }
        if(stage==Stages.POST_VEGETATION){

            if(Wrench.try_percent(10)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(5)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(5)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(1)) roots.add(new Root(rootsType));

        }
        if(stage==Stages.PRE_BLOOM){

            if(Wrench.try_percent(5)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(5)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(5)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(2)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(2)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(2)) roots.add(new Root(rootsType));

            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));

        }
        if(stage==Stages.BLOOM){

            if(Wrench.try_percent(4)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(3)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(2)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(1)) roots.add(new Root(rootsType));

            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));

        }
        if(stage==Stages.POST_BLOOM){

            if(Wrench.try_percent(1)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(1)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(1)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(1)) roots.add(new Root(rootsType));

            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(2)) flowers.add(new Flower(flowersType));

        }

        Collections.shuffle(leaves);
        Collections.shuffle(roots);
        Collections.shuffle(flowers);

        for(Leave leave : leaves){
            if(Wrench.try_percent(5)) leave.grow();
        }
        for (Root root : roots){
            if(Wrench.try_percent(5)) root.grow();
        }


    }
    public void change_stage(){
        if(stage==Stages.HARVEST) return;

        if(seed_remain!=0){
            seed_remain--;
            if(seed_remain==0){
                if(pre_vegetation_remain>0) stage = Stages.PRE_VEGETATION;
                else stage = Stages.VEGETATION;
            }
            return;
        }
        if(pre_vegetation_remain!=0){
            pre_vegetation_remain--;
            if(pre_vegetation_remain==0){
                stage = Stages.VEGETATION;
            }
            return;
        }
        if(vegetation_remain!=0){
            vegetation_remain--;
            if(vegetation_remain==0){
                if(post_vegetation_remain>0){
                    stage = Stages.POST_VEGETATION;
                }else{
                    if(pre_bloom_remain>0) stage = Stages.PRE_BLOOM;
                    else stage = Stages.BLOOM;
                }
            }
            return;
        }
        if(post_vegetation_remain!=0){
            post_vegetation_remain--;
            if(post_vegetation_remain==0){
                if(pre_bloom_remain>0) stage = Stages.PRE_BLOOM;
                else stage = Stages.BLOOM;
            }
            return;
        }
        if(pre_bloom_remain!=0){
            pre_bloom_remain--;
            if(pre_bloom_remain==0){
                stage = Stages.BLOOM;
            }
            return;

        }
        if(bloom_remain!=0){
            bloom_remain--;
            if(bloom_remain==0){
                if(post_bloom_remain>0) stage = Stages.POST_BLOOM;
                else stage = Stages.HARVEST;
            }
            return;
        }
        if(post_bloom_remain!=0){
            post_bloom_remain--;
            if(post_bloom_remain==0){
                stage = Stages.HARVEST;
            }
            return;
        }
    }

    public int get_dark_energy(){
        return dark_energy;
    }
    public int get_light_energy(){
        return light_energy;
    }
    public int get_bounty_coin(){
        return (int)((double)bounty_coin*((double)current_score/(double)maximum_score));
    }
    public int get_bounty_diamond(){
        return (int)((double)bounty_diamond*((double)current_score/(double)maximum_score));
    }

    public double get_percent_day(){
        return ((double)light/((double)light+(double)dark))*100;
    }

    public Image get_image(){
        String genus;
        String visum;
        String stage_name;

        genus = this.genusType.code;
        visum = this.visumType.code;

        switch (stage){
            case SEED: stage_name = "seed"; break;
            case PRE_VEGETATION:stage_name = "pre_vegetation"; break;
            case VEGETATION:stage_name = "vegetation"; break;
            case POST_VEGETATION:stage_name = "post_vegetation"; break;
            case PRE_BLOOM:stage_name = "pre_bloom"; break;
            case BLOOM:stage_name = "bloom"; break;
            case POST_BLOOM:stage_name = "post_bloom"; break;
            case HARVEST:stage_name = "harvest"; break;
            default: stage_name = "seed";

        }

        return new Image(ContentPack.getAtlas().findRegion(genus+"_"+stage_name+"_"+visum));
    }

    public int getSeed_remain() {
        return seed_remain;
    }
    public int getPre_vegetation_remain() {
        return pre_vegetation_remain;
    }
    public int getVegetation_remain() {
        return vegetation_remain;
    }
    public int getPost_vegetation_remain() {
        return post_vegetation_remain;
    }
    public int getPre_bloom_remain() {
        return pre_bloom_remain;
    }
    public int getBloom_remain() {
        return bloom_remain;
    }
    public int getPost_bloom_remain() {
        return post_bloom_remain;
    }

    public synchronized void second(){
            roots_action();
            leaves_action();
            grow();
            change_stage();


    }
}
