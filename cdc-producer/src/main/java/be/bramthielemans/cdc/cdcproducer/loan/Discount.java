package be.bramthielemans.cdc.cdcproducer.loan;

public class Discount {

    public String condition;
    public double discountedPercentage;

    private Discount() {
    }

    private Discount(String condition, double discountedPercentage) {
        this.condition = condition;
        this.discountedPercentage = discountedPercentage;
    }

    public static Discount legalInsurance() {
        return new Discount("LEGAL_INSURANCE", 0.15);
    };

    public static Discount carInsurance() {
        return new Discount("CAR_INSURANCE", 0.10);
    };
}
