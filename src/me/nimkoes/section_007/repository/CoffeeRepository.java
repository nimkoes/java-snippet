package me.nimkoes.section_007.repository;

import me.nimkoes.section_007.model.Coffee;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CoffeeRepository {

    private Map<String, Coffee> coffeeMap = new HashMap<>();

    @PostConstruct
    public void init() {
        coffeeMap.put("latte", Coffee.builder().name("latte").price(1100).build());
        coffeeMap.put("mocha", Coffee.builder().name("mocha").price(1300).build());
        coffeeMap.put("americano", Coffee.builder().name("americano").price(900).build());
    }

    public int getPriceByName(String name) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coffeeMap.get(name).getPrice();
    }
}
