package seedu.address.logic.parser.consultation;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIMESLOT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_VENUE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.consultation.EditConsultationCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.datetime.DatetimeCommonUtils;
import seedu.address.model.datetime.DatetimeRange;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditConsultationCommandParser implements Parser<EditConsultationCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the EditConsultCommand
     * and returns an EditConsultCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditConsultationCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_MODULE, PREFIX_VENUE, PREFIX_DAY, PREFIX_TIMESLOT,
                        PREFIX_DESCRIPTION);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    EditConsultationCommand.MESSAGE_USAGE), pe);
        }

        EditConsultationCommand.EditConsultDescriptor editConsultDescriptor =
                new EditConsultationCommand.EditConsultDescriptor();
        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            editConsultDescriptor.setName(
                    ConsultationParserUtil.parseConsultationName(argMultimap.getValue(PREFIX_NAME).get()));
        }
        if (argMultimap.getValue(PREFIX_MODULE).isPresent()) {
            editConsultDescriptor.setModule(
                    ConsultationParserUtil.parseConsultationModule(argMultimap.getValue(PREFIX_MODULE).get()));
        }
        if (argMultimap.getValue(PREFIX_VENUE).isPresent()) {
            editConsultDescriptor.setVenue(
                    ConsultationParserUtil.parseConsultationVenue(argMultimap.getValue(PREFIX_VENUE).get()));
        }
        if (argMultimap.getValue(PREFIX_DAY).isPresent() && argMultimap.getValue(PREFIX_TIMESLOT).isPresent()) {
            String date = argMultimap.getValue(PREFIX_DAY).get();
            String timeslot = argMultimap.getValue(PREFIX_TIMESLOT).get();
            DatetimeRange datetime = DatetimeCommonUtils.parseDatetimeRange(date, timeslot);
            editConsultDescriptor.setTimeSlot(datetime);
        }
        if (argMultimap.getValue(PREFIX_DESCRIPTION).isPresent()) {
            editConsultDescriptor.setDescription(
                    ConsultationParserUtil.parseConsultationDescription(
                            argMultimap.getValue(PREFIX_DESCRIPTION).get()));
        }
        //Only day
        if (argMultimap.getValue(PREFIX_DAY).isPresent() && !argMultimap.getValue(PREFIX_TIMESLOT).isPresent()) {
            throw new ParseException(EditConsultationCommand.MESSAGE_DATETIME_CONSULTATION);
        }
        //Only timeslot
        if (!argMultimap.getValue(PREFIX_DAY).isPresent() && argMultimap.getValue(PREFIX_TIMESLOT).isPresent()) {
            throw new ParseException(EditConsultationCommand.MESSAGE_DATETIME_CONSULTATION);
        }
        if (!editConsultDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditConsultationCommand.MESSAGE_NOT_EDITED);
        }

        return new EditConsultationCommand(index, editConsultDescriptor);
    }
}
