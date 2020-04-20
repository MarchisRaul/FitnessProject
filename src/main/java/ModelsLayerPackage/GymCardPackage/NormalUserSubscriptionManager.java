package ModelsLayerPackage.GymCardPackage;

public class NormalUserSubscriptionManager implements DiscountForSubscriptionStrategy {
    @Override
    public int computeFinalPrice(int totalPrice) {
        if (totalPrice >= 500) {
            return (int) (totalPrice - 0.25 * totalPrice);
        }
        return (int) (totalPrice - 0.1 * totalPrice);
    }
}
