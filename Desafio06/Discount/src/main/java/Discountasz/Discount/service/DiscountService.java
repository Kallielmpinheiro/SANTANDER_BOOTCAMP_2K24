package Discountasz.Discount.service;


import Discountasz.Discount.strategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    private ApplicationContext applicationContext;

    public double applyDiscount(String strategyName, double amount) {
        DiscountStrategy strategy = (DiscountStrategy) applicationContext.getBean(strategyName);
        return strategy.applyDiscount(amount);
    }
}
