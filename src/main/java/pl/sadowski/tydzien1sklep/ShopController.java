package pl.sadowski.tydzien1sklep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import pl.sadowski.tydzien1sklep.CartController;
import pl.sadowski.tydzien1sklep.CustomerProfiles.iProfile;
import pl.sadowski.tydzien1sklep.itemRepository.ItemRepository;

@Controller
public class ShopController {

    int[] numberOfProduct = {1, 2, 3, 4, 5};
    ItemRepository storage;
    iProfile profile;
    CartController cartController;

    @Autowired
    ShopController(iProfile profile, CartController cartController, ItemRepository storage) {
        this.profile = profile;
        this.cartController = cartController;
        this.storage = storage;
    }

    @EventListener(ApplicationReadyEvent.class)
    void initializeCart() {
        for (int number : numberOfProduct) {
            cartController.addItem(storage.itemList.get(number));

        }
        cartController.itemsInCard.forEach( item -> System.out.println(item.toString()));
        profile.calculatePrice(cartController.itemsInCard);
    }


}
