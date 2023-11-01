package com.sewing.unnamedWorkshop;

import com.sewing.unnamedWorkshop.entity.order.DeliveryService;
import com.sewing.unnamedWorkshop.entity.user.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    // Інші методи контролера
    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserEntity user, @RequestParam("deliveryService") DeliveryService deliveryService) {
        user.setDeliveryService(deliveryService);
        // Додаткова логіка збереження користувача
        return "redirect:/login";
    }
}
