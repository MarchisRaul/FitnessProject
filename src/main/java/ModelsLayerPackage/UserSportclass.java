package ModelsLayerPackage;

public class UserSportclass {
    private int id_user_fk;
    private int id_sportclass_fk;

    public UserSportclass(int id_user_fk, int id_sportclass_fk) {
        this.id_user_fk = id_user_fk;
        this.id_sportclass_fk = id_sportclass_fk;
    }

    public UserSportclass() {

    }

    public int getId_user_fk() {
        return id_user_fk;
    }

    public void setId_user_fk(int id_user_fk) {
        this.id_user_fk = id_user_fk;
    }

    public int getId_sportclass_fk() {
        return id_sportclass_fk;
    }

    public void setId_sportclass_fk(int id_sportclass_fk) {
        this.id_sportclass_fk = id_sportclass_fk;
    }
}
