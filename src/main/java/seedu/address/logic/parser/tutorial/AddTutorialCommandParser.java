package seedu.address.logic.parser.tutorial;

import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_VENUE;

import seedu.address.logic.commands.tutorial.AddTutorialCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.datetime.DatetimeCommonUtils;
import seedu.address.model.datetime.WeeklyTimeslot;
import seedu.address.model.tutorial.Tutorial;
import seedu.address.model.tutorial.TutorialModule;
import seedu.address.model.tutorial.TutorialName;
import seedu.address.model.tutorial.TutorialVenue;


/**
 * Parses input arguments and creates a new AddTutorialCommand object
 */
public class AddTutorialCommandParser implements Parser<AddTutorialCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddTutorialCommand
     * and returns an AddTutorialCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddTutorialCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_MODULE, PREFIX_VENUE,
                        PREFIX_TIME, PREFIX_DATE_DAY);

        ParserUtil.assertAllPrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_MODULE, PREFIX_VENUE,
                PREFIX_TIME, PREFIX_DATE_DAY);

        if (!argMultimap.getPreamble().isEmpty()) {
            String s = argMultimap.getPreamble();
            throw new ParseException(String.format(argMultimap.getPreamble(), AddTutorialCommand.MESSAGE_USAGE));
        }

        TutorialName name = TutorialParserUtil.parseTutorialName(argMultimap.getValue(PREFIX_NAME).get());
        TutorialModule module = TutorialParserUtil.parseTutorialModule(argMultimap.getValue(PREFIX_MODULE).get());
        TutorialVenue venue = TutorialParserUtil.parseTutorialVenue(argMultimap.getValue(PREFIX_VENUE).get());

        String dayString = argMultimap.getValue(PREFIX_DATE_DAY).get();
        String timeslotString = argMultimap.getValue(PREFIX_TIME).get();
        WeeklyTimeslot timeslot = DatetimeCommonUtils.parseWeeklyTimeslot(dayString, timeslotString);

        Tutorial tutorial = new Tutorial(name, module, venue, timeslot);

        return new AddTutorialCommand(tutorial);
    }
}
