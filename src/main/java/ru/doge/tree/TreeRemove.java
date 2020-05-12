package ru.doge.tree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class TreeRemove {

    private TreeRemove() {
    }

    public static List<Node> trackUserBranch(Node node) {
        List<Node> track = new LinkedList<>();
        if (node.isUserGroup) {
            track(node, track);
        }
        return track;
    }

    private static void track(Node node, List<Node> track) {
        if (node.getParent() != null && (node.getChild() == null || node.getChild().size() == 1)) {
            track.add(0, node);
            track(node.getParent(), track);
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Node {

        private int id;
        private boolean isRoot;
        private Node parent;
        private List<Node> child;
        private boolean isUserGroup;
    }
}
