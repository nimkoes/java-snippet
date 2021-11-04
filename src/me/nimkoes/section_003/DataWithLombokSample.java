package me.nimkoes.section_003;

import lombok.Builder;
import lombok.ToString;

@Builder(builderClassName = "Builder", builderMethodName = "myBuilder")
@ToString
public class DataWithLombokSample {
    private final String name;
    private final Integer age;
    private String gender;
    private String address;
    private String desc;

    // 필수 입력 값 정의하는 방법
    public static Builder build(String name, Integer age) {
        return myBuilder()
                .name(name)
                .age(age);
    }
}
