package me.nimkoes.section_005;

import java.util.regex.Pattern;

public class Main {

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    private static final String[] NUMBERS = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"
    };

    public static void main(String[] args) {
        long startTime = 0L, endTime = 0L;

        /**
         * V1 실행 시간 테스트
         */
        startTime = System.nanoTime();
        for (String number : NUMBERS) isRomanNumeralV1(number);
        endTime = System.nanoTime();
        System.out.println("V1 result : " + (endTime - startTime) + "ns");

        /**
         * V2 실행 시간 테스트
         */
        startTime = System.nanoTime();
        for (String number : NUMBERS) isRomanNumeralV2(number);
        endTime = System.nanoTime();
        System.out.println("V2 result : " + (endTime - startTime) + "ns");

    }

    /**
     * 매번 불필요하게 새로운 객체를 생성하는 버전
     */
    private static boolean isRomanNumeralV1(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /**
     * 한 번 생성한 객체를 재사용 하는 버전
     */
    private static boolean isRomanNumeralV2(String s) {
        return ROMAN.matcher(s).matches();
    }
}
