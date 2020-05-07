package ShopFasade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pl.sadowski.tydzien1sklep.CustomerProfiles.iProfile;
import pl.sadowski.tydzien1sklep.itemRepository.ItemRepository;

import java.util.Arrays;
import java.util.Random;

@Controller
public class ShopControllerFasade {

    ItemRepository storage;
    iProfile profile;
    CartController cartController;

    @Autowired
    public ShopControllerFasade(iProfile profile, CartController cartController, ItemRepository storage) {
        this.profile = profile;
        this.cartController = cartController;
        this.storage = storage;
    }
@EventListener(ApplicationReadyEvent.class)
    public void initializeCart(int quiantityOfItemsInCard) {

        Integer[] numbers = new Integer[quiantityOfItemsInCard];
        Arrays.stream(numbers).forEach(n -> {
            n = new Random().nextInt(storage.itemList.size());
            cartController.addItem(storage.itemList.get(n));
            System.out.println("DUPA DUPA DUPA");
        });
        cartController.itemsInCard.forEach( item -> System.out.println(item.toString()));
        profile.calculatePrice(cartController.itemsInCard);
    }


}
