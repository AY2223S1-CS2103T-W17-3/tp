package seedu.address.logic.parser.tutorial;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tutorial.*;

import java.util.Objects;

public class TutorialParserUtil {
    /**
     * Parses a {@code String name} into a {@code TutorialName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static TutorialName parseTutorialName(String name) throws ParseException {
        Objects.requireNonNull(name);
        String trimmedName = name.trim();
        if (!TutorialName.isValidName(trimmedName)) {
            throw new ParseException(TutorialName.MESSAGE_CONSTRAINTS);
        }
        return new TutorialName(trimmedName);
    }

    /**
     * Parses a {@code String moduleName} into a {@code TutorialModule}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code moduleName} is invalid.
     */
    public static TutorialModule parseTutorialModule(String moduleName) throws ParseException {
        Objects.requireNonNull(moduleName);
        String trimmedName = moduleName.trim();
        if (!TutorialModule.isValidModule(trimmedName)) {
            throw new ParseException(TutorialModule.MESSAGE_CONSTRAINTS);
        }
        return new TutorialModule(trimmedName);
    }

    /**
     * Parses a {@code String venue} into a {@code TutorialVenue}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code venue} is invalid.
     */
    public static TutorialVenue parseTutorialVenue(String venue) throws ParseException {
        Objects.requireNonNull(venue);
        String trimmedName = venue.trim();
        if (!TutorialVenue.isValidVenue(trimmedName)) {
            throw new ParseException(TutorialVenue.MESSAGE_CONSTRAINTS);
        }
        return new TutorialVenue(trimmedName);
    }

    /**
     * Parses a {@code String timeslot} into a {@code TutorialTimeslot}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code timeslot} is invalid.
     */
    public static TutorialTimeslot parseTutorialTimeslot(String timeslot) throws ParseException {
        Objects.requireNonNull(timeslot);
        String trimmedName = timeslot.trim();
        if (!TutorialTimeslot.isValidTimeslot(trimmedName)) {
            throw new ParseException(TutorialTimeslot.MESSAGE_CONSTRAINTS);
        }
        if (!TutorialTimeslot.isValidDuration(trimmedName)) {
            throw new ParseException(TutorialTimeslot.MESSAGE_INVALID_DURATION);
        }
        return new TutorialTimeslot(trimmedName);
    }

    /**
     * Parses a {@code String day} into a {@code TutorialDay}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code day} is invalid.
     */
    public static TutorialDay parseTutorialDay(String day) throws ParseException {
        Objects.requireNonNull(day);
        String trimmedValue = day.trim();
        if (!TutorialDay.isValidDay(trimmedValue)) {
            throw new ParseException(TutorialDay.MESSAGE_CONSTRAINTS);
        }
        return new TutorialDay(trimmedValue);
    }
}