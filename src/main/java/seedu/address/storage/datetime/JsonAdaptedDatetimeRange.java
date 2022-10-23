package seedu.address.storage.datetime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.datetime.DatetimeRange;

import static seedu.address.logic.parser.DatetimeParserUtil.toDatetimeRange;

/**
 * Jackson-friendly version of {@link DatetimeRange}.
 */
class JsonAdaptedDatetimeRange {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    public final String startDatetime;
    public final String endDatetime;

    /**
     * Constructs a {@code JsonAdaptedDatetimeRange} with the given datetime range details.
     */
    @JsonCreator
    public JsonAdaptedDatetimeRange(@JsonProperty("startDatetime") String startDatetime,
                                    @JsonProperty("endDatetime") String endDatetime) {
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
    }

    /**
     * Converts a given {@code DatetimeRange} into this class for Jackson use.
     */
    public JsonAdaptedDatetimeRange(DatetimeRange source) {
        startDatetime = source.getStartDatetimeFormatted();
        endDatetime = source.getEndDatetimeFormatted();
    }

    /**
     * Converts this Jackson-friendly adapted datetime object into the model's {@code DatetimeRange} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted datetime range.
     */
    public DatetimeRange toModelType() throws IllegalValueException {
        if (startDatetime == null || endDatetime == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, DatetimeRange.class.getSimpleName()));
        }
        return toDatetimeRange("", startDatetime, endDatetime);
    }
}
