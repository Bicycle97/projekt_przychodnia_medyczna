package view;

import com.jfoenix.controls.JFXButton;
import controller.HeaderController;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import utils.SkinChanger;

public class HeaderView implements Internationalization {

    private JFXButton skinButton = new JFXButton();
    private JFXButton languageButton = new JFXButton();
    private JFXButton  closeButton= new JFXButton();
    private JFXButton optionLoginButton = new JFXButton();
    private Label textField = new Label();

    private HeaderController headerController;

    public HeaderView(HeaderController headerController) {
        this.headerController = headerController;
        setSettingsContent();
        setContentToParent();
    }

    private void setSettingsContent(){
        skinButton.setId("skinButton");
        skinButton.setLayoutX(68);
        skinButton.setLayoutY(10);
        skinButton.setPrefHeight(37);
        skinButton.setPrefWidth(114);
        skinButtonSetText();
        skinButton.setFont(new Font("Microsoft Tai Le Bold", 18));
        skinButton.setVisible(false);

        languageButton.setId("languageButton");
    languageButton.setLayoutX(4);
    languageButton.setLayoutY(10);
    languageButton.setPrefHeight(37);
    languageButton.setPrefWidth(49);
    languageButton.setFont(new Font("Microsoft Tai Le Bold",18));
    languageButton.setVisible(false);

        closeButton.setId("closeButton");
    closeButton.setLayoutX(198);
    closeButton.setLayoutY(10);
    closeButton.setPrefHeight(37);
    closeButton.setPrefWidth(103);
    closeButton.setFont(new Font("Microsoft Tai Le Bold",18));

        optionLoginButton.setId("optionLoginButton");
    optionLoginButton.setLayoutX(704);
    optionLoginButton.setLayoutY(7);
    optionLoginButton.setPrefHeight(37);
    optionLoginButton.setPrefWidth(82);
    Image image =new Image("@../../images/lista.png");
    optionLoginButton.setGraphic(new ImageView(image));
    optionLoginButton.setVisible(false);

    textField.setId("textField");
    textField.setLayoutX(384);
    textField.setPrefHeight(31);
    textField.setPrefWidth(381);
    textField.setLayoutX(346);
    textField.setLayoutY(10);
    textField.setAlignment(Pos.TOP_CENTER);
    textField.setFont(new Font("Avenir Next LT W04 Demi Italic",15));
    textField.setText("Witaj trwa łączenie z bazą ");
}

    public void skinButtonSetText() {
        if (SkinChanger.getInstance().getCurrentStyle().equals("style1")) {
            skinButton.setText(getHeaderController().getBasicController().getResourceBundle().getString("headerView.skinButton1"));
        } else if (SkinChanger.getInstance().getCurrentStyle().equals("style2")) {
            skinButton.setText(getHeaderController().getBasicController().getResourceBundle().getString("headerView.skinButton2"));
        } else {
            skinButton.setText(getHeaderController().getBasicController().getResourceBundle().getString("headerView.skinButton3"));
        }
    }

    public void setContentToParent() {
        getHeaderController().getBasicController().getBasicView().getHeaderPane().getChildren().addAll(textField, skinButton, languageButton, optionLoginButton, closeButton);
    }

    public void deleteAllElementsFromParent() {
        getHeaderController().getBasicController().getBasicView().getHeaderPane().getChildren().removeAll(textField, skinButton, languageButton, optionLoginButton, closeButton);
    }

    public JFXButton getCloseButton() {
        return closeButton;
    }

    public JFXButton getLanguageButton() { return languageButton; }
    public void setLanguageButton(JFXButton languageButton) { this.languageButton = languageButton; }

    public JFXButton getSkinButton() {
        return skinButton;
    }
    public void setSkinButton(JFXButton skinButton) {
        this.skinButton = skinButton;
    }

    public void setTextField(Label textField) { this.textField = textField; }
    public Label getTextField() {return textField; }

    public HeaderController getHeaderController() {
        return headerController;
    }
    public void setHeaderController(HeaderController headerController) {
        this.headerController = headerController;
    }

    public JFXButton getOptionLoginButton() {
        return optionLoginButton;
    }

    public void setOptionLoginButton(JFXButton optionLoginButton) {
        this.optionLoginButton = optionLoginButton;
    }

    @Override
    public void updateView() {
        languageButton.setText(headerController.getBasicController().getResourceBundle().getString("headerView.languageButton"));
        closeButton.setText(headerController.getBasicController().getResourceBundle().getString("headerView.closeButton"));
        textField.setText(headerController.getBasicController().getResourceBundle().getString("headerView.titleLabel"));
        skinButtonSetText();
    }
}
