package controller;


import view.loginPanel.LoadingView;

public class LoadingController {

    private LoadingView loadingView;
    private BasicController basicController;


    public LoadingController(BasicController basicController){
        this.basicController = basicController;
        loadingView = new LoadingView(this);
    }

    public LoadingView getLoadingView() {
        return loadingView;
    }
    public BasicController getBasicController() {
        return basicController;
    }
}
