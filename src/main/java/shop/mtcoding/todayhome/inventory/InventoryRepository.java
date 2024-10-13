package shop.mtcoding.todayhome.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.todayhome.maincategory.MainCategory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
