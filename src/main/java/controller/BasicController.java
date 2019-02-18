package controller;

import controller.AdministrationController.AdministrationController;
import controller.AminController.AdminController;
import controller.DoctorController.DoctorController;
import exceptions.IncorrectLanguage;
import pojo.GraphicPojo;
import pojo.PatientPOJO;
import pojo.VisitsPOJO;
import utils.ConfigProperties;
import utils.Language;
import utils.Validator;
import view.BasicView;
import view.Internationalization;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class BasicController {


    private BasicView basicView;
    private LoadingController loadingController;
    private LoginPanelController loginController;
    private MenuController menuController;
    private LogoutController logoutController;
    private MainController mainController;
    private HeaderController headerController;
    private AdminController adminController;
    private AdministrationController administrationController;
    private PatientPOJO selectPatient;
    private VisitsPOJO selectVisits;
    private DoctorController doctorController;
    private View currentBasicView = null;
    private String validationCommunicateToLabel = null;
    private ResourceBundle resourceBundle = null;
    private boolean ifModify;
    private GraphicPojo selectGraphic;
    private Language currentLanguage = null;
    private boolean ModifyAnnotation = false;
    private boolean delayFlagNoLogin = Boolean.FALSE;
    private ArrayList<Internationalization> internationalizationList = null;

    public BasicController() {

        try {
            initLanguageSettings();
        } catch (IncorrectLanguage e) {
            currentLanguage = Language.en;
            resourceBundle = ResourceBundle.getBundle("bundles.messages", new Locale(currentLanguage.name()));
            System.out.println(e);
        }
        internationalizationList = new ArrayList<>();
        Validator.getInstance().setBasicController(this);
        basicView = new BasicView(this);
        setLoadingController(new LoadingController(this));
        setHeaderController(new HeaderController(this));
        setMenuController(new MenuController(this));
    }

    private void initLanguageSettings() {
        try {
            currentLanguage = Language.valueOf(ConfigProperties.getInstance().getProperty("language"));
        } catch (IllegalArgumentException e) {
            throw new IncorrectLanguage("RROR OCCURRED. SET DEFAULT LANGUAGE");
        }
        resourceBundle = ResourceBundle.getBundle("bundles.messages", new Locale(currentLanguage.name()));
    }

    public LogoutController getLogoutController() {
        return logoutController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public DoctorController getDoctorController() {
        return doctorController;
    }
    public void setDoctorController(DoctorController doctorController) {
        this.doctorController = doctorController;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public AdminController getAdminController() {
        return adminController;
    }

    public AdministrationController getAdministrationController() {
        return administrationController;
    }

    public View getCurrentBasicView() {
        return currentBasicView;
    }

    public void setCurrentBasicView(View currentBasicView) {
        this.currentBasicView = currentBasicView;
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    public void setAdministrationController(AdministrationController administrationController) {
        this.administrationController = administrationController;
    }

    public BasicView getBasicView(){return basicView;}

    public void setBasicView(BasicView basicView) {
        this.basicView = basicView;
    }

    public LoadingController getLoadingController() {
        return loadingController;
    }

    public void setLoadingController(LoadingController loadingController) {
        this.loadingController = loadingController;
    }

    public LoginPanelController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginPanelController loginController) {
        this.loginController = loginController;
    }

    public HeaderController getHeaderController() {
        return headerController;
    }

    public void setHeaderController(HeaderController headerController) {
        this.headerController = headerController;
    }

    public PatientPOJO getSelectPatient() {
        return selectPatient;
    }

    public void setSelectPatient(PatientPOJO selectPatient) {
        this.selectPatient = selectPatient;
    }

    public VisitsPOJO getSelectVisits() {
        return selectVisits;
    }

    public void setSelectVisits(VisitsPOJO selectVisits) {
        this.selectVisits = selectVisits;
    }

    public GraphicPojo getSelectGraphic() {
        return selectGraphic;
    }

    public void setSelectGraphic(GraphicPojo selectGraphic) {
        this.selectGraphic = selectGraphic;
    }

    public boolean isIfModify() {
        return ifModify;
    }

    public void setIfModify(boolean ifModify) {
        this.ifModify = ifModify;
    }

    public boolean getModifyAnnotation() {
        return ModifyAnnotation;
    }

    public void setModifyAnnotation(boolean ModifyAnnotation) {
        this.ModifyAnnotation = ModifyAnnotation;
    }

    public boolean isDelayFlagNoLogin() {
        return delayFlagNoLogin;
    }

    public void setDelayFlagNoLogin(boolean delayFlagNoLogin) {
        this.delayFlagNoLogin = delayFlagNoLogin;
    }

    public String getValidationCommunicateToLabel() {
        return validationCommunicateToLabel;
    }

    public void setValidationCommunicateToLabel(String validationCommunicateToLabel) {
        this.validationCommunicateToLabel = validationCommunicateToLabel;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public Language getCurrentLanguage() {
        return currentLanguage;
    }

    public void setCurrentLanguage(Language currentLanguage) {
        this.currentLanguage = currentLanguage;
    }

    public ArrayList<Internationalization> getInternationalizationList() {
        return internationalizationList;
    }

    public void setInternationalizationList(ArrayList<Internationalization> internationalizationList) {
        this.internationalizationList = internationalizationList;
    }

    public void addToInternationalizationList(Internationalization internationalization) {
        if (!getInternationalizationList().contains(internationalization)) {
            getInternationalizationList().add(internationalization);
        }
    }

    public void updateInternationalizationView() {
        getInternationalizationList().forEach(singleResult -> {
            singleResult.updateView();
        });
    }

    public void changeLanguage() {
        if (getCurrentLanguage() == Language.en) {
            setCurrentLanguage(Language.pl);
            setResourceBundle(ResourceBundle.getBundle("bundles.messages", Locale.getDefault()));
        } else {
            setCurrentLanguage(Language.en);
            setResourceBundle(ResourceBundle.getBundle("bundles.messages", new Locale("en")));
        }
        updateInternationalizationView();
    }
}
