package ru.doge.list;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.doge.last.ListNode;
import ru.doge.last.Operation;

class OperationTest {

    @MethodSource("ru.doge.list.data.OperationTestData#removeFromTailData")
    @ParameterizedTest
    void removeFromTail(ListNode head, int n, ListNode resultHead) {
        Operation operation = new Operation();
        ListNode result = operation.removeFromTail(head, n);

        Assertions.assertThat(result.toString()).isEqualTo(resultHead.toString());
    }
}
