package ru.doge.list.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.jupiter.params.provider.Arguments;
import ru.doge.last.ListNode;

import java.util.List;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OperationTestData {

    public static Stream<Arguments> removeFromTailData() {
        ListNode four = new ListNode(4, null);
        ListNode third = new ListNode(3, four);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);

        ListNode fourRes = new ListNode(4, null);
        ListNode secondRes = new ListNode(2, fourRes);
        ListNode firstRes = new ListNode(1, secondRes);

        return Stream.of(
                Arguments.of(
                        first, 6, firstRes
                )
        );
    }
}
