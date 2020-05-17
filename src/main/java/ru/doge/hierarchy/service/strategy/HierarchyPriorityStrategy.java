package ru.doge.hierarchy.service.strategy;

import ru.doge.hierarchy.data.Hierarchy;
import ru.doge.hierarchy.data.leafs.HierarchyElement;

import java.util.List;

public interface HierarchyPriorityStrategy {

    <T extends HierarchyElement> boolean isActual(Class<T> type);
    void prioritize(List<Hierarchy> unstructured);
}
