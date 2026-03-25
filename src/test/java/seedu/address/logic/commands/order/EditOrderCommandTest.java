package seedu.address.logic.commands.order;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;

public class EditOrderCommandTest {
    @Test
    public void equals_sameType_returnsTrue() {
        assertTrue(new EditOrderCommand(Index.fromOneBased(1),
                new EditOrderCommand.EditOrderDescriptor())
                .equals(new EditOrderCommand(Index.fromOneBased(1),
                        new EditOrderCommand.EditOrderDescriptor())));
    }
}
