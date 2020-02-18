package com.Inventory;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends CrudRepository<Item, Integer> {
	
	@Modifying
	@Query("UPDATE Item SET amount= (amount - :amount) WHERE item_no = :item_no")
	public void withdrawalAmount(@Param("item_no") int item_no, @Param("amount") int amount);
	
	@Modifying
	@Query("UPDATE Item SET amount= (amount + :amount) WHERE item_no = :item_no")
	public void depositAmount(@Param("item_no") int item_no, @Param("amount") int amount);

}