package pl.sadowski.tydzien1sklep.itemRepository;


import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    @Getter
    public List<Item>itemList;


    ItemRepository(){
        itemList = new ArrayList();
        itemList.add(new Item("Item0", new BigDecimal("50.00")));
        itemList.add(new Item("Item1", new BigDecimal("70.00")));
        itemList.add(new Item("Item2", new BigDecimal("120.00")));
        itemList.add(new Item("Item3", new BigDecimal("180.00")));
        itemList.add(new Item("Item4", new BigDecimal("190.00")));
        itemList.add(new Item("Item5", new BigDecimal("250.00")));
        itemList.add(new Item("Item6", new BigDecimal("300.00")));
    }

}
