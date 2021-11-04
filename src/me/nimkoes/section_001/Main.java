package me.nimkoes.section_001;

/**
 * autoboxing 테스트
 *
 * [실행 결과]
 * use autoboxing : 6644 ms
 * not use autoboxing : 609 ms
 *
 * 되도록 박싱된 기본 타입보다 기본 타입을 사용하고
 * 의도하지 않은 오토박싱이 사용되지 않도록 주의 필요
 *
 */
public class Main {
    
    public static void main(String[] args) {
        long startTime, endTime;
        
        startTime = System.currentTimeMillis();
        sum_with_autoboxing();
        endTime = System.currentTimeMillis();
        System.out.println("use autoboxing : " + (endTime - startTime) + " ms");
        
        startTime = System.currentTimeMillis();
        sum_without_autoboxing();
        endTime = System.currentTimeMillis();
        System.out.println("not use autoboxing : " + (endTime - startTime) + " ms");
        
        
    }
    
    private static long sum_with_autoboxing() {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; ++i) {
            sum += i;
        }
        return sum;
    }
    
    private static long sum_without_autoboxing() {
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; ++i) {
            sum += i;
        }
        return sum;
    }
}
