package ShopFasade;


import lombok.Getter;
import org.springframework.stereotype.Controller;
import pl.sadowski.tydzien1sklep.itemRepository.Item;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {


    @Getter
    public List<Item> itemsInCard;

    CartController() {
        itemsInCard = new ArrayList<>();
    }


    public void addItem(Item item) {
        itemsInCard.add(item);
    }

}
