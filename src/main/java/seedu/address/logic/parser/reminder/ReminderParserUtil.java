package seedu.address.logic.parser.reminder;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.reminder.ReminderDeadline;
import seedu.address.model.reminder.ReminderDescription;
import seedu.address.model.reminder.ReminderName;

import java.util.Objects;

public class ReminderParserUtil {
    /**
     * Parses a {@code String name} into a {@code ReminderName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code ReminderName} is invalid.
     */
    public static ReminderName parseReminderName(String name) throws ParseException {
        Objects.requireNonNull(name);
        String trimmedName = name.trim();
        if (!ReminderName.isValidName(trimmedName)) {
            throw new ParseException(ReminderName.MESSAGE_CONSTRAINTS);
        }
        return new ReminderName(trimmedName);
    }

    /**
     * Parses a {@code String deadline} into a {@code ReminderDeadline}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code ReminderDeadline} is invalid.
     */
    public static ReminderDeadline parseReminderDeadline(String deadline) throws ParseException {
        Objects.requireNonNull(deadline);
        String trimmedDeadline = deadline.trim();
        if (!ReminderDeadline.isValidTimeslot(trimmedDeadline)) {
            throw new ParseException(ReminderDeadline.MESSAGE_CONSTRAINTS);
        }
        return new ReminderDeadline(trimmedDeadline);
    }

    /**
     * Parses a {@code String description} into a {@code ReminderDescription}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static ReminderDescription parseReminderDescription(String description) {
        String trimmedDescription = description.trim();
        return new ReminderDescription(trimmedDescription);
    }
}