package pl.sadowski.tydzien1sklep;

import ShopFasade.ShopControllerFasade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
public class ShopController {

    private ShopControllerFasade shopControllerFasade;

    @Autowired
    ShopController(ShopControllerFasade shopControllerFasade){
     this.shopControllerFasade = shopControllerFasade;
 }

 @EventListener(ApplicationReadyEvent.class)
    void addRandomItemsToCard(){
        shopControllerFasade.initializeCart(10);
 }
 }

