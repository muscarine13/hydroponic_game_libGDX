package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.Wrench;
import com.acidcarpet.hydroponist.plant.flower.FlowersType;
import com.acidcarpet.hydroponist.plant.leave.LeavesType;
import com.acidcarpet.hydroponist.plant.root.RootsType;

public class PlantGenerator {


    public static Plant generate_random(){

        LifetimeType lifetimeType = generate_lifetimeType();

        GenusType genusType = generate_genusType();
        VisumType visumType = generate_visumType();

        LeavesType leavesType = generate_leavesType();
        RootsType rootsType = generate_rootsType();
        FlowersType flowersType = generate_flowersType();

        SeedType seedType = generate_seedType();
        PreVegetationType preVegetationType = generate_preVegetationType();
        PostVegetationType postVegetationType = generate_postVegetationType();
        PreBloomType preBloomType = generate_preBloomType();
        PostBloomType postBloomType = generate_postBloomType();

        return new Plant(lifetimeType, genusType, visumType, leavesType, rootsType, flowersType, seedType, preVegetationType, postVegetationType, preBloomType, postBloomType);
    }

    public static LifetimeType generate_lifetimeType(){
        return LifetimeType.values()[Wrench.random_int(0, LifetimeType.values().length-1)];
    }
    public static GenusType generate_genusType(){
        return GenusType.values()[Wrench.random_int(0, GenusType.values().length-1)];
    }
    public static VisumType generate_visumType(){
        return VisumType.values()[Wrench.random_int(0, VisumType.values().length-1)];
    }
    public static LeavesType generate_leavesType(){
        return LeavesType.values()[Wrench.random_int(0, LeavesType.values().length-1)];
    }
    public static RootsType generate_rootsType(){
        return RootsType.values()[Wrench.random_int(0, RootsType.values().length-1)];
    }
    public static FlowersType generate_flowersType(){
        return FlowersType.values()[Wrench.random_int(0, FlowersType.values().length-1)];
    }

    public static SeedType generate_seedType(){
        return SeedType.values()[Wrench.random_int(0, SeedType.values().length-1)];
    }
    public static PreVegetationType generate_preVegetationType(){
        return PreVegetationType.values()[Wrench.random_int(0, PreVegetationType.values().length-1)];
    }
    public static PostVegetationType generate_postVegetationType(){
        return PostVegetationType.values()[Wrench.random_int(0, PostVegetationType.values().length-1)];
    }
    public static PreBloomType generate_preBloomType(){
        return PreBloomType.values()[Wrench.random_int(0, PreBloomType.values().length-1)];
    }
    public static PostBloomType generate_postBloomType(){
        return PostBloomType.values()[Wrench.random_int(0, PostBloomType.values().length-1)];
    }
}
