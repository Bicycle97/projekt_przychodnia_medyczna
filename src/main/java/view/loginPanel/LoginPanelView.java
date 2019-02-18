package view.loginPanel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import controller.LoginPanelController;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import view.Internationalization;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

public class LoginPanelView implements Internationalization {

    private Pane loginPane = new Pane();
    private JFXButton  loginButton= new JFXButton();
    private JFXPasswordField passwordLoginField = new JFXPasswordField();
    private Label loginLoginLabel = new Label();
    private JFXTextField emailLoginField = new JFXTextField();
    private Label wrongLoginField = new Label();
    private JFXSpinner spinerLogIn =new JFXSpinner();

    private LoginPanelController loginPanelController;

    public LoginPanelView(LoginPanelController loginPanelController) {
        this.loginPanelController = loginPanelController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){

        loginPane.setId("loginPane");
        loginPane.setPrefHeight(444);
        loginPane.setPrefWidth(500);
        loginPane.setLayoutX(42);
        loginPane.setLayoutY(14);

        loginButton.setId("loginButton");
        loginButton.setButtonType(JFXButton.ButtonType.RAISED);
        loginButton.setLayoutX(149);
        loginButton.setLayoutY(287);
        loginButton.setPrefHeight(48);
        loginButton.setPrefWidth(123);
        loginButton.setRipplerFill(WHITE);

        wrongLoginField.setId("wrongField");
        wrongLoginField.setLayoutX(145);
        wrongLoginField.setLayoutY(339);
        wrongLoginField.setPrefHeight(35);
        wrongLoginField.setPrefWidth(219);
        wrongLoginField.setStyle("-fx-text-fill: RED");
        wrongLoginField.setText("Niepoprawny Email lub hasło");
        wrongLoginField.setVisible(false);
        wrongLoginField.setFont(new Font("System Bold Italic",15));


        emailLoginField.setId("LoginField");
        emailLoginField.setFocusColor(Paint.valueOf("#da2c75"));
        emailLoginField.setLabelFloat(true);
        emailLoginField.setLayoutX(149);
        emailLoginField.setLayoutY(153);
        emailLoginField.setPrefHeight(35);
        emailLoginField.setPrefWidth(202);
        emailLoginField.setPromptText("Email");
        emailLoginField.setUnFocusColor(BLACK);
        emailLoginField.setFont(new Font("Microsoft PhagsPa Bold",13));


        passwordLoginField.setId("passwordField");
        passwordLoginField.setFocusColor(Paint.valueOf("#da2c75"));
        passwordLoginField.setLabelFloat(true);
        passwordLoginField.setLayoutX(149);
        passwordLoginField.setLayoutY(222);
        passwordLoginField.setPrefHeight(35);
        passwordLoginField.setPrefWidth(202);
        passwordLoginField.setPromptText("Hasło");
        passwordLoginField.setUnFocusColor(BLACK);
        passwordLoginField.setFont(new Font("Microsoft PhagsPa Bold",13));

        loginLoginLabel.setId("loginLoginLabel");
        loginLoginLabel.setLayoutX(69);
        loginLoginLabel.setLayoutY(54);
        loginLoginLabel.setPrefHeight(76);
        loginLoginLabel.setPrefWidth(393);
        loginLoginLabel.setWrapText(true);
        loginLoginLabel.setFont(new Font("Avenir Next LT W04 Demi",27));

        spinerLogIn.setId("spinerSpiner");
        spinerLogIn.setCache(true);
        spinerLogIn.setLayoutX(303);
        spinerLogIn.setLayoutY(287);
        spinerLogIn.setPrefHeight(48);
        spinerLogIn.setPrefWidth(37);
        spinerLogIn.setRadius(30);
        spinerLogIn.setVisible(false);

        loginPane.getChildren().addAll(loginButton,wrongLoginField,emailLoginField,passwordLoginField,loginLoginLabel,spinerLogIn);

    }
    public void setContentToParent() {
        getLoginPanelController().getBasicController().getBasicView().getMainPane().getChildren().addAll(loginPane);
    }
    public void deleteAllElementsFromParent() {
        getLoginPanelController().getBasicController().getBasicView().getMainPane().getChildren().removeAll(loginPane);
    }

    public LoginPanelController getLoginPanelController() {
        return loginPanelController;
    }

    public Label getLoginLoginLabel() {
        return loginLoginLabel;
    }

    public JFXPasswordField getPasswordLoginField() {
        return passwordLoginField;
    }

    public JFXTextField getEmailLoginField() {
        return emailLoginField;
    }

    public JFXButton getLoginButton() {
        return loginButton;
    }

    public JFXSpinner getSpinerLogIn() {
        return spinerLogIn;
    }

    public Label getWrongLoginField() {
        return wrongLoginField;
    }
    @Override
    public void updateView() {
        loginLoginLabel.setText(loginPanelController.getBasicController().getResourceBundle().getString("loginPanelView.loginLoginLabel"));
        passwordLoginField.setPromptText(loginPanelController.getBasicController().getResourceBundle().getString("loginPanelView.loginPasswordLabel"));
        loginButton.setText(loginPanelController.getBasicController().getResourceBundle().getString("loginPanelView.loginLoginButton"));
        emailLoginField.setPromptText(loginPanelController.getBasicController().getResourceBundle().getString("loginPanelView.loginEmailLabel"));
        loginPanelController.getBasicController().getHeaderController().getHeaderView().getTextField().setText(loginPanelController.getBasicController().getResourceBundle().getString("headerView.titleLabel1"));
    }
}
