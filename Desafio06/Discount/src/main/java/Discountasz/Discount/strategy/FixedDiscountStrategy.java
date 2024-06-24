package Discountasz.Discount.strategy;

import org.springframework.stereotype.Component;

@Component("fixedDiscount")
public class FixedDiscountStrategy implements DiscountStrategy {

    private static final double DISCOUNT = 50.0;

    @Override
    public double applyDiscount(double amount) {
        return amount - DISCOUNT;
    }
}
