package me.nimkoes.section_004;

import me.nimkoes.common.template.DurationTemplate;

public class Main {

    private static final int LOOP_COUNT = 100;
    private static DurationTemplate[] myDurationTemplate = {new UsingIf(), new UsingIfElse(), new UsingSwitch()};

    public static void main(String[] args) {
        for (DurationTemplate durationTemplate : myDurationTemplate) {
            doProcess(durationTemplate);
        }
    }

    private static void doProcess(DurationTemplate durationTemplate) {
        System.out.println(durationTemplate.getClass() + " >> " + durationTemplate.execute(LOOP_COUNT) + "ms");
    }

}
