package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.SkinChanger;
import view.HeaderView;

public class HeaderController {

    private BasicController basicController;
    private HeaderView headerView;
    public boolean showMenu = false;


    public HeaderController(BasicController basicController){
        this.basicController = basicController;
        headerView = new HeaderView(this);
        showMenu = false;
        headerView.updateView();
        getBasicController().addToInternationalizationList(headerView);
        setOnActionOptionButton();
        setOnActionEndButton();
        setOnActionLanguageButton();
        setOnActionSkinButton();

    }
    private void setOnActionOptionButton() {

        getHeaderView().getOptionLoginButton().setOnAction(event-> {
            if(showMenu == false ) {
                Image image =new Image("@../../images/strzałka.png");
                getBasicController().getHeaderController().getHeaderView().getOptionLoginButton().setGraphic(new ImageView(image));
                getBasicController().getMenuController().getMenuView().getMainMainPane().setVisible(true);
                showMenu = true;
            }else{
                Image image =new Image("@../../images/lista.png");
                getBasicController().getHeaderController().getHeaderView().getOptionLoginButton().setGraphic(new ImageView(image));
                getBasicController().getMenuController().getMenuView().getMainMainPane().setVisible(false);
                getBasicController().getMenuController().getMenuView().getMainMainPane().setVisible(false);
                showMenu = false;
            }
        });
    }

    private void setOnActionEndButton() {
        getHeaderView().getCloseButton().setOnAction(event -> {
            System.exit(0);
        });
    }

    private void setOnActionLanguageButton() {
        getHeaderView().getLanguageButton().setOnAction(event -> {
            setOnActionLanguageButtonContent();
        });
    }

    private void setOnActionLanguageButtonContent() {
        System.out.println("LANGUAGE CHANGE");
        getBasicController().changeLanguage();
    }

    private void setOnActionSkinButton() {
        getHeaderView().getSkinButton().setOnAction(event -> {
            setOnActionSkinButtonContent();
        });
    }

    private void setOnActionSkinButtonContent() {
        SkinChanger.getInstance().changeStyle();
        getHeaderView().skinButtonSetText();
    }

    public BasicController getBasicController() {
        return basicController;
    }
    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public HeaderView getHeaderView() {
        return headerView;
    }
    public void setHeaderView(HeaderView headerView) {
        this.headerView = headerView;
    }

    public boolean isShowMenu() {
        return showMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }


}
