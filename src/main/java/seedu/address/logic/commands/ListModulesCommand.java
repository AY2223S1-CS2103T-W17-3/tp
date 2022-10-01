package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.commons.core.LogsCenter;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;

/**
 * Lists all persons in the address book to the user.
 */
public class ListModulesCommand extends Command {

    public static final String COMMAND_WORD = "list mod";

    public static final String MESSAGE_SUCCESS = "Listed all modules";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        LogsCenter.getLogger(ListModulesCommand.class).info("There are " +
                ((ModelManager) model).getModuleCount() + " modules!!!");
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
