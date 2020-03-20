package com.acidcarpet.hydroponist.plant;
import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.equipment.WaterPack;

public class Root {
    boolean alive;

    public Root(
            int maximum_health,
            int growth_length,

            double oxygen_consume,
            double pH_minimum,
            double ph_maximum,
            double t_minimum,
            double t_maximum,
            int ppm_minimum,
            int ppm_maximum,

            double water_absorb_multiplier

    ){

        alive=true;
        length=1;

        this.maximum_health = maximum_health;
        this.current_health = maximum_health/2;
        this.growth_length = growth_length;

        this.oxygen_consumption = oxygen_consume;

        this.pH_minimum = pH_minimum;
        this.ph_maximum = ph_maximum;

        this.t_minimum = t_minimum;
        this.t_maximum = t_maximum;

        this.ppm_minimum = ppm_minimum;
        this.ppm_maximum = ppm_maximum;

        this.water_volume_multiplier = water_absorb_multiplier;

    }

    int current_health;
    int maximum_health;

    double length;
    int growth_length;

    double oxygen_consumption;
    double pH_minimum;
    double ph_maximum;
    double t_minimum;
    double t_maximum;
    int ppm_minimum;
    int ppm_maximum;

    double water_volume_multiplier;

    public synchronized void absorb(){
        if(!alive) return;
        WaterPack metabolism_pack;
        if(
                        (Box.getInstance().getPot().getCurrent_pH()< ph_maximum &&Box.getInstance().getPot().getCurrent_pH()> pH_minimum)
                &&      (Box.getInstance().getPot().get_all_ppm()>ppm_minimum&&Box.getInstance().getPot().get_all_ppm()<ppm_maximum)
                &&       Box.getInstance().getPump().reduce_oxygen(oxygen_consumption *length)
                &&       Box.getInstance().getPot().getCurrent_volume()>=length*water_volume_multiplier
        ){
            current_health++;
            if(current_health>maximum_health)current_health = maximum_health;

            metabolism_pack= new WaterPack(
                    length*water_volume_multiplier,
                    Box.getInstance().getPot().getCurrent_pH(),
                    Box.getInstance().getPot().getN(),
                    Box.getInstance().getPot().getP(),
                    Box.getInstance().getPot().getK(),
                    Box.getInstance().getPot().getS(),
                    Box.getInstance().getPot().getMg(),
                    Box.getInstance().getPot().getCa(),
                    Box.getInstance().getPot().getB(),
                    Box.getInstance().getPot().getCu(),
                    Box.getInstance().getPot().getFe(),
                    Box.getInstance().getPot().getMn(),
                    Box.getInstance().getPot().getMo(),
                    Box.getInstance().getPot().getZn()

            );
            Box.getInstance().getPot().drain(length*water_volume_multiplier);

            if (metabolism_pack!=null){
                Box.getInstance().getPlant().add_metabolism_pack(metabolism_pack);
            }else{
                current_health-=2;
                if(current_health<=0) {
                    current_health=0;
                    alive=false;
                }
            }

        }else{
            current_health--;
            if(current_health<0)alive=false;
        }

    }
    public void grow(){
        if(current_health<0) alive=false;
        if(!alive) return;

        length+= growth_length;
    }

    public boolean isAlive() {
        return alive;
    }
    public int getCurrent_health() {
        return current_health;
    }
    public int getMaximum_health() {
        return maximum_health;
    }
    public double getLength() {
        return length;
    }
    public int getGrowth_length() {
        return growth_length;
    }
    public double getOxygen_consumption() {
        return oxygen_consumption;
    }
    public double getpH_minimum() {
        return pH_minimum;
    }
    public double getPh_maximum() {
        return ph_maximum;
    }
    public double getT_minimum() {
        return t_minimum;
    }
    public double getT_maximum() {
        return t_maximum;
    }
    public int getPpm_minimum() {
        return ppm_minimum;
    }
    public int getPpm_maximum() {
        return ppm_maximum;
    }
    public double getWater_volume_multiplier() {
        return water_volume_multiplier;
    }

}
