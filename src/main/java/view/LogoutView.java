package view;

import com.jfoenix.controls.JFXSpinner;
import controller.LogoutController;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class LogoutView implements Internationalization {

    private Pane logoutPane = new Pane();
    private Label titleTextLogout= new Label();
    private Label waitLogout = new Label();
    private JFXSpinner spinnerLogout = new JFXSpinner();

    private LogoutController logoutController;

    public LogoutView(LogoutController logoutController) {
        this.logoutController = logoutController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){

        logoutPane.setId("logoutPane");
        logoutPane.setPrefHeight(444);
        logoutPane.setPrefWidth(500);
        logoutPane.setLayoutX(29);
        logoutPane.setLayoutY(14);

        titleTextLogout.setId("titleTextLogout");
        titleTextLogout.setLayoutX(114);
        titleTextLogout.setLayoutY(93);
        titleTextLogout.setPrefHeight(50);
        titleTextLogout.setPrefWidth(272);
        titleTextLogout.setFont(new Font("Bauhaus 93",22));


        waitLogout.setId("waitLogout");
        waitLogout.setLayoutX(180);
        waitLogout.setLayoutY(305);
        waitLogout.setFont(new Font("System Bold Italic",15));

        spinnerLogout.setId("spinnerLogout");
        spinnerLogout.setCache(true);
        spinnerLogout.setLayoutX(202);
        spinnerLogout.setLayoutY(194);
        spinnerLogout.setPrefHeight(86);
        spinnerLogout.setPrefWidth(89);
        spinnerLogout.setRadius(30);

        logoutPane.getChildren().addAll(spinnerLogout, waitLogout, titleTextLogout);

    }

    public void setContentToParent() {
        getLogoutController().getBasicController().getBasicView().getMainPane().getChildren().addAll(logoutPane);
    }

    public void deleteAllElementsFromParent() {
        getLogoutController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(logoutPane);
    }

    public LogoutController getLogoutController() {
        return logoutController;
    }

    @Override
    public void updateView() {
        titleTextLogout.setText(logoutController.getBasicController().getResourceBundle().getString("logoutView.titleTextLogout"));
        waitLogout.setText(logoutController.getBasicController().getResourceBundle().getString("logoutView.waitLogout"));
    }
}
