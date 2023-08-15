package com.animalfarm.admin.collection;

import lombok.*;

import java.util.List;

@Getter @Setter @ToString
@RequiredArgsConstructor
public class DocumentedItem {
    private String name;
    private List<String> lore;
    private String material;
    private int amount;
}
