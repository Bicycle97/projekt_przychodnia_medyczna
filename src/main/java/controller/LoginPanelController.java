package controller;

import controller.AdministrationController.AdministrationController;
import controller.AminController.AdminController;
import controller.DoctorController.DoctorController;
import javafx.concurrent.Task;
import utils.*;
import view.loginPanel.LoginPanelView;

public class LoginPanelController {

    private LoginPanelView loginPanelView;
    private BasicController basicController;
    private boolean delayFlag = Boolean.FALSE;
    private ValidationInfo validationResult = null;

    public LoginPanelController(BasicController basicController) {
        this.basicController = basicController;

        loginPanelView = new LoginPanelView(this);
        loginPanelView.updateView();
        getBasicController().getHeaderController().getHeaderView().getSkinButton().setVisible(true);
        getBasicController().getHeaderController().getHeaderView().getLanguageButton().setVisible(true);
        getBasicController().addToInternationalizationList(loginPanelView);
        setOnActionLoginButton();
//Date from api
        if (getBasicController().isDelayFlagNoLogin() == Boolean.FALSE) {
            getBasicController().getMenuController().getMenuView().getRestReadingSpinner().setVisible(true);
            getBasicController().getMenuController().getMenuView().getRestInformationPane().setVisible(true);
        Task<String> task = new Task<String>() {
            @Override
            protected String call() throws Exception {
                return ConsumingRestClient.getInstance().getCurrentData();
            }
        };

        task.setOnSucceeded(event -> {
            String consumedData = task.getValue();
            getBasicController().getMenuController().getMenuView().getRestReadingSpinner().setVisible(false);
            if (consumedData == null || consumedData.equals("")) {
                getBasicController().getMenuController().getMenuView().getRestInformationLabel().setText("Connection Problem");
            } else {
                getBasicController().getMenuController().getMenuView().getRestInformationLabel().setText(consumedData);
            }
            System.out.println("GRAB DATA: " + consumedData);
            delayFlag = Boolean.TRUE;
        });

        Task<Void> taskDelay = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(20000);
                return null;
            }
        };

        taskDelay.setOnSucceeded(event -> {
            if (delayFlag == Boolean.FALSE) {
                getBasicController().getMenuController().getMenuView().getRestReadingSpinner().setVisible(false);
                getBasicController().getMenuController().getMenuView().getRestInformationLabel().setText("Connection Problem");
                getBasicController().getMenuController().getMenuView().addRestInformationLabelToParent();
                task.cancel();
            }
        });

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

        Thread thDelay = new Thread(taskDelay);
        thDelay.setDaemon(true);
        thDelay.start();
        } else {
            setWrongLabel();
            getBasicController().setDelayFlagNoLogin(Boolean.FALSE);
        }
//End Date from api
    }

    private void setOnActionLoginButton() {
        getLoginPanelView().getLoginButton().setOnAction(event -> {
            setOnActionLoginButtonContent();
        });
    }

    private void setOnActionLoginButtonContent() {

        String login = getLoginPanelView().getEmailLoginField().getText();
        String password = getLoginPanelView().getPasswordLoginField().getText();

        getLoginPanelView().getLoginButton().setDisable(true);
        getLoginPanelView().getEmailLoginField().setDisable(true);
        getLoginPanelView().getPasswordLoginField().setDisable(true);
        getLoginPanelView().getSpinerLogIn().setVisible(true);
        Task<ValidationInfo> task1 = new Task<ValidationInfo>() {
            @Override
            protected ValidationInfo call() throws Exception {
                return Validator.getInstance().validate(login, password);
            }
        };

        task1.setOnSucceeded(event -> {
            validationResult = task1.getValue();

            if (validationResult.isValidationResult()) {
                System.out.println(validationResult.getCommunicate());
                if (User.getInstance().getCurrentUser() == UserNames.ADMIN) {
                    getLoginPanelView().deleteAllElementsFromParent();
                    getBasicController().setAdminController(new AdminController(getBasicController()));
                    getBasicController().getHeaderController().getHeaderView().getOptionLoginButton().setVisible(true);


                } else if (User.getInstance().getCurrentUser() == UserNames.EMPLOYEE){
                    getLoginPanelView().deleteAllElementsFromParent();
                    getBasicController().getHeaderController().getHeaderView().getOptionLoginButton().setVisible(true);
                    getBasicController().setAdministrationController(new AdministrationController(getBasicController()));

                }
                else if (User.getInstance().getCurrentUser() == UserNames.DOCTOR){
                    getLoginPanelView().deleteAllElementsFromParent();
                    getBasicController().getHeaderController().getHeaderView().getOptionLoginButton().setVisible(true);
                    getBasicController().setDoctorController(new DoctorController(getBasicController()));
                }
                getBasicController().setDelayFlagNoLogin(Boolean.FALSE);
            } else {
                getBasicController().setDelayFlagNoLogin(Boolean.TRUE);
            }
        });

        Task<Void> taskDelay = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(15000);
                return null;
            }
        };

        taskDelay.setOnSucceeded(event -> {
            if (getBasicController().isDelayFlagNoLogin()) {
                loginPanelView.deleteAllElementsFromParent();
                getBasicController().setValidationCommunicateToLabel(validationResult.validationCommunicateToLabel());
                getBasicController().setLoginController(new LoginPanelController(getBasicController()));
            }
        });

        Thread th = new Thread(task1);
        th.setDaemon(true);
        th.start();

        Thread thDelay = new Thread(taskDelay);
        thDelay.setDaemon(true);
        thDelay.start();

    }

    private void setWrongLabel() {
        getLoginPanelView().getSpinerLogIn().setVisible(false);
        getLoginPanelView().getWrongLoginField().setText(getBasicController().getValidationCommunicateToLabel());
        getLoginPanelView().getWrongLoginField().setVisible(true);
    }

    public LoginPanelView getLoginPanelView() {
        return loginPanelView;
    }
    public void setLoginPanelView(LoginPanelView loginView) {
        this.loginPanelView = loginView;
    }
    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

}
