package com.acidcarpet.hydroponist.pot;

public enum Level {


    LVL_10(90000, "X"),
    LVL_9(85000, "IX"),
    LVL_8(65000, "VIII"),
    LVL_7(60000, "VII"),
    LVL_6(52000, "VI"),
    LVL_5(50000, "V"),
    LVL_4(40000, "IV"),
    LVL_3(35000, "III"),
    LVL_2(25000, "II"),
    LVL_1(15000, "I");


    int maximum_volume;
    String name;

    Level(int maximum_volume, String name) {
        this.maximum_volume = maximum_volume;
        this.name = name;
    }

    public int getMaximum_volume() {
        return maximum_volume;
    }

    public String getName() {
        return name;
    }
}
