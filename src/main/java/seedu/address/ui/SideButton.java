package seedu.address.ui;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;

/**
 * The UI component that is responsible for navigating.
 */
public class SideButton extends UiPart<Region> {

    public static final String STUDENT_LOGO_URL = "/images/calendar.png";
    public static final String TUTORIAL_LOGO_URL = "/images/calendar.png";
    private static final String FXML = "SideButton.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    @FXML
    private Button sideButton;
    @FXML
    private ImageView logo;

    /**
     * Creates a {@code SideButton} with the given title logoUrl and {@code EventHandler}.
     */
    public SideButton(String title, String logoUrl, EventHandler<ActionEvent> handleEvent) {
        super(FXML);
        this.sideButton.setText(title);
        this.logo.setImage(new Image(logoUrl));
        sideButton.setOnAction(handleEvent);
    }
}
