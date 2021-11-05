package me.nimkoes.section_004;

public class Util {

    private static final int TICK_OVER_COUNT = 100;

    public static void tickOver() {
        String str = "";
        for (int i = 0; i < TICK_OVER_COUNT; ++i) str += " ";
    }

    public static Elem getRandomElem() {
        return Elem.find(getRandomIndex());
    }

    /**
     * 0 ~ 9 사이의 랜덤 값 반환
     */
    private static int getRandomIndex() {
        double random = Math.random() * 10;
        return (int) random;
    }
}
