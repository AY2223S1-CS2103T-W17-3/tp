package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.datetime.Datetime;
import seedu.address.model.reminder.Reminder;
import seedu.address.model.reminder.ReminderDescription;
import seedu.address.model.reminder.ReminderName;

import static seedu.address.logic.parser.DatetimeParserUtil.toDatetime;

/**
 * Jackson-friendly version of {@link Reminder}.
 */

class JsonAdaptedReminder {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Reminder's %s field is missing!";
    private final String name;
    private final String deadline;
    private final String description;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given reminder details.
     */
    @JsonCreator
    public JsonAdaptedReminder(@JsonProperty("name") String name, @JsonProperty("deadline") String deadline,
                               @JsonProperty("description") String description) {
        this.name = name;
        this.deadline = deadline;
        this.description = description;
    }

    /**
     * Converts a given {@code Reminder} into this class for Jackson use.
     */
    public JsonAdaptedReminder(Reminder source) {
        name = source.getName().fullName;
        deadline = source.getDeadline().toString();
        description = source.getDescription().description;
    }

    /**
     * Converts this Jackson-friendly adapted reminder object into the model's {@code Reminder} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted reminder.
     */
    public Reminder toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ReminderName.class.getSimpleName()));
        }
        if (!ReminderName.isValidName(name)) {
            throw new IllegalValueException(ReminderName.MESSAGE_CONSTRAINTS);
        }
        final ReminderName modelName = new ReminderName(name);

        final ReminderDescription modelDescription = new ReminderDescription(description);

        Datetime modelDeadline = toDatetime("Not implemetned");

        return new Reminder(modelName, modelDeadline, modelDescription);
    }
}
