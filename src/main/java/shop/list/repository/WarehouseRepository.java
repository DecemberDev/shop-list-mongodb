package shop.list.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import shop.list.document.WarehouseDocument;

import java.util.Optional;

public interface WarehouseRepository extends MongoRepository<WarehouseDocument, String> {
    Optional<WarehouseDocument> findTopByOrderByPriceDesc();
}
