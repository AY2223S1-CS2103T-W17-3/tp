package seedu.address.model.reminder;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.datetime.Datetime;

/**
 * Represents a Reminder in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Reminder implements Comparable<Reminder>{

    // Identity fields
    private final ReminderName name;

    //Data fields
    private final Datetime deadline;
    private final ReminderDescription description;
    private final ReminderPriority priority;
    private ReminderStatus isDone;

    /**
     * Every field must be present and not null.
     */
    public Reminder(ReminderName name, Datetime deadline, ReminderPriority priority,
                ReminderDescription description) {
        requireAllNonNull(name, deadline, priority);
        this.name = name;
        this.deadline = deadline;
        this.priority = priority;
        this.description = description;
        this.isDone = new ReminderStatus(false);
    }

    /**
     * Every field must be present and not null.
     */
    public Reminder(ReminderName name, Datetime deadline, ReminderPriority priority,
                    ReminderDescription description, ReminderStatus status) {
        requireAllNonNull(name, deadline, priority);
        this.name = name;
        this.deadline = deadline;
        this.priority = priority;
        this.description = description;
        this.isDone = status;
    }

    public void setStatus(boolean status) {
        isDone.mark(status);
    }

    public ReminderName getName() {
        return name;
    }

    public Datetime getDeadline() {
        return deadline;
    }

    public ReminderPriority getPriority() {
        return priority;
    }

    public ReminderDescription getDescription() {
        return description;
    }

    public boolean getStatus() {
        return isDone.getStatus();
    }
    
    public int getPriorityValue() {
        return priority.getPriorityValue();
    }

    /**
     * Returns true if both reminders have the same name.
     * This defines a weaker notion of equality between two reminders.
     */
    public boolean isSameReminder(Reminder otherReminder) {
        if (otherReminder == this) {
            return true;
        }

        return otherReminder != null
                && otherReminder.getName().equals(getName());
    }

    /*
     * This is where we write the logic to sort. This method sort
     * automatically by the first name in case that the last name is
     * the same.
     */
    @Override
    public int compareTo(Reminder other) {
        int otherPriorityValue = other.getPriorityValue();
        int thisPriorityValue = this.getPriorityValue();
        if (otherPriorityValue == thisPriorityValue) {
            return this.getName().fullName.compareTo(other.getName().fullName);
        } else {
            return thisPriorityValue - otherPriorityValue;
        }
    }

    /**
     * Returns true if both reminders have the same identity and data fields.
     * This defines a stronger notion of equality between two reminders.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Reminder)) {
            return false;
        }

        Reminder otherReminder = (Reminder) other;
        return otherReminder.getName().equals(getName());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, deadline, description);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Deadline: ")
                .append(getDeadline())
                .append("; Priority: ")
                .append(getPriority())
                .append("; Details: ")
                .append(getDescription());

        return builder.toString();
    }
}
