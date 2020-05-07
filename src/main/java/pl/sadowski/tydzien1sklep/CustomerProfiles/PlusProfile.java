package pl.sadowski.tydzien1sklep.CustomerProfiles;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.sadowski.tydzien1sklep.itemRepository.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Profile("PLUS")

public class PlusProfile implements iProfile{

    @Value("${plus.VAT}")
float VAT;

    @Override
    public void calculatePrice(List<Item> itemList) {
BigDecimal receipt = new BigDecimal("0.0");

        for(Item it: itemList){
            receipt = receipt.add(it.getPrice());
        }
        receipt = receipt.multiply(new BigDecimal(((100+VAT)/100)));
        System.out.println(String.format("Wartość rzeczy w koszyku z doliczonym VAT : %.2f", receipt.floatValue()));
    }
}
