package pl.sadowski.tydzien1sklep;

import pl.sadowski.tydzien1sklep.ShopFasade.ShopControllerFasade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
public class ShopController {

    public ShopControllerFasade shopControllerFasade;

    @Autowired
    public ShopController(ShopControllerFasade shopControllerFasade){
        this.shopControllerFasade = shopControllerFasade;
    }

    @EventListener(ApplicationReadyEvent.class)
    void addItemsToCard(){
        shopControllerFasade.initializeCart(10);
    }
}
