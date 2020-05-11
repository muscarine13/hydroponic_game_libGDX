package com.acidcarpet.hydroponist.pot;

import com.acidcarpet.hydroponist.ContentPack;
import com.acidcarpet.hydroponist.Elements;
import com.acidcarpet.hydroponist.bottle.MacroPrimaryType;
import com.acidcarpet.hydroponist.bottle.MacroSecondaryType;
import com.acidcarpet.hydroponist.bottle.MicroPrimaryType;
import com.acidcarpet.hydroponist.bottle.MicroSecondaryType;
import com.acidcarpet.hydroponist.box.Box;
import com.acidcarpet.hydroponist.plant.Plant;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pot {
    private static Pot instance;
    public static Pot getInstance(){
        if(instance==null) instance = new Pot();
        return instance;
    }

    Pot(){
        atlas = ContentPack.getPot_atlas();
        level = Level.LVL_1;
    }
    TextureAtlas atlas;

    private Level level;
    public synchronized void level_up(){
        if(level==null) level = Level.LVL_MIN;
        if(level==Level.LVL_MAX) return;

        for (int i  = 0; i<Level.values().length; i++){
            if(Level.values()[i] == level){
                level = Level.values()[i+1];
            }
        }

    }
    public synchronized void level_down(){
        if(level==null) level = Level.LVL_MIN;
        if(level==Level.LVL_MIN) return;

        for (int i  = 0; i<Level.values().length; i++){
            if(Level.values()[i] == level){
                level = Level.values()[i-1];
            }
        }

    }

    public int get_maximum_volume(){
        return level.maximum_volume;
    }
    public int get_current_volume(){
        return volume;
    }

    private int volume;
    public synchronized void drain(){
        if(volume<=0) volume = 0;
        else{
            volume-=1;
        }
    }
    public synchronized boolean drain(int volume){
        if(this.volume>=volume){
            this.volume=volume;
            return true;
        }else{
            return false;
        }
    }
    public synchronized void fil(int volume, double pH, int ppm_N, int ppm_P, int ppm_K, int ppm_S, int ppm_Mg, int ppm_Ca, int ppm_B, int ppm_Cu, int ppm_Fe, int ppm_Mn, int ppm_Mo, int ppm_Zn){

        this.ppm_N = (int)(((this.volume+this.ppm_N)+(volume+ppm_N))/(this.volume+volume));
        this.ppm_P = (int)(((this.volume+this.ppm_P)+(volume+ppm_P))/(this.volume+volume));
        this.ppm_K = (int)(((this.volume+this.ppm_K)+(volume+ppm_K))/(this.volume+volume));
        this.ppm_S = (int)(((this.volume+this.ppm_S)+(volume+ppm_S))/(this.volume+volume));
        this.ppm_Mg = (int)(((this.volume+this.ppm_Mg)+(volume+ppm_Mg))/(this.volume+volume));
        this.ppm_Ca = (int)(((this.volume+this.ppm_Ca)+(volume+ppm_Ca))/(this.volume+volume));
        this.ppm_B = (int)(((this.volume+this.ppm_B)+(volume+ppm_B))/(this.volume+volume));
        this.ppm_Cu = (int)(((this.volume+this.ppm_Cu)+(volume+ppm_Cu))/(this.volume+volume));
        this.ppm_Fe= (int)(((this.volume+this.ppm_Fe)+(volume+ppm_Fe))/(this.volume+volume));
        this.ppm_Mn = (int)(((this.volume+this.ppm_Mn)+(volume+ppm_Mn))/(this.volume+volume));
        this.ppm_Mo = (int)(((this.volume+this.ppm_Mo)+(volume+ppm_Mo))/(this.volume+volume));
        this.ppm_Zn = (int)(((this.volume+this.ppm_Zn)+(volume+ppm_Zn))/(this.volume+volume));

        if(pH>this.pH) ph_up();
        if(pH<this.pH) ph_down();

        this.volume+=volume;
        if (this.volume>get_maximum_volume()) this.volume=volume;


    }
    public synchronized void fil(){
        fil(1, 6.6,0,0,0,0,0,0,0,0,0,0,0,0);
    }
    public synchronized void pro_help(){


        if(Box.getInstance().getPlant()==null) return;

        int stage_ppm = Box.getInstance().getPlant().getStage().getMinimum_ppm()+
                (Box.getInstance().getPlant().getStage().getMaximum_ppm()-Box.getInstance().getPlant().getStage().getMinimum_ppm());

        int macro_primary_ppm = (int)((double)stage_ppm* MacroPrimaryType.getVolume());
        int macro_secondary_ppm = (int)((double)stage_ppm* MacroSecondaryType.getVolume());
        int micro_primary_ppm = (int)((double)stage_ppm* MicroPrimaryType.getVolume());
        int micro_secondary_ppm = (int)((double)stage_ppm* MicroSecondaryType.getVolume());

        int N;
        int P;
        int K;

        MacroPrimaryType macro_primary_type;
        switch (Box.getInstance().getPlant().current_macro_primary()){
            case N:
                macro_primary_type = MacroPrimaryType.N; break;
            case P:
                macro_primary_type = MacroPrimaryType.P; break;
            case K:
                macro_primary_type = MacroPrimaryType.K; break;
            default:
                macro_primary_type = MacroPrimaryType.D; break;

        }
        N=(int)(macro_primary_ppm*macro_primary_type.getN_percent());
        P=(int)(macro_primary_ppm*macro_primary_type.getP_percent());
        K=(int)(macro_primary_ppm*macro_primary_type.getK_percent());

        int S;
        int Mg;
        int Ca;

        MacroSecondaryType macro_secondary_type;
        switch (Box.getInstance().getPlant().current_macro_primary()){
            case S:
                macro_secondary_type = MacroSecondaryType.S; break;
            case Mg:
                macro_secondary_type = MacroSecondaryType.Mg; break;
            case Ca:
                macro_secondary_type = MacroSecondaryType.Ca; break;
            default:
                macro_secondary_type = MacroSecondaryType.D; break;

        }
        S=(int)(macro_secondary_ppm*macro_secondary_type.getS_percent());
        Mg=(int)(macro_secondary_ppm*macro_secondary_type.getMg_percent());
        Ca=(int)(macro_secondary_ppm*macro_secondary_type.getCa_percent());

        int B;
        int Cu;
        int Fe;
        MicroPrimaryType micro_primary_type;
        switch (Box.getInstance().getPlant().current_micro_primary()){
            case B:
                micro_primary_type = MicroPrimaryType.B; break;
            case Cu:
                micro_primary_type = MicroPrimaryType.Cu; break;
            case Fe:
                micro_primary_type = MicroPrimaryType.Fe; break;
            default:
                micro_primary_type = MicroPrimaryType.D; break;


        }
        B=(int)(micro_primary_ppm*micro_primary_type.getB_percent());
        Cu=(int)(micro_primary_ppm*micro_primary_type.getCu_percent());
        Fe=(int)(micro_primary_ppm*micro_primary_type.getFe_percent());

        int Mn;
        int Mo;
        int Zn;
        MicroSecondaryType micro_secondary_type;
        switch (Box.getInstance().getPlant().current_micro_secondary()){
            case Mn:
                micro_secondary_type = MicroSecondaryType.Mn; break;
            case Mo:
                micro_secondary_type = MicroSecondaryType.Mo; break;
            case Zn:
                micro_secondary_type = MicroSecondaryType.Zn; break;
            default:
                micro_secondary_type = MicroSecondaryType.D; break;

        }
        Mn=(int)(micro_secondary_ppm*micro_secondary_type.getMn_percent());
        Mo=(int)(micro_secondary_ppm*micro_secondary_type.getMo_percent());
        Zn=(int)(micro_secondary_ppm*micro_secondary_type.getZn_percent());

        double pH;
        pH = Box.getInstance().getPlant().getRootsType().getPh_min()+(Box.getInstance().getPlant().getRootsType().getPh_max()-Box.getInstance().getPlant().getRootsType().getPh_min());


        this.volume = this.level.maximum_volume;
        this.pH = pH;

        this.ppm_N = N;
        this.ppm_P = P;
        this.ppm_K = K;

        this.ppm_S = S;
        this.ppm_Mg = Mg;
        this.ppm_Ca = Ca;

        this.ppm_B = B;
        this.ppm_Cu = Cu;
        this.ppm_Fe = Fe;

        this.ppm_Mn = Mn;
        this.ppm_Mo = Mo;
        this.ppm_Zn = Zn;


    }

    private double pH;
    public synchronized void ph_up(){
        if(pH>=14) pH = 14;
        else{
            pH+=0.01;
        }
    }
    public synchronized void ph_down(){
        if(pH<=1) pH = 1;
        else{
            pH-=0.01;
        }
    }

    public Image get_image(){
        return new Image(atlas.findRegion("pot_"+level.name));
    }
    private int ppm_N;
    private int ppm_P;
    private int ppm_K;
    private int ppm_S;
    private int ppm_Mg;
    private int ppm_Ca;
    private int ppm_B;
    private int ppm_Cu;
    private int ppm_Fe;
    private int ppm_Mn;
    private int ppm_Mo;
    private int ppm_Zn;

    public int get_all_ppm(){
        return (
                ppm_N+
                        ppm_P+
                        ppm_K+

                        ppm_S+
                        ppm_Mg+
                        ppm_Ca+

                        ppm_B+
                        ppm_Cu+
                        ppm_Fe+

                        ppm_Mn+
                        ppm_Mo+
                        ppm_Zn
        );
    }
    public int get_macro_primary_ppm(){
        return ppm_N+ppm_K+ppm_P;
    }
    public int get_macro_secondary_ppm(){
        return ppm_S+ppm_Mg+ppm_Ca;
    }
    public int get_micro_primary_ppm(){
        return ppm_B+ppm_Cu+ppm_Fe;
    }
    public int get_micro_secondary_ppm(){
        return ppm_Mn+ppm_Mo+ppm_Zn;
    }

    public int get_N() {
        return ppm_N;
    }
    public int get_P() {
        return ppm_P;
    }
    public int get_K() {
        return ppm_K;
    }
    public int get_S() {
        return ppm_S;
    }
    public int get_Mg() {
        return ppm_Mg;
    }
    public int get_Ca() {
        return ppm_Ca;
    }
    public int get_B() {
        return ppm_B;
    }
    public int get_Cu() {
        return ppm_Cu;
    }
    public int get_Fe() {
        return ppm_Fe;
    }
    public int get_Mn() {
        return ppm_Mn;
    }
    public int get_Mo() {
        return ppm_Mo;
    }
    public int get_Zn() {
        return ppm_Zn;
    }
    public void set_N(int ppm_N) {
        this.ppm_N = ppm_N;
    }
    public void set_P(int ppm_P) {
        this.ppm_P = ppm_P;
    }
    public void set_K(int ppm_K) {
        this.ppm_K = ppm_K;
    }
    public void set_S(int ppm_S) {
        this.ppm_S = ppm_S;
    }
    public void set_Mg(int ppm_Mg) {
        this.ppm_Mg = ppm_Mg;
    }
    public void set_Ca(int ppm_Ca) {
        this.ppm_Ca = ppm_Ca;
    }
    public void set_B(int ppm_B) {
        this.ppm_B = ppm_B;
    }
    public void set_Cu(int ppm_Cu) {
        this.ppm_Cu = ppm_Cu;
    }
    public void set_Fe(int ppm_Fe) {
        this.ppm_Fe = ppm_Fe;
    }
    public void set_Mn(int ppm_Mn) {
        this.ppm_Mn = ppm_Mn;
    }
    public void set_Mo(int ppm_Mo) {
        this.ppm_Mo = ppm_Mo;
    }
    public void set_Zn(int ppm_Zn) {
        this.ppm_Zn = ppm_Zn;
    }
    public Level getLevel() {
        return level;
    }
    public int getVolume() {
        return volume;
    }
    public double getpH() {
        return pH;
    }

    public Elements macro_main(){
        if(ppm_N>ppm_P&&ppm_N>ppm_K) return Elements.N;
        if(ppm_P>ppm_N&&ppm_P>ppm_K) return Elements.P;
        if(ppm_K>ppm_N&&ppm_K>ppm_P) return Elements.K;

        return Elements.EMPTY;
    }
    public Elements macro_secondary(){
        if(ppm_S>ppm_Mg&&ppm_S>ppm_Ca) return Elements.S;
        if(ppm_Mg>ppm_S&&ppm_Mg>ppm_Ca) return Elements.Mg;
        if(ppm_Ca>ppm_S&&ppm_Ca>ppm_Mg) return Elements.Ca;

        return Elements.EMPTY;
    }
    public Elements micro_main(){
        if(ppm_B>ppm_Cu&&ppm_B>ppm_Fe) return Elements.B;
        if(ppm_Cu>ppm_B&&ppm_Cu>ppm_Fe) return Elements.Cu;
        if(ppm_Fe>ppm_B&&ppm_Fe>ppm_Cu) return Elements.Fe;

        return Elements.EMPTY;
    }
    public Elements micro_secondary(){
        if(ppm_Mn>ppm_Mo&&ppm_Mn>ppm_Zn) return Elements.Mn;
        if(ppm_Mo>ppm_Mn&&ppm_Mo>ppm_Zn) return Elements.Mo;
        if(ppm_Zn>ppm_Mn&&ppm_Zn>ppm_Mo) return Elements.Zn;

        return Elements.EMPTY;
    }
    public void second(){

    }
}
