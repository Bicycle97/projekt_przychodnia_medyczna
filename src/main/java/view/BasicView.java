package view;

import controller.BasicController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class BasicView {

   private AnchorPane rootAnchorPane = new AnchorPane();
   private Pane headerPane = new Pane();
   private Pane mainPane = new Pane();
   private Pane menuPane = new Pane();
   private ImageView photo = new ImageView();

   private BasicController basicController = null;

    public BasicView(BasicController basicController) {
        this.basicController = basicController;
        setSettingsHeaderPane();
        setSettingsMainPane();
        setSettingsMenuPane();
        setSettingsRootAnchorPane();
        setPhoto();

    }

    public void setSettingsRootAnchorPane() {
        rootAnchorPane.setId("rootAnchorPane");
        rootAnchorPane.setPrefHeight(533);
        rootAnchorPane.setPrefWidth(800);
        rootAnchorPane.setLayoutX(0);
        rootAnchorPane.setLayoutY(0);
        rootAnchorPane.getChildren().addAll(photo,headerPane, mainPane, menuPane);
    }

    private void setSettingsHeaderPane() {
        headerPane.setId("headerPane");
        headerPane.setPrefHeight(50);
        headerPane.setPrefWidth(800);
        headerPane.setLayoutX(0);
        headerPane.setLayoutY(0);
    }

    public void setSettingsMainPane() {
        mainPane.setId("mainPane");
        mainPane.setPrefHeight(483);
        mainPane.setPrefWidth(582);
        mainPane.setLayoutX(0);
        mainPane.setLayoutY(50);
    }

    public void setSettingsMenuPane() {
        menuPane.setId("menuPane");
        menuPane.setPrefHeight(345);
        menuPane.setPrefWidth(219);
        menuPane.setLayoutX(578);
        menuPane.setLayoutY(50);
    }

    public void setPhoto(){
        photo.setId("photo");
        photo.setFitHeight(483);
        photo.setFitWidth(800);
        photo.setLayoutX(0);
        photo.setLayoutY(50);
        photo.setPickOnBounds(true);
        Image image =new Image("@../../images/log1.jpg");
        photo.setImage(image);
    }

    public AnchorPane getRootAnchorPane() { return rootAnchorPane; }
    public void setRootAnchorPane(AnchorPane rootAnchorPane) { this.rootAnchorPane = rootAnchorPane; }

    public Pane getHeaderPane() { return headerPane; }
    public void setHeaderPane(Pane headerPane) { this.headerPane = headerPane; }

    public Pane getMainPane() { return mainPane; }
    public void setMainPane(Pane mainPane) { this.mainPane = mainPane; }

    public Pane getMenuPane() { return menuPane; }
    public void setMenuPane(Pane menuPane) { this.menuPane = menuPane; }

    public BasicController getBasicController() { return basicController; }
    public void setBasicController(BasicController basicController) { this.basicController = basicController; }

}
