package seedu.address.logic.commands.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalOrders.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ListOrderCommandTest {

    @Test
    public void execute_emptyOrderList_returnsNoOrdersMessage() throws Exception {
        CommandResult result = new ListOrderCommand().execute(new ModelManager());
        assertEquals(ListOrderCommand.MESSAGE_NO_ORDERS, result.getFeedbackToUser());
    }

    @Test
    public void execute_nonEmptyOrderList_returnsSuccessMessage() throws Exception {
        ModelManager model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        CommandResult result = new ListOrderCommand().execute(model);
        assertEquals(ListOrderCommand.MESSAGE_SUCCESS, result.getFeedbackToUser());
    }

    @Test
    public void equals_sameType_returnsTrue() {
        assertTrue(new ListOrderCommand().equals(new ListOrderCommand()));
    }
}
