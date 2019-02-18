package controller;

import view.MenuView;

public class MenuController {

    private BasicController basicController;
    private MenuView menuView;

    public MenuController(BasicController basicController){
        this.basicController = basicController;
        menuView = new MenuView(this);
    }
    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public MenuView getMenuView() {
        return menuView;
    }
    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }
}
