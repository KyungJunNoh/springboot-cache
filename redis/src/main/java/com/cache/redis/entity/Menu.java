package com.cache.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Menu {

    @Id @GeneratedValue
    private Long id;

    private String menuName;
    private String PART_Name;

    public Menu(String menuName, String PART_Name) {
        this.menuName = menuName;
        this.PART_Name = PART_Name;
    }
}
