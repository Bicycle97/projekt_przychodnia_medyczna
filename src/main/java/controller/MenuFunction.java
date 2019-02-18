package controller;

import javafx.concurrent.Task;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.User;
import utils.UserNames;

public class MenuFunction {
    LoginPanelController loginPanelController;

    public void setOnActionLogoutButtonContent(BasicController basicController) {


        if(User.getInstance().getCurrentUser() == UserNames.ADMIN) {
            basicController.getAdminController().getAdminView().deleteAllElementsFromParent();
        }
        else if(User.getInstance().getCurrentUser() == UserNames.EMPLOYEE){
            basicController.getAdministrationController().getAdministrationView().deleteAllElementsFromParent();
        }
        else {
            basicController.getDoctorController().getDoctorView().deleteAllElementsFromParent();
        }
        basicController.getMenuController().getMenuView().getMenuButton1().setDisable(false);
        basicController.getMenuController().getMenuView().getMenuButton2().setDisable(false);
        basicController.getMenuController().getMenuView().getMenuButton3().setDisable(false);
        basicController.setLogoutController(new LogoutController(basicController));

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(5000);
                return null;
            }
        };

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

        task.setOnSucceeded(event -> {
            basicController.getLogoutController().getLogoutView().deleteAllElementsFromParent();
            basicController.getMenuController().getMenuView().getMainMainPane().setVisible(false);
            Image image =new Image("@../../images/lista.png");
            basicController.getHeaderController().getHeaderView().getOptionLoginButton().setGraphic(new ImageView(image));
            basicController.getHeaderController().getHeaderView().getOptionLoginButton().setVisible(false);
            loginPanelController = new LoginPanelController(basicController);
            basicController.getHeaderController().setShowMenu(false);
        });
    }
}
