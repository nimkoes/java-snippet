package me.nimkoes.common.template;

public abstract class DurationTemplate {

    public long execute(int loopCount) {
        long startTime = System.nanoTime();
        for (int i = 0; i < loopCount; ++i) {
            coreLogic();
        }
        long endTime = System.nanoTime();

        long resultTime = endTime - startTime;
        return resultTime;
    }

    public abstract void coreLogic();
}
