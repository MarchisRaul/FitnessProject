package ModelsLayerPackage.GymCardPackage;

public class PowerUserSubscriptionManager implements DiscountForSubscriptionStrategy {
    @Override
    public int computeFinalPrice(int totalPrice) {
        return (int) (totalPrice - (int)0.3 * totalPrice);
    }
}
