package seedu.coursepilot.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;

/**
 * Panel containing a mock list of tutorials.
 */
public class TutorialListPanel extends UiPart<Region> {
    private static final String FXML = "TutorialListPanel.fxml";

    private static final ObservableList<String> SAMPLE_TUTORIALS = FXCollections.observableArrayList(
            "CS2103T-W13",
            "CS2103T-W14",
            "CS2103T-W15"
    );

    @FXML
    private ListView<String> tutorialListView;

    public TutorialListPanel() {
        super(FXML);
        tutorialListView.setItems(SAMPLE_TUTORIALS);
    }
}
