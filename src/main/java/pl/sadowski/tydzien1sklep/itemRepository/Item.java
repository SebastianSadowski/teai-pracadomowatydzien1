package pl.sadowski.tydzien1sklep.itemRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@ToString
@Getter
@Setter
@AllArgsConstructor
public class Item {
    String name;
    BigDecimal price;

}
