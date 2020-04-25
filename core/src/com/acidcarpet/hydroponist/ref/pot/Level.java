package com.acidcarpet.hydroponist.ref.pot;

public enum Level {

    MAX_MAX(250, "XVII"),
    LVL_15(200, "XVI"),
    LVL_14(175, "XV"),
    LVL_13(150, "XIV"),
    LVL_12(115, "XIII"),
    LVL_11(100, "XII"),
    LVL_10(90, "XI"),
    LVL_9(85, "X"),
    LVL_8(65, "IX"),
    LVL_7(60, "VIII"),
    LVL_6(52, "VII"),
    LVL_5(50, "VI"),
    LVL_4(40, "V"),
    LVL_3(35, "IV"),
    LVL_2(25, "III"),
    LVL_1(15, "II"),
    LVL_MIN(10, "I");

    int maximum_volume;
    String name;

    Level(int maximum_volume, String name) {
        this.maximum_volume = maximum_volume;
        this.name = name;
    }
}
