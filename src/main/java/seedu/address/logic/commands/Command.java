package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    public abstract CommandResult execute(Model model) throws CommandException;

    /**
     * Returns true if this command makes a change that should be recorded in the undo/redo history.
     * By default commands do not create history entries; mutating commands should override this.
     */
    public boolean shouldRecordInHistory() {
        return false;
    }

    /**
     * Returns true if this command mutates the model (i.e. changes the address book) and therefore
     * requires the data to be saved to storage. For example, undo/redo mutate the model but should
     * not create a new history commit — they should override this to true while keeping shouldRecordInHistory()
     * false.
     */
    public boolean mutatesModel() {
        return false;
    }

}
