package com.cache.redis.service;

import com.cache.redis.entity.Menu;
import com.cache.redis.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public void init(){
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

    @Cacheable("menu")
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    @Cacheable(key = "#id", value = "menu")
    public Menu getOneMenu(Long id) {
        return menuRepository.findById(id).orElseThrow();
    }
}
