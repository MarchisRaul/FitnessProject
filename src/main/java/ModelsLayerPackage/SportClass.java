package ModelsLayerPackage;

public class SportClass {
    private int id_class;
    private String name;
    private int id_trainer_fk;
    private int month_price;
    private int size_number;

    public SportClass(int id_class, String name, int id_trainer_fk, int month_price, int size_number) {
        this.id_class = id_class;
        this.name = name;
        this.id_trainer_fk = id_trainer_fk;
        this.month_price = month_price;
        this.size_number = size_number;
    }

    public SportClass() {

    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_trainer_fk() {
        return id_trainer_fk;
    }

    public void setId_trainer_fk(int id_trainer_fk) {
        this.id_trainer_fk = id_trainer_fk;
    }

    public int getMonth_price() {
        return month_price;
    }

    public void setMonth_price(int month_price) {
        this.month_price = month_price;
    }

    public int getSize_number() {
        return size_number;
    }

    public void setSize_number(int size_number) {
        this.size_number = size_number;
    }

    public void incrementSizeNumber() {
        size_number += 1;
    }
}
