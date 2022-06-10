package com.cache.redis.service;

import com.cache.redis.entity.Menu;
import com.cache.redis.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuRepository menuRepository;

    /**
     * 메뉴를 전체 조회하는 서비스 로직
     * 저장될때 "menu(CacheName)::SimpleKey [](Key)" 형식으로 저장
     * @return menu
     */
    @Cacheable(cacheNames = "menu")
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    /**
     * 메뉴를 단일 조회하는 서비스 로직
     * 저장될때 "menu(CacheName)::num(Key)" 형식으로 저장
     * @return menu
     */
    @Cacheable(key = "#id", cacheNames = "menu")
    public Menu getOneMenu(Long id) {
        return menuRepository.findById(id).orElseThrow();
    }
}
