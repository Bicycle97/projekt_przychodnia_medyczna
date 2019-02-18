package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import controller.MenuController;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class MenuView {

    private MenuController menuController;
    private Pane mainMainPane = new Pane();
    private Pane restInformationPane = new Pane();
    private JFXButton menuButton1 = new JFXButton();
    private JFXButton menuButton2 = new JFXButton();
    private JFXButton menuButton3 = new JFXButton();
    private JFXButton menuButton4 = new JFXButton();
    private Label restInformationLabel = new Label();
    private JFXSpinner restReadingSpinner = new JFXSpinner();

    public MenuView(MenuController menuController) {

        this.menuController = menuController;
        setSettingsContent();
        setContentToParent();
    }

    public Pane getMainMainPane() {
        return mainMainPane;
    }

    public void setMainMainPane(Pane mainMainPane) {
        this.mainMainPane = mainMainPane;
    }

    private void setSettingsContent() {

        restInformationPane.setId("restInformationPane");
        restInformationPane.setPrefHeight(50);
        restInformationPane.setPrefWidth(237);
        restInformationPane.setLayoutX(4);
        restInformationPane.setLayoutY(401);
        restInformationPane.getChildren().addAll(restInformationLabel, restReadingSpinner);
        restInformationPane.setVisible(false);

        restInformationLabel.setId("restInformationLabel");
        restInformationLabel.setLayoutX(0);
        restInformationLabel.setLayoutY(0);
        restInformationLabel.setPrefHeight(50);
        restInformationLabel.setPrefWidth(172);
        restInformationLabel.setFont(new Font("System Bold", 15));
        restInformationLabel.setWrapText(true);
        restInformationLabel.setTextAlignment(TextAlignment.CENTER);

        restReadingSpinner.setId("restReadingSpinner");
        restReadingSpinner.setLayoutX(178);
        restReadingSpinner.setLayoutY(8);
        restReadingSpinner.setPrefHeight(34);
        restReadingSpinner.setPrefWidth(37);

        mainMainPane.setId("mainMainPane");
        mainMainPane.setPrefHeight(345);
        mainMainPane.setPrefWidth(219);
        mainMainPane.setLayoutX(0);
        mainMainPane.setLayoutY(0);
        mainMainPane.setVisible(false);

        menuButton1.setId("menuButton1");
        menuButton1.setButtonType(JFXButton.ButtonType.RAISED);
        menuButton1.setPrefWidth(224);
        menuButton1.setPrefHeight(87);
        menuButton1.setLayoutX(-5);
        menuButton1.setLayoutY(0);
        menuButton1.setFont(new Font("Avenir Next LT W04 Demi",15));
        menuButton1.setWrapText(true);

        menuButton2.setId("menuButton2");
        menuButton2.setButtonType(JFXButton.ButtonType.RAISED);
        menuButton2.setLayoutX(-5);
        menuButton2.setLayoutY(87);
        menuButton2.setPrefWidth(224);
        menuButton2.setPrefHeight(87);
        menuButton2.setFont(new Font("Avenir Next LT W04 Demi",15));


        menuButton3.setId("menuButton3");
        menuButton3.setButtonType(JFXButton.ButtonType.RAISED);
        menuButton3.setLayoutX(-5);
        menuButton3.setLayoutY(173);
        menuButton3.setPrefWidth(224);
        menuButton3.setPrefHeight(87);
        menuButton3.setFont(new Font("Avenir Next LT W04 Demi",15));

        menuButton4.setId("menuButton4");
        menuButton4.setButtonType(JFXButton.ButtonType.RAISED);
        menuButton4.setLayoutX(-5);
        menuButton4.setLayoutY(260);
        menuButton4.setPrefWidth(224);
        menuButton4.setPrefHeight(87);
        menuButton4.setFont(new Font("Avenir Next LT W04 Demi",15));

        mainMainPane.getChildren().addAll(menuButton1,menuButton2,menuButton3,menuButton4);
    }

    public void setContentToParent() {
        getMenuController().getBasicController().getBasicView().getMenuPane().getChildren().addAll(mainMainPane, restInformationPane);
    }

    public void deleteAllElementsFromParent() {
        getMenuController().getBasicController().getBasicView().getMenuPane().getChildren().removeAll(mainMainPane, restInformationPane);
    }

    public MenuController getMenuController() {
        return menuController;
    }
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public JFXButton getMenuButton1() {
        return menuButton1;
    }
    public void setMenuButton1(JFXButton menuButton1) {
        this.menuButton1 = menuButton1;
    }

    public JFXButton getMenuButton2() {
        return menuButton2;
    }
    public void setMenuButton2(JFXButton menuButton2) {
        this.menuButton2 = menuButton2;
    }

    public JFXButton getMenuButton3() {
        return menuButton3;
    }
    public void setMenuButton3(JFXButton menuButton3) {
        this.menuButton3 = menuButton3;
    }

    public JFXButton getMenuButton4() {
        return menuButton4;
    }
    public void setMenuButton4(JFXButton menuButton4) {
        this.menuButton4 = menuButton4;
    }

    public Label getRestInformationLabel() {
        return restInformationLabel;
    }

    public void setRestInformationLabel(Label restInformationLabel) {
        this.restInformationLabel = restInformationLabel;
    }

    public JFXSpinner getRestReadingSpinner() {
        return restReadingSpinner;
    }
    public void setRestReadingSpinner(JFXSpinner restReadingSpinner) {
        this.restReadingSpinner = restReadingSpinner;
    }

    public void addRestInformationLabelToParent() {
        getMenuController().getBasicController().getBasicView().getHeaderPane().getChildren().add(getRestInformationLabel());
    }

    public void deleteRestInformationLabelFromParent() {
        getMenuController().getBasicController().getBasicView().getHeaderPane().getChildren().remove(getRestInformationLabel());
    }

    public Pane getRestInformationPane() {
        return restInformationPane;
    }
    public void setRestInformationPane(Pane restInformationPane) {
        this.restInformationPane = restInformationPane;
    }
}
