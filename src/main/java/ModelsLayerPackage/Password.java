package ModelsLayerPackage;

public class Password {
    private int id_user;
    private String name;    // e-mail
    private String password;

    public Password(int id_user, String name, String password) {
        this.id_user = id_user;
        this.name = name;
        this.password = password;
    }

    public Password() {

    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
