package me.nimkoes.section_004;

public class Main {

    private static final int LOOP_COUNT = 100;
    private static SampleTemplate[] mySampleTemplate = {new UsingIf(), new UsingIfElse(), new UsingSwitch()};

    public static void main(String[] args) {
        for (SampleTemplate sampleTemplate : mySampleTemplate) {
            doPorcess(sampleTemplate);
        }
    }

    private static void doPorcess(SampleTemplate sampleTemplate) {
        System.out.println(sampleTemplate.getClass() + " >> " + sampleTemplate.execute(LOOP_COUNT) + "ms");
    }

}
