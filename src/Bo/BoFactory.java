package Bo;

import Bo.Custom.impl.*;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {

    }

    public static BoFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO> T getBO(BoTypes boType) {
        switch (boType) {
            case CAR:
                return (T) new CarBoimpl();
            case MODEL:
                return (T) new CarModelBoimpl();
            case OWNER:
                return (T) new OwnerBoimpl();
            case SALE:
                return (T) new SaleBoimpl();
            case CUSTOMER:
                return (T) new CustomerBoimpl();
            default:
                return null;
        }
    }
}
