package com.acidcarpet.hydroponist.ref.pot;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pot {

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



}
