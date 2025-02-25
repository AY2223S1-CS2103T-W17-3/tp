package seedu.modquik.logic.parser.consultation;

import static seedu.modquik.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.modquik.commons.core.index.Index;
import seedu.modquik.logic.commands.consultation.DeleteConsultationCommand;
import seedu.modquik.logic.parser.Parser;
import seedu.modquik.logic.parser.ParserUtil;
import seedu.modquik.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteConsultationCommandParser implements Parser<DeleteConsultationCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteConsultationCommand
     * and returns a DeleteConsultationCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteConsultationCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeleteConsultationCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteConsultationCommand.MESSAGE_USAGE), pe);
        }
    }
}
