package pl.sadowski.tydzien1sklep.CustomerProfiles;

import pl.sadowski.tydzien1sklep.itemRepository.Item;

import java.util.List;

public interface iProfile {

    void calculatePrice(List<Item> itemList);
}
