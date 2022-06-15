package shop.list.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.list.document.WarehouseDocument;
import shop.list.exception.BadRequestException;
import shop.list.repository.WarehouseRepository;
import shop.list.request.WarehouseRequest;
import shop.list.response.WarehouseCapacityResponse;
import shop.list.response.WarehouseResponse;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private static final String NO_ITEMS_FOUND_MESSAGE = "No items found";

    private final WarehouseRepository warehouseRepository;

    public WarehouseResponse addItemToWarehouse(WarehouseRequest warehouseRequest) {
        WarehouseDocument warehouseDocument = new WarehouseDocument();
        warehouseDocument.setName(warehouseRequest.getName());
        warehouseDocument.setPrice(warehouseRequest.getPrice());
        warehouseDocument.setAmount(warehouseRequest.getAmount());
        return new WarehouseResponse(warehouseRepository.insert(warehouseDocument));
    }

    public WarehouseResponse getItem(String id) {
        Optional<WarehouseDocument> warehouseDocumentOptional = warehouseRepository.findById(id);
        if (warehouseDocumentOptional.isPresent()) {
            return new WarehouseResponse(warehouseDocumentOptional.get());
        }
        throw new BadRequestException(NO_ITEMS_FOUND_MESSAGE);
    }

    public WarehouseResponse editItem(String id, WarehouseRequest warehouseRequest) {
        Optional<WarehouseDocument> warehouseDocumentOptional = warehouseRepository.findById(id);
        if (warehouseDocumentOptional.isPresent()) {
            WarehouseDocument warehouseDocument = warehouseDocumentOptional.get();
            warehouseDocument.setName(warehouseRequest.getName());
            warehouseDocument.setPrice(warehouseRequest.getPrice());
            warehouseDocument.setAmount(warehouseRequest.getAmount());
            return new WarehouseResponse(warehouseRepository.save(warehouseDocument));
        }
        throw new BadRequestException(NO_ITEMS_FOUND_MESSAGE);
    }

    public void deleteItem(String id) {
        Optional<WarehouseDocument> warehouseDocumentOptional = warehouseRepository.findById(id);
        warehouseDocumentOptional.ifPresent(warehouseRepository::delete);
        throw new BadRequestException(NO_ITEMS_FOUND_MESSAGE);
    }

    public WarehouseResponse getMostExpensiveItem() {
        Optional<WarehouseDocument> warehouseDocumentOptional = warehouseRepository.findTopByOrderByPriceDesc();
        if (warehouseDocumentOptional.isPresent()) {
            return new WarehouseResponse(warehouseDocumentOptional.get());
        }
        throw new BadRequestException(NO_ITEMS_FOUND_MESSAGE);
    }

    public WarehouseCapacityResponse getWarehouseCapacity() {
        List<WarehouseDocument> warehouseAmount = warehouseRepository.findAll();
        if (!warehouseAmount.isEmpty()) {
            return new WarehouseCapacityResponse(warehouseAmount.size());
        }
        throw new BadRequestException(NO_ITEMS_FOUND_MESSAGE);
    }
}
