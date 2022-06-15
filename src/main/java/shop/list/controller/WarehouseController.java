package shop.list.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.list.request.WarehouseRequest;
import shop.list.response.WarehouseCapacityResponse;
import shop.list.response.WarehouseResponse;
import shop.list.service.WarehouseService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping("/item/add")
    public ResponseEntity<WarehouseResponse> addItemToWarehouse(@RequestBody WarehouseRequest warehouseRequest) {
        return ResponseEntity.ok(warehouseService.addItemToWarehouse(warehouseRequest));
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<WarehouseResponse> getItem(@PathVariable String id) {
        return ResponseEntity.ok(warehouseService.getItem(id));
    }

    @PutMapping("/item/{id}/edit")
    public ResponseEntity<WarehouseResponse> editItem(
            @PathVariable String id, @RequestBody WarehouseRequest warehouseRequest) {
        return ResponseEntity.ok(warehouseService.editItem(id, warehouseRequest));
    }

    @DeleteMapping("/item/{id}/delete")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        warehouseService.deleteItem(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/item/top-by-price")
    public ResponseEntity<WarehouseResponse> getMostExpensiveItem() {
        return ResponseEntity.ok(warehouseService.getMostExpensiveItem());
    }

    @GetMapping("/capacity")
    public ResponseEntity<WarehouseCapacityResponse> getWarehouseCapacity() {
        return ResponseEntity.ok(warehouseService.getWarehouseCapacity());
    }
}
