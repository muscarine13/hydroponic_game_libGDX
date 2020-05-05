package com.acidcarpet.hydroponist.pot;

public enum Level {

    LVL_MAX(250, "MAX"),
    LVL_15(200, "XV"),
    LVL_14(175, "XIV"),
    LVL_13(150, "XIII"),
    LVL_12(115, "XII"),
    LVL_11(100, "XI"),
    LVL_10(90, "X"),
    LVL_9(85, "IX"),
    LVL_8(65, "VIII"),
    LVL_7(60, "VII"),
    LVL_6(52, "VI"),
    LVL_5(50, "V"),
    LVL_4(40, "IV"),
    LVL_3(35, "III"),
    LVL_2(25, "II"),
    LVL_1(15, "I"),
    LVL_MIN(10, "NG");

    int maximum_volume;
    String name;

    Level(int maximum_volume, String name) {
        this.maximum_volume = maximum_volume;
        this.name = name;
    }
}
