package shop.list.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WarehouseRequest {

    private String name;
    private BigDecimal price;
    private int amount;
}
