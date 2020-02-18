package com.Inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<Item>();
        itemRepository.findAll().forEach(item -> items.add(item));
        return items;
    }
    
    public Item getItemById(int id) {
        return itemRepository.findById(id).get();
    }

    public void saveOrUpdate(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
    
	public void withdrawalAmount(int item_no, int amount) throws Exception {
		Item item = itemRepository.findById(item_no).get();
		if (item.getAmount() - amount >= 0) {
			itemRepository.withdrawalAmount(item_no, amount);
		} else {
			throw new Exception("Item amount is less than withdrawal amount.");
		}
	}
	
	public void depositAmount(int itemId, int amount) throws Exception {
		if (amount > 0) {
			itemRepository.depositAmount(itemId, amount);
		} else {
			throw new Exception("Can't deposit a zero or negative amount.");
		}
	}
    
    
}