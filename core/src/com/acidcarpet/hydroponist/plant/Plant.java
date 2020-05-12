package com.acidcarpet.hydroponist.plant;

import com.acidcarpet.hydroponist.ContentPack;
import com.acidcarpet.hydroponist.Elements;
import com.acidcarpet.hydroponist.Wrench;
import com.acidcarpet.hydroponist.box.Box;
import com.acidcarpet.hydroponist.log.LogManager;
import com.acidcarpet.hydroponist.log.LogMessage;
import com.acidcarpet.hydroponist.plant.flower.Flower;
import com.acidcarpet.hydroponist.plant.flower.FlowersType;
import com.acidcarpet.hydroponist.plant.leave.Leave;
import com.acidcarpet.hydroponist.plant.leave.LeavesType;
import com.acidcarpet.hydroponist.plant.root.Root;
import com.acidcarpet.hydroponist.plant.root.RootsType;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Plant {

    private LifetimeType lifetimeType;
    private GenusType genusType;
    private VisumType visumType;

    private LeavesType leavesType;
    private RootsType rootsType;
    private FlowersType flowersType;

    private SeedType seedType;
    private PreVegetationType preVegetationType;
    private PostVegetationType postVegetationType;

    private PreBloomType preBloomType;
    private PostBloomType postBloomType;


    public Plant(LifetimeType lifetimeType, GenusType genusType, VisumType visumType, LeavesType leavesType, RootsType rootsType, FlowersType flowersType, SeedType seedType, PreVegetationType preVegetationType, PostVegetationType postVegetationType, PreBloomType preBloomType, PostBloomType postBloomType) {
        LogManager.getInstance().add(LogMessage.Type.NORMAL,
                "Создание растения",
                Thread.currentThread().getName(), this.getClass().getSimpleName()
        );

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

        seed_remain = (int)(Stages.SEED.time_multiplier*lifetimeType.seconds);
        if(Wrench.try_percent(visumType.pre_vegetation_chance)){
            pre_vegetation_remain = (int)(Stages.PRE_VEGETATION.time_multiplier*lifetimeType.seconds);
        }else{
            pre_vegetation_remain = 0;
        }
        vegetation_remain = (int)(Stages.VEGETATION.time_multiplier*lifetimeType.seconds);
        if(Wrench.try_percent(visumType.post_vegetation_chance)){
            post_vegetation_remain = (int)(Stages.POST_VEGETATION.time_multiplier*lifetimeType.seconds);
        }else{
            post_vegetation_remain = 0;
        }
        if(Wrench.try_percent(visumType.pre_bloom_chance)){
            pre_bloom_remain = (int)(Stages.PRE_BLOOM.time_multiplier*lifetimeType.seconds);
        }else{
            pre_bloom_remain = 0;
        }
        bloom_remain = (int)(Stages.BLOOM.time_multiplier*lifetimeType.seconds);
        if(Wrench.try_percent(visumType.post_bloom_chance)){
            post_bloom_remain = (int)(Stages.POST_BLOOM.time_multiplier*lifetimeType.seconds);
        }else{
            post_bloom_remain = 0;
        }

        dark=100;
        light=100;

        roots.add(new Root(rootsType));
        leaves.add(new Leave(leavesType));

        bounty_coin = Wrench.random_int(lifetimeType.coin_minimum, lifetimeType.coin_maximum);
        bounty_diamond = Wrench.random_int(lifetimeType.diamond_minimum, lifetimeType.diamond_maximum);

    }

    private Stages stage;

    public Stages getStage() {
        return stage;
    }

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

    public Elements current_macro_primary(){
        switch (stage){
            case SEED:              return seedType.elements;
            case PRE_VEGETATION:    return preVegetationType.elements;
            case VEGETATION:        return Elements.K;
            case POST_VEGETATION:   return postVegetationType.elements;
            case PRE_BLOOM:         return preBloomType.elements;
            case BLOOM:             return Elements.P;
            case POST_BLOOM:        return postBloomType.elements;

            default: return Elements.EMPTY;
        }
    }
    public Elements current_macro_secondary(){
        switch (stage){

            case PRE_VEGETATION:
            case VEGETATION:
            case POST_VEGETATION:
                return genusType.vegetation_element;

            case PRE_BLOOM:
            case BLOOM:
            case POST_BLOOM:
                return genusType.bloom_element;

            default:
                return Elements.EMPTY;
        }
    }
    public Elements current_micro_primary(){
        return visumType.micro_primary;
    }
    public Elements current_micro_secondary(){
        return visumType.micro_secondary;
    }

    private void roots_action(){
        if(stage==Stages.HARVEST){
            LogManager.getInstance().add(LogMessage.Type.NORMAL,
                    "Корни отказываются работать из-за стадии урожая",
                    Thread.currentThread().getName(), this.getClass().getSimpleName()
            );
            return;
        }

        for(Root root: roots){
            LogManager.getInstance().add(LogMessage.Type.NORMAL,
                    "Корень пытается пить",
                    Thread.currentThread().getName(), this.getClass().getSimpleName()
            );
            maximum_score+=3;

            if(Box.getInstance().getPot().getpH()>root.min_pH()&& Box.getInstance().getPot().getpH()<root.max_pH()){
                current_score++;
                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "pH в порядке",
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
            }else {
                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "pH не в порядке",
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
            }
            if(Box.getInstance().getPot().drain(root.water_production())){
                water+=root.water_production();
                current_score++;
                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "вода в порядке, выпили воды: "+root.water_production(),
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
            }else{
                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "вода не в порядке, должны были пить: "+root.water_production(),
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
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


                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "ppm в порядке. проценты: mp:"+macro_primary_percent+", ms:"+macro_secondary_percent+", mip:"+micro_primary_percent+", mis"+micro_secondary_percent+"\n"+
                        "количество: mp"+(macro_primary_percent>0.4&&macro_primary_percent<0.6)+", ms:"+(macro_secondary_percent>0.2&&macro_secondary_percent<0.4)+", mip:"+((micro_primary_percent>0.05&&micro_primary_percent<0.15)||micro_primary_percent==0)+", mis"+((micro_secondary_percent>0.05&&micro_secondary_percent<0.15)||micro_secondary_percent==0),
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
            }else{
                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "ppm не в порядке",
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
            }

            maximum_score+=4;
            if(Box.getInstance().getPot().macro_main()==current_macro_primary()) current_score++;
            if(Box.getInstance().getPot().macro_secondary()==current_macro_secondary()) current_score++;
            if(Box.getInstance().getPot().micro_main()==current_micro_primary()) current_score++;
            if(Box.getInstance().getPot().micro_secondary()==current_micro_secondary()) current_score++;

            LogManager.getInstance().add(LogMessage.Type.NORMAL,
                    "Совпадения элементов: mp:"+(Box.getInstance().getPot().macro_main()==current_macro_primary())+", ms:"+(Box.getInstance().getPot().macro_secondary()==current_macro_secondary())+", mip:"+(Box.getInstance().getPot().micro_main()==current_micro_primary())+", mis"+(Box.getInstance().getPot().micro_secondary()==current_micro_secondary()),
                    Thread.currentThread().getName(), this.getClass().getSimpleName()
            );

        }
        LogManager.getInstance().add(LogMessage.Type.NORMAL,
                "Все корни закончили пить",
                Thread.currentThread().getName(), this.getClass().getSimpleName()
        );

    }
    private void leaves_action(){
        if(stage==Stages.HARVEST) {
            LogManager.getInstance().add(LogMessage.Type.NORMAL,
                    "Листья отказываются работать из-за урожая",
                    Thread.currentThread().getName(), this.getClass().getSimpleName()
            );
            return;
        }

        maximum_score+=4;

        for(Leave leave : leaves){
            LogManager.getInstance().add(LogMessage.Type.NORMAL,
                    "Лист пытается работать",
                    Thread.currentThread().getName(), this.getClass().getSimpleName()
            );

            int temperature =(int) (
                    Box.temperature
                            -
                            Box.getInstance().getFan().getTemperature()
                            +
                            Box.getInstance().getLamp().getTemperature());
            if(temperature>leave.minimum_temperature()&&temperature<leave.maximum_temperature()){
                current_score++;
                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "Температура ок. температура: "+temperature,
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
            }else{
                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "Температура не ок. температура: "+temperature,
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
            }

            if(Box.getInstance().getFan().consume(leave.oxygen_consumption())){
                current_score++;
                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "Кислород ок. кислорода потребили: "+leave.oxygen_consumption(),
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
            }else{
                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "Кислород не ок. кислорода хотели потребить: "+leave.oxygen_consumption(),
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
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

                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "Удалось потребить свет. лампа: "+(Box.getInstance().getLamp().isOn())+"\n"+
                                "процент дня:"+percent_day+"\n"+
                                "процент дня листа"+percent_leave
                        ,
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );

                if(difference<0.2&&difference>-0.2){
                    current_score++;
                }

                if(water>=leave.water_consumption()){
                    water-=leave.water_consumption();
                    current_score++;
                    LogManager.getInstance().add(LogMessage.Type.NORMAL,
                            "Вода ок. воды потребили: "+leave.water_consumption(),
                            Thread.currentThread().getName(), this.getClass().getSimpleName()
                    );
                }else {
                    LogManager.getInstance().add(LogMessage.Type.NORMAL,
                            "Вода не ок. воды хотели потребить: "+leave.water_consumption(),
                            Thread.currentThread().getName(), this.getClass().getSimpleName()
                    );
                }


            }
        }



    }
    private void flowers_action(){
        if(stage==Stages.HARVEST){
            LogManager.getInstance().add(LogMessage.Type.NORMAL,
                    "Цветы отказываются работать из-за урожая",
                    Thread.currentThread().getName(), this.getClass().getSimpleName()
            );
            return;
        }

        if(flowers.isEmpty()) {
            for (Flower flower : flowers){
                LogManager.getInstance().add(LogMessage.Type.NORMAL,
                        "Вода не ок. воды хотели потребить: ",
                        Thread.currentThread().getName(), this.getClass().getSimpleName()
                );
                if(flower.light_energy_consumption()<=light_energy&&
                flower.dark_energy_consumption()<=dark_energy){
                    light_energy-=flower.light_energy_consumption();
                    dark_energy-=flower.dark_energy_consumption();
                    LogManager.getInstance().add(LogMessage.Type.NORMAL,
                            "Получилось потребить энергию. le:"+flower.light_energy_consumption()+", de:"+flower.dark_energy_consumption(),
                            Thread.currentThread().getName(), this.getClass().getSimpleName()
                    );
                    flower.grow();
                }
            }
        }
    }
    private void grow(){

        if(stage==Stages.HARVEST) return;

        if(stage==Stages.SEED){

            if(Wrench.try_percent(0.2)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.2)) roots.add(new Root(rootsType));

        }
        if(stage==Stages.PRE_VEGETATION){

            if(Wrench.try_percent(0.5)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.5)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.5)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(0.2)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.2)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.2)) roots.add(new Root(rootsType));

        }
        if(stage==Stages.VEGETATION){

            if(Wrench.try_percent(0.10)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.10)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.10)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(0.5)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.5)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.5)) roots.add(new Root(rootsType));

        }
        if(stage==Stages.POST_VEGETATION){

            if(Wrench.try_percent(0.10)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.5)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.5)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(0.1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.1)) roots.add(new Root(rootsType));

        }
        if(stage==Stages.PRE_BLOOM){

            if(Wrench.try_percent(0.5)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.5)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.5)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(0.2)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.2)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.2)) roots.add(new Root(rootsType));

            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));

        }
        if(stage==Stages.BLOOM){

            if(Wrench.try_percent(0.4)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.3)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.2)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(0.1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.1)) roots.add(new Root(rootsType));

            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));

        }
        if(stage==Stages.POST_BLOOM){

            if(Wrench.try_percent(0.1)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.1)) leaves.add(new Leave(leavesType));
            if(Wrench.try_percent(0.1)) leaves.add(new Leave(leavesType));

            if(Wrench.try_percent(0.1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.1)) roots.add(new Root(rootsType));
            if(Wrench.try_percent(0.1)) roots.add(new Root(rootsType));

            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));
            if(Wrench.try_percent(0.2)) flowers.add(new Flower(flowersType));

        }

        Collections.shuffle(leaves);
        Collections.shuffle(roots);
        Collections.shuffle(flowers);

        for(Leave leave : leaves){
            if(Wrench.try_percent(0.5)) leave.grow();
        }
        for (Root root : roots){
            if(Wrench.try_percent(0.5)) root.grow();
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

    public int get_percent_day(){
        return (int) (((double)light/((double)light+(double)dark))*(double)100);
    }
    public int get_percent_hp(){
        return (int) (((double)current_score/(double)maximum_score)*(double)100);
    }

    public String get_image(){
        String genus;
        String stage_name;

        genus = this.genusType.code;


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

        return genus+"_"+stage_name;
    }
    public String get_name(){
        return genusType.latin+" "+visumType.latin;
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

    public List<Leave> getLeaves() {
        return leaves;
    }
    public List<Root> getRoots() {
        return roots;
    }
    public List<Flower> getFlowers() {
        return flowers;
    }

    public LifetimeType getLifetimeType() {
        return lifetimeType;
    }
    public GenusType getGenusType() {
        return genusType;
    }
    public VisumType getVisumType() {
        return visumType;
    }
    public LeavesType getLeavesType() {
        return leavesType;
    }
    public RootsType getRootsType() {
        return rootsType;
    }
    public FlowersType getFlowersType() {
        return flowersType;
    }
    public SeedType getSeedType() {
        return seedType;
    }
    public PreVegetationType getPreVegetationType() {
        return preVegetationType;
    }
    public PostVegetationType getPostVegetationType() {
        return postVegetationType;
    }
    public PreBloomType getPreBloomType() {
        return preBloomType;
    }
    public PostBloomType getPostBloomType() {
        return postBloomType;
    }

    public synchronized void second(){

        LogManager.getInstance().add(LogMessage.Type.NORMAL,
                "Зашли в секунду",
                Thread.currentThread().getName(), this.getClass().getSimpleName()
        );

            roots_action();
            leaves_action();
            flowers_action();
            grow();
            change_stage();

        LogManager.getInstance().add(LogMessage.Type.NORMAL,
                "Вышли из секунды",
                Thread.currentThread().getName(), this.getClass().getSimpleName()
        );


    }

    public int flower_numerus(){
        if(flowers==null) return 0;
        if(flowers.isEmpty()) return 0;

        return flowers.size();

    }
    public int flower_melius(){
        if(flowers==null) return 0;
        if(flowers.isEmpty()) return 0;

        int out = 0;

        for(Flower flower : flowers){
            out+=flower.getLvl();
        }
        return out;
    }

    public int leave_numerus(){
        if(leaves==null) return 0;
        if(leaves.isEmpty()) return 0;

        return leaves.size();
    }
    public int leave_regio(){
        if(leaves==null) return 0;
        if(leaves.isEmpty()) return 0;

        int out = 0;

        for(Leave leave : leaves){
            out+=leave.cm();
        }
        return out;
    }

    public int root_latus(){
        if(roots==null) return 0;
        if(roots.isEmpty()) return 0;

        int out = 0;

        for(Root root : roots){
            out+=root.getSide_roots();
        }
        return out;
    }
    public int root_prima(){
        if(roots==null) return 0;
        if(roots.isEmpty()) return 0;

        return roots.size();
    }
    public int root_water(){
        if(roots==null) return 0;
        if(roots.isEmpty()) return 0;

        int out = 0;

        for(Root root : roots){
            out+=root.water_production();
        }
        return out;
    }

    public int flower_coin(){
        int out = 0;

        for(Flower flower : flowers){
            out+=flower.getCoin();
        }
        return out;
    }
    public int flower_diamond(){
        int out = 0;

        for(Flower flower : flowers){
            out+=flower.getDiamond();
        }
        return out;
    }
}
