package com.acidcarpet.hydroponist.ref.plant;

import com.acidcarpet.hydroponist.Elements;
import com.acidcarpet.hydroponist.Wrench;
import com.acidcarpet.hydroponist.ref.plant.leave.Leave;
import com.acidcarpet.hydroponist.ref.plant.root.LifetimeType;
import com.acidcarpet.hydroponist.ref.plant.root.Root;
import com.acidcarpet.hydroponist.ref.pot.Pot;

import java.util.ArrayList;
import java.util.List;

public class Plant {

    LifetimeType lifetimeType;
    GenusType genusType;
    VisumType visumType;

    SeedType seedType;
    PreVegetationType preVegetationType;
    PostVegetationType postVegetationType;

    PreBloomType preBloomType;
    PostBloomType postBloomType;


    public Plant(LifetimeType lifetimeType, GenusType genusType, VisumType visumType,SeedType seedType, PreVegetationType preVegetationType, PostVegetationType postVegetationType, PreBloomType preBloomType, PostBloomType postBloomType) {
        this.lifetimeType = lifetimeType;
        this.genusType = genusType;
        this.visumType = visumType;
        this.preVegetationType = preVegetationType;
        this.postVegetationType = postVegetationType;
        this.preBloomType = preBloomType;
        this.postBloomType = postBloomType;
        this.seedType = seedType;
        stage = Stages.SEED;

        leaves = new ArrayList<>();
        roots = new ArrayList<>();

        seed_remain = (int)(lifetimeType.seconds*Stages.SEED.time_multiplier);
        vegetation_remain = (int)(lifetimeType.seconds*Stages.VEGETATION.time_multiplier);
        bloom_remain = (int)(lifetimeType.seconds*Stages.BLOOM.time_multiplier);

        if(Wrench.try_percent(visumType.pre_vegetation_chance)){
            pre_vegetation_remain = (int)(lifetimeType.seconds*Stages.PRE_VEGETATION.time_multiplier);
        }else{
            pre_vegetation_remain = 0;
        }
        if(Wrench.try_percent(visumType.post_vegetation_chance)){
            post_vegetation_remain = (int)(lifetimeType.seconds*Stages.POST_VEGETATION.time_multiplier);
        }else{
            post_vegetation_remain = 0;
        }
        if(Wrench.try_percent(visumType.pre_bloom_chance)){
            pre_bloom_remain = (int)(lifetimeType.seconds*Stages.PRE_BLOOM.time_multiplier);
        }else{
            pre_bloom_remain = 0;
        }
        if(Wrench.try_percent(visumType.post_bloom_chance)){
            post_bloom_remain = (int)(lifetimeType.seconds*Stages.POST_BLOOM.time_multiplier);
        }else{
            post_bloom_remain = 0;
        }







        water = 1000;
    }

    private Stages stage;

    private List<Leave> leaves;
    private List<Root> roots;

    int maximum_score;
    int current_score;

    int water;

    int seed_remain;
    int pre_vegetation_remain;
    int vegetation_remain;
    int post_vegetation_remain;
    int pre_bloom_remain;
    int bloom_remain;
    int post_bloom_remain;

    private void roots_action(){
        if(stage==Stages.HARVEST) return;

        for(Root root: roots){
            maximum_score+=3+4;

            if(Pot.getInstance().getpH()>root.min_pH()&&Pot.getInstance().getpH()<root.max_pH()){
                current_score++;
            }
            if(Pot.getInstance().drain(root.water_production())){
                water+=root.water_production();
                current_score++;
            }
            if(Pot.getInstance().get_all_ppm()>stage.minimum_ppm&&Pot.getInstance().get_all_ppm()<stage.maximum_ppm){
                current_score++;
            }

            switch (stage){
                case SEED:
                    if(Pot.getInstance().macro_main()==seedType.elements){
                        current_score++;
                    }
                    if(Pot.getInstance().macro_secondary()== Elements.EMPTY){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;

                case PRE_VEGETATION:
                    if(Pot.getInstance().macro_main()==preVegetationType.elements){
                        current_score++;
                    }
                    if(Pot.getInstance().macro_secondary()== genusType.vegetation_element){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;

                case VEGETATION:
                    if(Pot.getInstance().macro_main()==Elements.K){
                        current_score++;
                    }
                    if(Pot.getInstance().macro_secondary()== genusType.vegetation_element){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;
                case POST_VEGETATION:
                    if(Pot.getInstance().macro_main()==postVegetationType.elements){
                        current_score++;
                    }
                    if(Pot.getInstance().macro_secondary()== genusType.vegetation_element){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;
                case PRE_BLOOM:
                    if(Pot.getInstance().macro_main()==preBloomType.elements){
                        current_score++;
                    }
                    if(Pot.getInstance().macro_secondary()== genusType.bloom_element){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;
                case BLOOM:
                    if(Pot.getInstance().macro_main()==Elements.P){
                        current_score++;
                    }
                    if(Pot.getInstance().macro_secondary()== genusType.bloom_element){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;
                case POST_BLOOM:
                    if(Pot.getInstance().macro_main()==postBloomType.elements){
                        current_score++;
                    }
                    if(Pot.getInstance().macro_secondary()== genusType.bloom_element){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_main()==visumType.micro_primary){
                        current_score++;
                    }
                    if(Pot.getInstance().micro_secondary()==visumType.micro_secondary){
                        current_score++;
                    }
                    break;
                case HARVEST:

                    break;
            }

        }

    }
    public void change_stage(){
        if(stage==Stages.HARVEST) return;

        if(seed_remain!=0){
            seed_remain--;
            if(seed_remain==0){
                if(pre_vegetation_remain>0) stage = Stages.PRE_VEGETATION;
                else stage = Stages.VEGETATION;
                return;
            }
        }
        if(pre_vegetation_remain!=0){
            pre_vegetation_remain--;
            if(pre_vegetation_remain==0){
                stage = Stages.VEGETATION;
                return;
            }
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
                return;
            }
        }
        if(post_vegetation_remain!=0){
            post_vegetation_remain--;
            if(post_vegetation_remain==0){
                if(pre_bloom_remain>0) stage = Stages.PRE_BLOOM;
                else stage = Stages.BLOOM;
                return;
            }
        }
        if(pre_bloom_remain!=0){
            pre_bloom_remain--;
            if(pre_bloom_remain==0){
                stage = Stages.BLOOM;
                return;
            }

        }
        if(bloom_remain!=0){
            bloom_remain--;
            if(bloom_remain==0){
                if(post_bloom_remain>0) stage = Stages.POST_BLOOM;
                else stage = Stages.HARVEST;
                return;
            }
        }
        if(post_bloom_remain!=0){
            post_bloom_remain--;
            if(post_bloom_remain==0){
                stage = Stages.HARVEST;
                return;
            }
        }
    }
}
