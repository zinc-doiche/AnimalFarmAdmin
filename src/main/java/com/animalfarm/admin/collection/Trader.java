package com.animalfarm.admin.collection;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.List;

@Entity
@QueryEntity
@Getter @Setter @ToString
@RequiredArgsConstructor
public class Trader {
    private String uuid;
    private Long money;
    private List<String> items;
}
