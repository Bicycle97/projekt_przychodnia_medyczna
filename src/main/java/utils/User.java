package utils;

public class User {
    private UserNames currentUser = UserNames.NONE;
    private static User ourInstance = new User();
    private Long id_user;
    private String Name_user;
    private String Surname_user;

    public static User getInstance() {
        return ourInstance;
    }

    private User() {
    }

    public UserNames getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(UserNames currentUser) {
        this.currentUser = currentUser;
    }

    public Long getId_user() {
        return id_user;
    }
    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName_user() {
        return Name_user;
    }
    public void setName_user(String name_user) {
        Name_user = name_user;
    }

    public String getSurname_user() {
        return Surname_user;
    }
    public void setSurname_user(String surname_user) {
        Surname_user = surname_user;
    }
}
