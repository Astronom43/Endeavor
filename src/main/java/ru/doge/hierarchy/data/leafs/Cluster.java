package ru.doge.hierarchy.data.leafs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cluster implements HierarchyElement {

    private final String code;
    private final Integer priority;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.code + " Name";
    }
}
