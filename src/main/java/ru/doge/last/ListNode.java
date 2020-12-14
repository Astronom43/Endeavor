package ru.doge.last;

import lombok.Getter;
import lombok.Setter;

import java.util.StringJoiner;

@Setter
@Getter
public class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

}
