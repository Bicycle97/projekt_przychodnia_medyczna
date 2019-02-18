package main;

import controller.BasicController;
import controller.LoginPanelController;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.MyEntityManagerFactory;
import utils.SkinChanger;

public class Main extends Application {
        private static Scene scene;

    private static void startThread(Task task) {
        Thread th1 = new Thread(task);
        th1.setDaemon(true);
        th1.start();
    }

    public static void main(String[] args) {
        Application.launch(args);
        MyEntityManagerFactory.getInstance().getEmFactory().close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Task<Void> task2 = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                SkinChanger.getInstance().configCurrentStyle();
                return null;
            }
        };

        Thread th2 = new Thread(task2);
        th2.setDaemon(true);
        th2.start();

        BasicController basicController = new BasicController();

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                MyEntityManagerFactory.getInstance();
                return null;
            }
        };

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

        task.setOnSucceeded(event -> {
            basicController.setLoginController(new LoginPanelController(basicController));
            basicController.getLoadingController().getLoadingView().deleteAllElementsFromParent();
        });

        Task<Void> taskDelay = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(15000);
                return null;
            }
        };

        taskDelay.setOnSucceeded(event -> {
            basicController.getLoadingController().getLoadingView().getNoConnectLabel().setVisible(true);
        });

        Scene scene = new Scene(basicController.getBasicView().getRootAnchorPane());
        Task<Void> task1 = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                SkinChanger.getInstance().setScene(scene);
                return null;
            }
        };

        startThread(task1);
        startThread(taskDelay);

        primaryStage.setTitle("Przychodnia");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
