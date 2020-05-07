package pl.sadowski.tydzien1sklep.CustomerProfiles;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.sadowski.tydzien1sklep.itemRepository.Item;

import java.math.BigDecimal;
import java.util.List;


@Service
@Profile("START")
public class StartProfile implements iProfile{
    @Override
    public void calculatePrice(List<Item> itemList) {
        BigDecimal receipt = new BigDecimal("0");
        for(Item item: itemList){
            receipt = receipt.add(item.getPrice());
        }
        System.out.println(String.format("Wartość rzeczy w koszyku : %.2f ", receipt.floatValue()));
    }
}
