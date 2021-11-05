package me.nimkoes.section_004;

public abstract class SampleTemplate {

    public long execute(int loopCount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < loopCount; ++i) {
            coreLogic();
        }
        long endTime = System.nanoTime();

        long resultTime = endTime - startTime;
        return resultTime;
    }
    abstract void coreLogic();
}
