package ru.doge.hierarchy.service.strategy;

import ru.doge.hierarchy.data.Hierarchy;
import ru.doge.hierarchy.data.leafs.Division;
import ru.doge.hierarchy.data.leafs.HierarchyElement;

import java.util.Comparator;
import java.util.List;

public class DivisionPriorityStrategy implements HierarchyPriorityStrategy {

    private static final Class<Division> CURRENT_STRATEGY_TYPE = Division.class;

    @Override
    public <T extends HierarchyElement> boolean isActual(Class<T> type) {
        return CURRENT_STRATEGY_TYPE.equals(type);
    }

    @Override
    public void prioritize(List<Hierarchy> unstructured) {
        Comparator<Hierarchy> comparator = Comparator.comparing(next -> ((Division) next.getData()).getPriority());
        unstructured.sort(comparator);
    }
}
