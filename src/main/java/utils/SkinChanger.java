package utils;

import exceptions.IncorrectSkinName;
import javafx.scene.Scene;

public class SkinChanger {

    Scene scene;
    String currentStyle;

    private SkinChanger() {
    }

    public static SkinChanger getInstance() {
        return SingletonHolder.INSTANCE;
    }
    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        configCurrentStyle();
        setStyle();
    }

    public void configCurrentStyle() {
        String name = ConfigProperties.getInstance().getProperty("cssStyle");
        if (ConfigProperties.getInstance().getProperty("cssStyle").equals("style1")) currentStyle = "style1";
        else if (ConfigProperties.getInstance().getProperty("cssStyle").equals("style2")) currentStyle = "style2";
        else if (ConfigProperties.getInstance().getProperty("cssStyle").equals("style3")) currentStyle = "style3";
        else {
            currentStyle = "style1";
            setStyle();
            throw new IncorrectSkinName("Incorrect skin name in config.properties file. I set default skin. Please rename file.");
        }
    }

    public void changeStyle() {
        if (currentStyle.equals("style1")) currentStyle = "style2";
        else if (currentStyle.equals("style2")) currentStyle = "style3";
        else if (currentStyle.equals("style3")) currentStyle = "style1";
        setStyle();
    }

    private void setStyle() {
        scene.getStylesheets().clear();
        scene.getStylesheets().add("/css/" + currentStyle + ".css");
    }

    public String getCurrentStyle() {
        return currentStyle;
    }
    public void setCurrentStyle(String currentStyle) {
        this.currentStyle = currentStyle;
    }

    private static class SingletonHolder {
        private static final SkinChanger INSTANCE = new SkinChanger();
    }
}
