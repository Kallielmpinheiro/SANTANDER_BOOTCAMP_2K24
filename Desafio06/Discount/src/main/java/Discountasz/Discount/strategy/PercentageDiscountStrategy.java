package Discountasz.Discount.strategy;

import org.springframework.stereotype.Component;

@Component("percentageDiscount")
public class PercentageDiscountStrategy implements DiscountStrategy {

    private static final double DISCOUNT_PERCENTAGE = 0.10; //Mecha na %

    @Override
    public double applyDiscount(double amount) {
        return amount - (amount * DISCOUNT_PERCENTAGE);
    }
}
