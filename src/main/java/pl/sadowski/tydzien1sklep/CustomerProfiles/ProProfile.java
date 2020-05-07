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
import java.util.List;


@Service
@Profile("PRO")
@Getter
@Setter
@ConfigurationProperties(prefix="")
public class ProProfile implements iProfile{

public float VAT;
public int DISCOUNT;

    @Override
    public void calculatePrice(List<Item> itemList) {
        BigDecimal receipt = new BigDecimal("0.0");
        for(Item it: itemList){
            receipt = receipt.add(it.getPrice());
        }
        receipt = receipt.multiply(new BigDecimal((float)(VAT +100)*(100-DISCOUNT)/10000));
        System.out.println(String.format("Wartość rzeczy w koszyku z doliczonym VAT i zniżką : %.2f", receipt.floatValue()));
    }
}
