package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.reminder.Reminder;

/**
 * An UI component that displays information of a {@code Reminder}.
 */
public class ReminderCard extends UiPart<Region> {

    private static final String FXML = "ReminderListCard.fxml";

    public final Reminder reminder;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label deadline;
    @FXML
    private Label priority;
    @FXML
    private Label description;

    /**
     * Creates a {@code ReminderCode} with the given {@code Reminder} and index to display.
     */
    public ReminderCard(Reminder reminder, int displayedIndex) {
        super(FXML);
        this.reminder = reminder;
        if (!reminder.getStatus()) {
            id.setText(displayedIndex + ". ");

        } else {
            id.setText("✓" + displayedIndex + ". ");
        }
        name.setText(reminder.getName().fullName);
        deadline.setText(reminder.getDeadline().deadline);
        priority.setText(reminder.getPriority().priority);
        setPriorityStyle(reminder.getPriority().priority);
        description.setText(reminder.getDescription().description);
    }

    public void setPriorityStyle(String priorityType) {
        switch (priorityType) {
        case "HIGH":
            priority.getStyleClass().add("cell_priority_high");
            break;
        case "MEDIUM":
            priority.getStyleClass().add("cell_priority_medium");
            break;
        case "LOW":
            priority.getStyleClass().add("cell_priority_low");
            break;
        default:
            break;
        }
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ReminderCard)) {
            return false;
        }

        // state check
        ReminderCard card = (ReminderCard) other;
        return id.getText().equals(card.id.getText())
                && reminder.equals(card.reminder);
    }
}
