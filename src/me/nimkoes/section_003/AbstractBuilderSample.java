package me.nimkoes.section_003;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractBuilderSample {
    public enum SKILL {JAVA, SPRING, SPRING_BOOT, JPA, DATA_JPA}

    // 생성자에서 할당
    final Set<SKILL> skils;

    // Builder<T> 타입의 T
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<SKILL> skills = EnumSet.noneOf(SKILL.class);

        public T addSkill(SKILL skill) {
            skills.add(Objects.requireNonNull(skill));
            return self();
        }

        abstract AbstractBuilderSample build();

        protected abstract T self();
    }

    AbstractBuilderSample(Builder<?> builder) {
        skils = builder.skills.clone();
    }
}
