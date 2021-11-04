package me.nimkoes.section_003;

public class BuilderPattern {
    public static void main(String[] args) {

        String name = "nimkoes";

        System.out.println(new DataSample.Builder(name, 11).build().toString());
        System.out.println(new DataSample.Builder(name, 21).address("korea").build().toString());
        System.out.println(new DataSample.Builder(name, 31).address("asia").gender("male").build().toString());

        System.out.println(
                new AbstractBuilderSampleSub_001.Builder(name).build().toString()
        );

        System.out.println(
                new AbstractBuilderSampleSub_001.Builder(name)
                        .addSkill(AbstractBuilderSample.SKILL.JAVA).build().toString()
        );

        System.out.println(
                new AbstractBuilderSampleSub_001.Builder(name)
                        .addSkill(AbstractBuilderSample.SKILL.JAVA)
                        .addSkill(AbstractBuilderSample.SKILL.SPRING_BOOT).build().toString()
        );
    }
}
