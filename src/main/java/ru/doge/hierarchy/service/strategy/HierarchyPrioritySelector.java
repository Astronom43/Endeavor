package ru.doge.hierarchy.service.strategy;

import ru.doge.hierarchy.data.leafs.HierarchyElement;

import java.util.List;

public class HierarchyPrioritySelector {

    private final List<HierarchyPriorityStrategy> strategies;

    public HierarchyPrioritySelector() {
        this.strategies = List.of(
                new ClusterPriorityStrategy(),
                new AssortmentPriorityStrategy(),
                new DivisionPriorityStrategy()
        );
    }

    public <T extends HierarchyElement> HierarchyPriorityStrategy getActualStrategy(Class<T> type) {
        return strategies.stream().filter(next -> next.isActual(type))
                .findFirst().orElseThrow(UnsupportedOperationException::new);
    }
}
