package com.animalfarm.admin.collection;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter @ToString
public class DocumentedItem {
    private final String name;
    private final List<String> lore;
    private final String material;
    private final int amount;

    @Builder
    public DocumentedItem(String name, List<String> lore, String material, int amount) {
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.amount = amount;
    }
}
