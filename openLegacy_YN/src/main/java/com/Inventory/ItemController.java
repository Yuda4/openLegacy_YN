package com.Inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    private List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/items/{id}")
    private Item getItem(@PathVariable("id") int id) {
        return itemService.getItemById(id);
    }

    @DeleteMapping("/items/{id}")
    private void deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
    }

    @PostMapping("/items")
    private int saveItem(@RequestBody Item item) {
        itemService.saveOrUpdate(item);
        return item.getId_no();
    }
    
    @PutMapping("/withdrawal/{id}")
	public void withdrawalQuantity(@PathVariable("id") int itemId,
			@RequestBody int amount) throws Exception {
    	itemService.withdrawalAmount(itemId, amount);
	}
    
    @PutMapping("/deposit/{id}")
	public void depositQuantity(@PathVariable("id") int itemId,
			@RequestBody int amount) throws Exception {
    	itemService.depositAmount(itemId, amount);
	}
    
}