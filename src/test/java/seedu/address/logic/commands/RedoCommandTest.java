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
 * Contains integration tests (interaction with the Model) for {@code RedoCommand}.
 */
public class RedoCommandTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_noCommandToRedo_failure() {
        // Nothing has been undone yet – canRedoAddressBook() should return false
        assertCommandFailure(new RedoCommand(), model, RedoCommand.MESSAGE_FAILURE);
    }

    @Test
    public void execute_singleRedoableState_success() {
        // Commit a state, then undo it so that it can be redone
        Person person = new PersonBuilder().withName("Redo Test Person")
                .withPhone("91234567").withEmail("redotest@example.com").withAddress("Redo Street").build();

        model.addPerson(person);
        model.commitAddressBook();

        // Expected model after redo should have the person re-added
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.addPerson(person);
        expectedModel.commitAddressBook();

        model.undoAddressBook(); // Undo so there is something to redo

        assertCommandSuccess(new RedoCommand(), model, RedoCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_multipleRedoableStates_success() {
        // Commit two states, undo both, then redo once
        Person firstPerson = new PersonBuilder().withName("First Redo Person")
                .withPhone("91111111").withEmail("first@example.com").withAddress("First Street").build();
        Person secondPerson = new PersonBuilder().withName("Second Redo Person")
                .withPhone("92222222").withEmail("second@example.com").withAddress("Second Street").build();

        model.addPerson(firstPerson);
        model.commitAddressBook();
        model.addPerson(secondPerson);
        model.commitAddressBook();

        // Undo both commits
        model.undoAddressBook();
        model.undoAddressBook();

        // Redo once – should go to state with only firstPerson added
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.addPerson(firstPerson);
        expectedModel.commitAddressBook();

        assertCommandSuccess(new RedoCommand(), model, RedoCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_redoAfterNewCommit_failure() {
        // Undo history is cleared when a new commit is made, so redo should fail
        Person person = new PersonBuilder().withName("Redo Test Person")
                .withPhone("91234567").withEmail("redotest@example.com").withAddress("Redo Street").build();

        model.addPerson(person);
        model.commitAddressBook();
        model.undoAddressBook(); // Undo to create a redoable state

        // Now make a new commit, which should clear the redo history
        Person newPerson = new PersonBuilder().withName("New Person After Undo")
                .withPhone("93333333").withEmail("newperson@example.com").withAddress("New Street").build();
        model.addPerson(newPerson);
        model.commitAddressBook();

        // Redo should now fail since the redo history was cleared by the new commit
        assertCommandFailure(new RedoCommand(), model, RedoCommand.MESSAGE_FAILURE);
    }
}
