package com.cache.redis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu {

    @Id @GeneratedValue
    private Long id;

    private String menuName;
    private String partName;

    public Menu(String menuName, String partName) {
        this.menuName = menuName;
        this.partName = partName;
    }
}
