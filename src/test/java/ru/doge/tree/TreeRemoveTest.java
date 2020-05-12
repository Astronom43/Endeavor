package ru.doge.tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static ru.doge.tree.TreeRemove.Node;

@ExtendWith(MockitoExtension.class)
public class TreeRemoveTest {

    private List<Node> mockedTree;

    @BeforeEach
    void setUp() {
        Node root = new Node();
        root.setId(0);
        root.setRoot(true);

        Node first = new Node();
        first.setId(100);
        first.setParent(root);

        Node first_first = new Node();
        first_first.setId(101);
        first_first.setParent(first);

        Node first_second = new Node();
        first_second.setId(102);
        first_second.setParent(first);

        Node first_second_first = new Node();
        first_second_first.setId(103);
        first_second_first.setParent(first_second);
        first_second_first.setUserGroup(true);

        first_second.setChild(List.of(first_second_first));
        first.setChild(List.of(first_first, first_second));

        Node second = new Node();
        second.setId(200);
        second.setParent(root);

        Node second_first = new Node();
        second_first.setId(201);
        second_first.setParent(second);
        second_first.setUserGroup(true);


        second.setChild(List.of(second_first));

        root.setChild(List.of(first, second));

        mockedTree = new LinkedList<>();
        mockedTree.add(root);

        mockedTree.add(first);
        mockedTree.add(first_first);
        mockedTree.add(first_second);
        mockedTree.add(first_second_first);

        mockedTree.add(second);
        mockedTree.add(second_first);
    }

    @Test
    void whenInjectCollectionThenCorrect() {
        List<Node> track = new LinkedList<>();
        mockedTree.forEach(next -> track.addAll(TreeRemove.trackUserBranch(next)));

        List<Node> result = mockedTree.stream().filter(node -> !track.contains(node)).collect(Collectors.toList());
        Assertions.assertThat(result).containsExactlyInAnyOrder();
    }
}
