package com.animalfarm.admin.collection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
@RequiredArgsConstructor
public class Trader {
    private String uuid;
    private String name;
    private Long money;
    private List<String> items;
}
