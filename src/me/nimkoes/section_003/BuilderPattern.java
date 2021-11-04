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

        /**
         * builder 를 직접 구현했을 때와
         * lombok 라이브러리의 @Builder 사용했을 때 비교
         */
        DataSample dataSample = new DataSample.Builder(name, 99).gender("male").build();
        DataWithLombokSample build = DataWithLombokSample.build(name, 99).desc("샘플 테스트").build();

        System.out.println(dataSample);
        System.out.println(build);

    }
}
