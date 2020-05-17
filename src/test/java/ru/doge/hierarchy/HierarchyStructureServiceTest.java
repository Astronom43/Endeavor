package ru.doge.hierarchy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.doge.hierarchy.data.Hierarchy;
import ru.doge.hierarchy.data.leafs.Assortment;
import ru.doge.hierarchy.data.leafs.Cluster;
import ru.doge.hierarchy.data.leafs.Division;
import ru.doge.hierarchy.service.HierarchyStructureService;
import ru.doge.hierarchy.service.strategy.HierarchyPrioritySelector;

import java.util.ArrayList;
import java.util.List;

public class HierarchyStructureServiceTest {

    private final HierarchyStructureService service = new HierarchyStructureService(new HierarchyPrioritySelector());

    private List<Hierarchy> unstructured;

    @BeforeEach
    void setUp() {
        unstructured = new ArrayList<>();

        //First tree
        Hierarchy hierarchy_first = new Hierarchy(new Cluster("G", 3));
        Hierarchy hierarchy_first_first = hierarchy_first.addChild(new Division("D_A", 2));
        hierarchy_first_first.addChild(new Assortment("AC_A", 2));
        hierarchy_first_first.addChild(new Assortment("AC_B", 1));

        Hierarchy hierarchy_first_second = hierarchy_first.addChild(new Division("D_B", 1));
        hierarchy_first_second.addChild(new Assortment("AC_C", 2));
        hierarchy_first_second.addChild(new Assortment("AC_D", 1));

        //Second tree
        Hierarchy hierarchy_second = new Hierarchy(new Cluster("L", 2));
        Hierarchy hierarchy_second_first = hierarchy_second.addChild(new Division("D_C", 2));
        hierarchy_second_first.addChild(new Assortment("AC_E", 2));
        hierarchy_second_first.addChild(new Assortment("AC_F", 1));

        Hierarchy hierarchy_second_second = hierarchy_second.addChild(new Division("D_D", 1));
        hierarchy_second_second.addChild(new Assortment("AC_G", 2));
        hierarchy_second_second.addChild(new Assortment("AC_H", 1));

        //Third tree
        Hierarchy hierarchy_third = new Hierarchy(new Cluster("S", 1));
        Hierarchy hierarchy_third_first = hierarchy_third.addChild(new Division("D_E", 2));
        hierarchy_third_first.addChild(new Assortment("AC_J", 2));
        hierarchy_third_first.addChild(new Assortment("AC_K", 1));

        Hierarchy hierarchy_third_second = hierarchy_third.addChild(new Division("D_F", 1));
        hierarchy_third_second.addChild(new Assortment("AC_L", 2));
        hierarchy_third_second.addChild(new Assortment("AC_M", 1));

        unstructured.add(hierarchy_first);
        unstructured.add(hierarchy_second);
        unstructured.add(hierarchy_third);
    }

    @Test
    void name() {
        List<Hierarchy> prioritize = service.prioritize(unstructured);
        Assertions.assertThat(prioritize).containsExactlyInAnyOrder(unstructured.toArray(Hierarchy[]::new));
    }
}
