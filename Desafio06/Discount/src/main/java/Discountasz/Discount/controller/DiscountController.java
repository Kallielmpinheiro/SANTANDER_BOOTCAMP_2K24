package Discountasz.Discount.controller;

import Discountasz.Discount.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/apply")
    public double applyDiscount(@RequestParam String strategy, @RequestParam double amount) {
        return discountService.applyDiscount(strategy, amount);
    }
}
