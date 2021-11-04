package me.nimkoes.section_003;

public class SampleData {
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private String desc;

    // builder 는 static 클래스로 내부에 구현하는 것이 일반적
    public static class Builder {
        // 필수값
        private final String name;
        private final Integer age;

        // 선택값
        private String gender;
        private String address;
        private String desc;

        public Builder(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        // outer class 인 SampleData 클래스 객체를 반환하는 builder 메소드
        public SampleData build() {
            return new SampleData(this);
        }
    }

    // inner static class 를 전달 받는 private constructor 정의
    private SampleData(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;

        this.gender = builder.gender;
        this.address = builder.address;
        this.desc = builder.desc;
    }

    // 값을 확인해보기 위해 toString override
    @Override
    public String toString() {
        return "SampleData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
