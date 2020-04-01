package com.acidcarpet.hydroponist.storage;

import com.acidcarpet.hydroponist.equipment.*;
import com.acidcarpet.hydroponist.genered.test_pack.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.*;

public class Inventory {


    private static Inventory instance;
    public static Inventory getInstance(){
        if(instance==null) instance = new Inventory();
        return instance;
    }

    private Map<String, List<Storable>> storage;
    private int gold;
    private int diamond;

    private Inventory(){

        storage = new HashMap<>();

        List<com.acidcarpet.hydroponist.storage.Storable> lamp_array = new ArrayList<>();
        storage.put(Type.LAMP.line, lamp_array);

        List<com.acidcarpet.hydroponist.storage.Storable> fan_array = new ArrayList<>();
        storage.put(Type.FAN.line, fan_array);

        List<com.acidcarpet.hydroponist.storage.Storable> plant_array = new ArrayList<>();
        storage.put(Type.PLANT.line, plant_array);

        List<com.acidcarpet.hydroponist.storage.Storable> pot_array = new ArrayList<>();
        storage.put(Type.POT.line, pot_array);

        List<com.acidcarpet.hydroponist.storage.Storable> pump_array = new ArrayList<>();
        storage.put(Type.PUMP.line, pump_array);

        List<com.acidcarpet.hydroponist.storage.Storable> bottle_array = new ArrayList<>();
        storage.put(Type.BOTTLE.line, bottle_array);


        add(TestPack.getInstance().get_LED_65_lamp());
//        add(TestPack.getInstance().get_LED_200_lamp());
//        add(TestPack.getInstance().get_LED_1000_lamp());
        //add(TestPack.getInstance().get_FAN_N_fan());
        add(TestPack.getInstance().get_FAN_A_fan());
        add(TestPack.getInstance().get_FAN_P_fan());
        add(TestPack.getInstance().get_MINI_pot());
        //add(TestPack.getInstance().get_MIDDLE_pot());
        add(TestPack.getInstance().get_MAXI_pot());
        //add(TestPack.getInstance().get_WIND_pump());
        add(TestPack.getInstance().get_CYCLONE_pump());
        add(TestPack.getInstance().get_TORNADO_pump());
        add(TestPack.getInstance().get_water_bottle());
        add(TestPack.getInstance().get_pH_down_bottle());
        add(TestPack.getInstance().get_pH_up_bottle());
        add(TestPack.getInstance().get_nutrient_N_bottle());
        add(TestPack.getInstance().get_nutrient_P_bottle());
        add(TestPack.getInstance().get_nutrient_K_bottle());
        add(TestPack.getInstance().get_nutrient_S_bottle());
        add(TestPack.getInstance().get_nutrient_Mg_bottle());
        add(TestPack.getInstance().get_nutrient_Ca_bottle());
        add(TestPack.getInstance().get_nutrient_B_bottle());
        add(TestPack.getInstance().get_nutrient_Cu_bottle());
        add(TestPack.getInstance().get_nutrient_Fe_bottle());
        add(TestPack.getInstance().get_nutrient_Mn_bottle());
        add(TestPack.getInstance().get_nutrient_Mo_bottle());
        add(TestPack.getInstance().get_nutrient_Zn_bottle());


        gold = 0;
        diamond = 0;


    }

    public synchronized void add(Storable item_to_add){

        Type item_type = null;

        if(item_to_add.toString().equals("LAMP"))   item_type = Type.LAMP;
        if(item_to_add.toString().equals("FAN"))    item_type = Type.FAN;
        if(item_to_add.toString().equals("PLANT"))  item_type = Type.PLANT;
        if(item_to_add.toString().equals("POT"))    item_type = Type.POT;
        if(item_to_add.toString().equals("PUMP"))   item_type = Type.PUMP;
        if(item_to_add.toString().equals("BOTTLE")) item_type = Type.BOTTLE;

        if(item_type!=null){
           switch (item_type){
               case LAMP:   storage.get(Type.LAMP.line).add(item_to_add);  break;
               case FAN:    storage.get(Type.FAN.line).add(item_to_add);   break;
               case PLANT:  storage.get(Type.PLANT.line).add(item_to_add); break;
               case POT:    storage.get(Type.POT.line).add(item_to_add);   break;
               case PUMP:   storage.get(Type.PUMP.line).add(item_to_add);  break;
               case BOTTLE: storage.get(Type.BOTTLE.line).add(item_to_add);break;
               default:
           }
        }

    }
    public synchronized void delete(Type type, int index){
        if(type!=null){
            switch (type){
                case LAMP:   storage.get(Type.LAMP.line).remove(index);  break;
                case FAN:    storage.get(Type.FAN.line).remove(index);   break;
                case PLANT:  storage.get(Type.PLANT.line).remove(index); break;
                case POT:    storage.get(Type.POT.line).remove(index);   break;
                case PUMP:   storage.get(Type.PUMP.line).remove(index);  break;
                case BOTTLE: storage.get(Type.BOTTLE.line).remove(index);break;
                default:
            }
        }
    }
    public synchronized void delete(Storable item){
        if(item==null) return;

        Iterator<Map.Entry<String, List<Storable>>> it = storage.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, List<Storable>> pair = it.next();

            try{
                if(pair.getValue().remove(item)) return;
            }catch (Exception e){

            }
        }
    }
    public synchronized Storable get(Type type, int index){
        if(type!=null){
            switch (type){
                case LAMP:   return storage.get(Type.LAMP.line).get(index);
                case FAN:    return storage.get(Type.FAN.line).get(index);
                case PLANT:  return storage.get(Type.PLANT.line).get(index);
                case POT:    return storage.get(Type.POT.line).get(index);
                case PUMP:   return storage.get(Type.PUMP.line).get(index);
                case BOTTLE: return storage.get(Type.BOTTLE.line).get(index);
                default: return null;
            }
        }else{
            return null;
        }
    }
    public synchronized Storable get_and_remove(Type type, int index){
        if(type!=null){
            switch (type){
                case LAMP:   return storage.get(Type.LAMP.line).remove(index);
                case FAN:    return storage.get(Type.FAN.line).remove(index);
                case PLANT:  return storage.get(Type.PLANT.line).remove(index);
                case POT:    return storage.get(Type.POT.line).remove(index);
                case PUMP:   return storage.get(Type.PUMP.line).remove(index);
                case BOTTLE: return storage.get(Type.BOTTLE.line).remove(index);
                default: return null;
            }
        }else{
            return null;
        }
    }
    public synchronized List<Storable> get_list(Type type){
        if(type!=null){
            switch (type){
                case LAMP:   return storage.get(Type.LAMP.line);
                case FAN:    return storage.get(Type.FAN.line);
                case PLANT:  return storage.get(Type.PLANT.line);
                case POT:    return storage.get(Type.POT.line);
                case PUMP:   return storage.get(Type.PUMP.line);
                case BOTTLE: return storage.get(Type.BOTTLE.line);
                default: return null;
            }
        }else{
            return null;
        }
    }

    public synchronized int getGold() {
        return gold;
    }
    public synchronized void setGold(int gold) {
        this.gold = gold;
    }
    public synchronized int getDiamond() {
        return diamond;
    }
    public synchronized void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public enum Type{
        LAMP("LAMP"),
        FAN("FAN"),
        PLANT("PLANT"),
        POT("POT"),
        PUMP("PUMP"),
        BOTTLE("BOTTLE");

        Type(String line){
            this.line = line;
        }
        String line;

    }

}
