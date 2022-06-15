package shop.list.response;

import lombok.Getter;
import lombok.Setter;
import shop.list.document.WarehouseDocument;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class WarehouseResponse {

    private String id;
    private String name;
    private BigDecimal price;
    private int amount;
    private LocalDateTime created;
    private LocalDateTime updated;

    public WarehouseResponse(WarehouseDocument warehouseDocument) {
        this.id = warehouseDocument.getId();
        this.name = warehouseDocument.getName();
        this.price = warehouseDocument.getPrice();
        this.amount = warehouseDocument.getAmount();
        this.created = warehouseDocument.getCreated();
        this.updated = warehouseDocument.getUpdated();
    }
}
