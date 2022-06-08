package com.cache.redis.config;

import com.cache.redis.entity.Menu;
import com.cache.redis.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class ProjectConfig {

    private final MenuRepository menuRepository;

    @PostConstruct
    public void menuConfig(){
        menuRepository.save(
                new Menu("BULGOGI_PIZZA","PIZZA")
        );
        menuRepository.save(
                new Menu("CHEESE_PIZZA","PIZZA")
        );
        menuRepository.save(
                new Menu("POTATO_PIZZA","PIZZA")
        );
        menuRepository.save(
                new Menu("GARLIC_CHICKEN","CHICKEN")
        );
        menuRepository.save(
                new Menu("FRIED_CHICKEN","CHICKEN")
        );
    }
}
