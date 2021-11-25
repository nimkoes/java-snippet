package me.nimkoes.section_007;

import lombok.extern.slf4j.Slf4j;
import me.nimkoes.section_007.repository.CoffeeRepository;
import me.nimkoes.section_007.service.CoffeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = {CoffeeService.class, CoffeeRepository.class})
public class MainTestApp {
    @Autowired
    private CoffeeService coffeeService;

    @Test
    @DisplayName("동기 방식 테스트")
    public void sync() {
        int expectedPrice = 1100;
        int result = coffeeService.getPrice("latte");

        assertThat(result).isEqualTo(expectedPrice);
    }

    @Test
    @DisplayName("비동기 방식 / join 으로 결과를 요청할 때 blocking 걸림")
    public void async_blocking_v1() {
        int expectedPrice = 1100;
        CompletableFuture<Integer> future = coffeeService.getPriceAsyncV1("latte");
        log.info("결과를 기다리지 않고 다른 작업 실행");
        Integer result = future.join();
        log.info("종료 {}", result);

        assertThat(result).isEqualTo(expectedPrice);
    }

    @Test
    @DisplayName("비동기 방식 / join 으로 결과를 요청할 때 blocking 걸림")
    public void async_blocking_v2() {
        int expectedPrice = 1100;
        CompletableFuture<Integer> future = coffeeService.getPriceAsyncV2("latte");
        log.info("결과를 기다리지 않고 다른 작업 실행");
        Integer result = future.join();
        log.info("종료 {}", result);

        assertThat(result).isEqualTo(expectedPrice);
    }

    @Test
    @DisplayName("비동기 / non blocking 방식 / thenAccept")
    public void async_non_blocking_accept() {
        int expectedPrice = 1100;

        /**
         * thenAccept 는 CompletableFuture<Void> 를 반환 하기 때문에
         * 응답 결과를 받아 처리할 수 없다.
         */
        CompletableFuture<Void> future = coffeeService
                .getPriceAsyncV2("latte")
                .thenAccept(p -> {
                    log.info("[thenAccept] callback price={}, 결과를 반환하지는 않음", p);
                });

        log.info("결과를 기다리지 않고 다른 작업 실행");
        // main thread 종료 방지
        future.join();
        log.info("종료");
    }

    @Test
    @DisplayName("비동기 / non blocking 방식 / thenApply")
    public void async_non_blocking_apply() {
        int expectedPrice = 1100;

        /**
         * thenAccept 는 CompletableFuture<Void> 를 반환 하기 때문에
         * 응답 결과를 받아 처리할 수 없다.
         */
        CompletableFuture<Void> future = coffeeService
                .getPriceAsyncV2("latte")
                .thenApply(p -> {
                    log.info("[thenApply] price={}", p);
                    return p + 100;
                })
                .thenAccept(p -> {
                    log.info("[thenAccept] price={}, thenApply 에서 반환 한 값을 받아옴", p);
                });

        log.info("결과를 기다리지 않고 다른 작업 실행");
        // main thread 종료 방지
        future.join();
        log.info("done");
    }
}
