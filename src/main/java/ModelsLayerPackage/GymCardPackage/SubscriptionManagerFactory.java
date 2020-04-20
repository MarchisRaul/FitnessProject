package ModelsLayerPackage.GymCardPackage;

public class SubscriptionManagerFactory {
    public DiscountForSubscriptionStrategy getSubscriptionManager(String card_type) {
        DiscountForSubscriptionStrategy subscriptionManager = null;
        switch (card_type) {
            case "normal-card" :
                subscriptionManager = new NormalUserSubscriptionManager();
                break;
            case "7card" :
                subscriptionManager = new NormalUserSubscriptionManager();
                break;
            case "power-card" :
                subscriptionManager = new PowerUserSubscriptionManager();
                break;
            default :
                System.out.println("Card type provided does not exist!");
                break;
        }
        return subscriptionManager;
    }
}
