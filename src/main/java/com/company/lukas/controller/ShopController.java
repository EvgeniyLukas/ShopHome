package company.lukas.controller;


import company.lukas.service.ShopStoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {


    @Autowired
    ShopStoreServiceImpl shopStoreService;
}
