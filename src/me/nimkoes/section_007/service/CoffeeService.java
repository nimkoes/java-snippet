package me.nimkoes.section_007.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.nimkoes.section_007.CoffeeUseCase;
import me.nimkoes.section_007.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@RequiredArgsConstructor
@Service
public class CoffeeService implements CoffeeUseCase {

    private final CoffeeRepository coffeeRepository;
    Executor executor = Executors.newFixedThreadPool(10);

    @Override
    public int getPrice(String name) {
        log.info("[getPrice] 동기 처리 {}", name);
        return coffeeRepository.getPriceByName(name);
    }

    @Override
    public CompletableFuture<Integer> getPriceAsyncV1(String name) {
        log.info("[getPriceAsyncV1] 비동기 처리 {}", name);

        CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(() -> {
            log.info("새로운 스레드를 생성해서 처리");
            Integer price = coffeeRepository.getPriceByName(name);
            future.complete(price);
        }).start();

        return future;
    }

    @Override
    public CompletableFuture<Integer> getPriceAsyncV2(String name) {
        log.info("[getPriceAsyncV2] 비동기 처리 {}", name);
        return CompletableFuture.supplyAsync(() -> {
            log.info("[CompletableFuture.supplyAsync] {}", name);
            return coffeeRepository.getPriceByName(name);
        }, executor);
    }

    @Override
    public Future<Integer> getDiscountPriceAsync(Integer price) {
        log.info("[getDiscountPriceAsync] 비동기 처리 {}", price);
        return null;
    }
}
