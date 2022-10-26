package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.consultation.Consultation;
import seedu.address.model.consultation.ConsultationDescription;
import seedu.address.model.consultation.ConsultationModule;
import seedu.address.model.consultation.ConsultationName;
import seedu.address.model.consultation.ConsultationVenue;
import seedu.address.model.datetime.Datetime;
import seedu.address.model.datetime.DatetimeRange;
import seedu.address.model.datetime.WeeklyTimeslot;
import seedu.address.model.reminder.Reminder;
import seedu.address.model.reminder.ReminderDescription;
import seedu.address.model.reminder.ReminderName;
import seedu.address.model.reminder.ReminderPriority;
import seedu.address.model.student.Attendance;
import seedu.address.model.student.Email;
import seedu.address.model.student.Grade;
import seedu.address.model.student.Name;
import seedu.address.model.student.Participation;
import seedu.address.model.student.Phone;
import seedu.address.model.student.Student;
import seedu.address.model.student.StudentId;
import seedu.address.model.student.TelegramHandle;
import seedu.address.model.tag.Tag;
import seedu.address.model.tutorial.Tutorial;
import seedu.address.model.tutorial.TutorialModule;
import seedu.address.model.tutorial.TutorialName;
import seedu.address.model.tutorial.TutorialVenue;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Student[] getSamplePersons() {
        return new Student[] {
            new Student(new Name("Alex Yeoh"),
                    new StudentId("A0000000a"),
                    new Phone("87438807"), new Email("alexyeoh@example.com"),
                    new TelegramHandle("alexyeoh"),
                    new TutorialModule("CS2103T"), new TutorialName("W17"),
                    new Attendance("0"), new Participation("0"), new Grade("A"),
                getTagSet("friends")),
            new Student(new Name("Bernice Yu"),
                    new StudentId("A0000000B"),
                    new Phone("99272758"), new Email("berniceyu@example.com"),
                    new TelegramHandle("berniceyu"),
                    new TutorialModule("CS2103T"), new TutorialName("W17"),
                    new Attendance("0"), new Participation("0"), new Grade(""),
                getTagSet("colleagues", "friends")),
            new Student(new Name("Charlotte Oliveiro"),
                    new StudentId("A0000000C"),
                    new Phone("93210283"), new Email("charlotte@example.com"),
                    new TelegramHandle("charlotte"),
                    new TutorialModule("CS2103T"), new TutorialName("W17"),
                    new Attendance("0"), new Participation("0"), new Grade("A"),
                getTagSet("neighbours")),
            new Student(new Name("David Li"),
                    new StudentId("A0000000D"),
                    new Phone("91031282"), new Email("lidavid@example.com"),
                    new TelegramHandle("lidavid"),
                    new TutorialModule("CS2103T"), new TutorialName("W17"),
                    new Attendance("0"), new Participation("0"), new Grade("A"),
                getTagSet("family")),
            new Student(new Name("Irfan Ibrahim"),
                    new StudentId("A0000000I"),
                    new Phone("92492021"), new Email("irfan@example.com"),
                    new TelegramHandle("irfan"),
                    new TutorialModule("CS2103T"), new TutorialName("W17"),
                    new Attendance("0"), new Participation("0"), new Grade("A"),
                getTagSet("classmates")),
            new Student(new Name("Roy Balakrishnan"),
                    new StudentId("A0000000R"),
                    new Phone("92624417"), new Email("royb@example.com"),
                    new TelegramHandle("royb"),
                    new TutorialModule("CS2103T"), new TutorialName("W17"),
                    new Attendance("0"), new Participation("0"), new Grade(""),
                    getTagSet("colleagues"))
        };
    }

    public static Reminder[] getSampleReminders() {
        return new Reminder[] {
            new Reminder(new ReminderName("Mark Midterms"),
                    Datetime.fromFormattedString("2022-10-26 20:00"),
                    new ReminderPriority("HIGH"), new ReminderDescription("300 papers to mark")),
            new Reminder(new ReminderName("Send email to TAs"),
                    Datetime.fromFormattedString("2022-10-14 21:00"),
                    new ReminderPriority("MEDIUM"), new ReminderDescription("Erratum in midterms")),
            new Reminder(new ReminderName("Meeting with Prof Lee"),
                    Datetime.fromFormattedString("2022-10-15 22:00"),
                    new ReminderPriority("LOW"), new ReminderDescription("Discuss incoming finals for CS2201")),
        };
    }

    public static Tutorial[] getSampleTutorials() {
        return new Tutorial[] {
            new Tutorial(new TutorialName("W17"), new TutorialModule("CS2103T"),
                    new TutorialVenue("COM1-0203"),
                    WeeklyTimeslot.fromFormattedString("1", "16:00", "18:00")),
            new Tutorial(new TutorialName("F01"), new TutorialModule("CS2103T"),
                    new TutorialVenue("COM1-0201"),
                    WeeklyTimeslot.fromFormattedString("2", "15:00", "17:00")),
            new Tutorial(new TutorialName("F02"), new TutorialModule("CS2103T"),
                    new TutorialVenue("COM1-0202"),
                    WeeklyTimeslot.fromFormattedString("3", "10:00", "11:00")),
        };
    }

    public static Consultation[] getSampleConsultations() {
        return new Consultation[] {
            new Consultation(new ConsultationName("Anna"), new ConsultationModule("CS2103T"),
                    new ConsultationVenue("COM1-0203"),
                    DatetimeRange.fromFormattedString("2022-01-01", "16:00", "18:00"),
                    new ConsultationDescription("Review past year paper")),
            new Consultation(new ConsultationName("Tom"), new ConsultationModule("CS2103T"),
                    new ConsultationVenue("COM1-0201"),
                    DatetimeRange.fromFormattedString("2022-01-01", "15:00", "17:00"),
                    new ConsultationDescription("Review IP code quality")),
            new Consultation(new ConsultationName("John"), new ConsultationModule("CS2103T"),
                    new ConsultationVenue("COM1-0202"),
                    DatetimeRange.fromFormattedString("2022-01-01", "10:00", "11:00"),
                    new ConsultationDescription("Clear doubts about lecture")),
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Student sampleStudent : getSamplePersons()) {
            sampleAb.addPerson(sampleStudent);
        }
        for (Tutorial sampleTutorial: getSampleTutorials()) {
            sampleAb.addTutorial(sampleTutorial);
        }

        for (Consultation sampleConsultation: getSampleConsultations()) {
            sampleAb.addConsultation(sampleConsultation);
        }

        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }
}
