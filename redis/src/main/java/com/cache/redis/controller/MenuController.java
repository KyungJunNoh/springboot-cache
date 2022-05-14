package com.cache.redis.controller;

import com.cache.redis.entity.Menu;
import com.cache.redis.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/init")
    public ResponseEntity<String> init(){
        menuService.init();
        return ResponseEntity.ok("success");
    }

    @GetMapping("/all/menu")
    public List<Menu> getAllMenu(){
        log.info("getAllMenu 호출");
        return menuService.getAllMenu();
    }

    @GetMapping("menu/{id}")
    public Menu getOneMenu(@PathVariable Long id){
        log.info("getOneMenu 호출");
        return menuService.getOneMenu(id);
    }
}
