package controller;

import view.LogoutView;

public class LogoutController {

    private BasicController basicController;
    private LogoutView logoutView;

    public LogoutController(BasicController basicController){
        this.basicController = basicController;
        logoutView = new LogoutView(this);
        logoutView.updateView();
        getBasicController().addToInternationalizationList(logoutView);
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public LogoutView getLogoutView() {
        return logoutView;
    }
    public void setLogoutView(LogoutView logoutView) {
        this.logoutView = logoutView;
    }
}
