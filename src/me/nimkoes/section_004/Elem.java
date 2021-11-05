package me.nimkoes.section_004;

import java.util.Arrays;

public enum Elem {
    ELEM_0, ELEM_1, ELEM_2, ELEM_3, ELEM_4, ELEM_5, ELEM_6, ELEM_7, ELEM_8, ELEM_9;

    public static Elem find(int index) {
        return Arrays.stream(Elem.values())
                .filter(elem -> elem.toString().equals("ELEM_" + index))
                .findFirst()
                .get();
    }
}
