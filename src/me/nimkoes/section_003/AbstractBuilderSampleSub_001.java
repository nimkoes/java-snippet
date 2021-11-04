package me.nimkoes.section_003;

import java.util.Objects;

public class AbstractBuilderSampleSub_001 extends AbstractBuilderSample {

    private final String name;

    private AbstractBuilderSampleSub_001(Builder builder) {
        super(builder);
        this.name = builder.name;
    }

    public static class Builder extends AbstractBuilderSample.Builder<Builder> {

        private final String name;

        public Builder(String name) {
            this.name = Objects.requireNonNull(name);
        }

        @Override
        AbstractBuilderSampleSub_001 build() {
            return new AbstractBuilderSampleSub_001(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public String toString() {
        return "AbstractBuilderSampleSub_001{" +
                "skills=" + skills +
                ", name='" + name + '\'' +
                '}';
    }
}
