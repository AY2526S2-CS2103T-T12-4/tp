package seedu.address.logic.commands.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EditOrderDescriptorTest {
    @Test
    public void toStringMethod() {
        EditOrderCommand.EditOrderDescriptor editOrderDescriptor = new EditOrderCommand.EditOrderDescriptor();
        String expected = EditOrderCommand.EditOrderDescriptor.class.getCanonicalName() + "{orderMap="
                + editOrderDescriptor.getProductQuantityPairs() + "}";
        assertEquals(expected, editOrderDescriptor.toString());
    }
}
