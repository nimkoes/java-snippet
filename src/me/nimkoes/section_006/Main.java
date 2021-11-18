package me.nimkoes.section_006;

import me.nimkoes.common.template.DurationTemplate;

public class Main {

    private static final int LOOP_COUNT = 100;
    private static DurationTemplate[] myDurationTemplate = {new UsingSystemOutPrintln(), new UsingLogback()};

    public static void main(String[] args) {

        long result[] = new long[myDurationTemplate.length];

        int index = 0;
        for (DurationTemplate durationTemplate : myDurationTemplate) {
            result[index++] = doProcess(durationTemplate);
        }

        System.out.println("\n=====================================================================================");

        index = 0;
        for (long elem : result) {
            System.out.println(myDurationTemplate[index++].getClass().getSimpleName() + " >> " + elem + "ms");
        }
    }

    private static long doProcess(DurationTemplate durationTemplate) {
        return durationTemplate.execute(LOOP_COUNT);
    }
}
