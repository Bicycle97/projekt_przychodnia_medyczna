package view.loginPanel;

import com.jfoenix.controls.JFXSpinner;
import controller.LoadingController;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import view.Internationalization;

import static javafx.scene.paint.Color.RED;

public class LoadingView implements Internationalization {

    private JFXSpinner loadingSpinner = new JFXSpinner();
    private Label textLabel = new Label();
    private Label noConnectLabel = new Label();
    private Label logoLabel = new Label();
    private Label titleLabel = new Label();
    private Pane spinnerPane = new Pane();

    private LoadingController loadingController;

    public LoadingView(LoadingController loadingController) {
        this.loadingController = loadingController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){

        spinnerPane.setId("spinerPane");
        spinnerPane.setPrefHeight(444);
        spinnerPane.setPrefWidth(500);
        spinnerPane.setLayoutX(42);
        spinnerPane.setLayoutY(14);
        spinnerPane.setStyle("-fx-background-color: #9abec3; -fx-background-radius: 40px;");

        loadingSpinner.setId("spinerSpiner");
        loadingSpinner.setCache(true);
        loadingSpinner.setLayoutX(196);
        loadingSpinner.setLayoutY(222);
        loadingSpinner.setPrefHeight(76);
        loadingSpinner.setPrefWidth(89);
        loadingSpinner.setRadius(30);


        textLabel.setId("textWaitField");
        textLabel.setCache(true);
        textLabel.setLayoutX(195);
        textLabel.setLayoutY(332);
        textLabel.setPrefHeight(21);
        textLabel.setPrefWidth(156);
        textLabel.setText("Poczekaj chwilę");
        textLabel.setFont(new Font("System Bold Italic",15));

        noConnectLabel.setId("textNoConnectField");
        noConnectLabel.setCache(true);
        noConnectLabel.setLayoutX(172);
        noConnectLabel.setLayoutY(250);
        noConnectLabel.setPrefHeight(21);
        noConnectLabel.setPrefWidth(156);
        noConnectLabel.setText("Brak połączenia z bazą");
        noConnectLabel.setTextFill(RED);
        noConnectLabel.setVisible(false);


        titleLabel.setId("titleField");
        titleLabel.setLayoutX(120);
        titleLabel.setLayoutY(154);
        titleLabel.setPrefHeight(50);
        titleLabel.setPrefWidth(272);
        titleLabel.setText("PRZYCHODNIA ZDROWIA");
        titleLabel.setFont(new Font("Bauhaus 93",22));

        logoLabel.setId("logoField");
        logoLabel.setLayoutX(196);
        logoLabel.setLayoutY(54);
        logoLabel.setPrefHeight(88);
        logoLabel.setPrefWidth(89);
        logoLabel.setStyle("-fx-background-radius: 50; -fx-background-color: #fff;");
        logoLabel.setText("   P");
        logoLabel.setTextAlignment(TextAlignment.CENTER);
        logoLabel.setTextFill(Paint.valueOf("#9abec3"));
        logoLabel.setFont(new Font("System Bold",39));

        spinnerPane.getChildren().addAll(logoLabel,titleLabel,noConnectLabel,textLabel,loadingSpinner);
    }

    public void setContentToParent() {
        getLoadingController().getBasicController().getBasicView().getMainPane().getChildren().addAll(spinnerPane);
    }

    public void deleteAllElementsFromParent() {
        getLoadingController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(spinnerPane);
    }

    public LoadingController getLoadingController() {
        return loadingController;
    }

    public Label getNoConnectLabel() {
        return noConnectLabel;
    }

    public void setNoConnectLabel(Label noConnectLabel) {
        this.noConnectLabel = noConnectLabel;
    }

    @Override
    public void updateView() {
    }
}
