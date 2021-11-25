package me.nimkoes.section_007;

import java.util.concurrent.Future;

public interface CoffeeUseCase {
    int getPrice(String name);
    Future<Integer> getPriceAsyncV1(String name);
    Future<Integer> getPriceAsyncV2(String name);
    Future<Integer> getDiscountPriceAsync(Integer price);
}
