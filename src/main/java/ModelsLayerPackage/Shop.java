package ModelsLayerPackage;

public class Shop {
    private int id_shop;
    private int discount_mode;

    public Shop(int id_shop, int discount_mode) {
        this.id_shop = id_shop;
        this.discount_mode = discount_mode;
    }

    public Shop() {

    }

    public int getId_shop() {
        return id_shop;
    }

    public void setId_shop(int id_shop) {
        this.id_shop = id_shop;
    }

    public int getDiscount_mode() {
        return discount_mode;
    }

    public void setDiscount_mode(int discount_mode) {
        this.discount_mode = discount_mode;
    }
}
