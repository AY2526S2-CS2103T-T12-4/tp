package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code UndoCommand}.
 */
public class UndoCommandTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_noCommandToUndo_failure() {
        // No commits beyond the initial state – canUndoAddressBook() should return false
        assertCommandFailure(new UndoCommand(), model, UndoCommand.MESSAGE_FAILURE);
    }

    @Test
    public void execute_singleUndoableState_success() {
        // Simulate a modifying command by adding a person and committing
        Person person = new PersonBuilder().withName("Undo Test Person")
                .withPhone("91234567").withEmail("undotest@example.com").withAddress("Undo Street").build();

        model.addPerson(person);
        model.commitAddressBook();

        // Expected model should be in the state before the commit (no extra person)
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

        assertCommandSuccess(new UndoCommand(), model, UndoCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_multipleUndoableStates_success() {
        // Commit two modifying states
        Person firstPerson = new PersonBuilder().withName("First Undo Person")
                .withPhone("91111111").withEmail("first@example.com").withAddress("First Street").build();
        Person secondPerson = new PersonBuilder().withName("Second Undo Person")
                .withPhone("92222222").withEmail("second@example.com").withAddress("Second Street").build();

        model.addPerson(firstPerson);
        model.commitAddressBook();
        model.addPerson(secondPerson);
        model.commitAddressBook();

        // Undo once – should go back to state with only firstPerson added
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.addPerson(firstPerson);
        expectedModel.commitAddressBook();

        assertCommandSuccess(new UndoCommand(), model, UndoCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_undoAfterUndoingAll_failure() {
        // Commit one state, undo it manually, then the UndoCommand should fail
        Person person = new PersonBuilder().withName("Undo Test Person")
                .withPhone("91234567").withEmail("undotest@example.com").withAddress("Undo Street").build();

        model.addPerson(person);
        model.commitAddressBook();

        model.undoAddressBook(); // Manually undo to exhaust the history

        assertCommandFailure(new UndoCommand(), model, UndoCommand.MESSAGE_FAILURE);
    }
}
