package ru.doge.hierarchy.data;

import lombok.Getter;
import ru.doge.hierarchy.data.leafs.HierarchyElement;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Hierarchy {

    private final HierarchyElement data;

    private Hierarchy parent;
    private final List<Hierarchy> children;

    public Hierarchy(HierarchyElement data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    public Hierarchy addChild(HierarchyElement child) {
        Hierarchy leaf = new Hierarchy(child);
        leaf.parent = this;
        this.children.add(leaf);
        return leaf;
    }
}
