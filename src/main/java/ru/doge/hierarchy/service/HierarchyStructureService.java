package ru.doge.hierarchy.service;

import ru.doge.hierarchy.data.Hierarchy;
import ru.doge.hierarchy.data.leafs.HierarchyElement;
import ru.doge.hierarchy.service.strategy.HierarchyPrioritySelector;
import ru.doge.hierarchy.service.strategy.HierarchyPriorityStrategy;

import java.util.List;
import java.util.Optional;

public class HierarchyStructureService {

    private final HierarchyPrioritySelector selector;

    public HierarchyStructureService(HierarchyPrioritySelector selector) {
        this.selector = selector;
    }

    public List<Hierarchy> prioritize(List<Hierarchy> unstructured) {
        sort(unstructured);

        for (Hierarchy next : unstructured) {
            prioritize(next.getChildren());
        }

        return unstructured;
    }

    private void sort(List<Hierarchy> unstructured) {
        Optional<Hierarchy> element = unstructured.stream().findFirst();

        if (element.isPresent()) {
            Hierarchy hierarchy = element.get();
            HierarchyElement data = hierarchy.getData();

            HierarchyPriorityStrategy strategy = selector.getActualStrategy(data.getClass());
            strategy.prioritize(unstructured);
        }
    }
}
