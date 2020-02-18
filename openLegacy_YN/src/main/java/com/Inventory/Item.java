package com.Inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items2")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_no")
    private int item_no;
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
    @Column(name = "amount")
    private int amount;
    
    @Column(name = "inventory_code", unique = true)
    private String inventory_code;
    
	
	public int getId_no() {
		return item_no;
	}
	public void setId_no(int id) {
		this.item_no = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amnt) {
		this.amount = amnt;
	}
	public String getInventory_code() {
		return inventory_code;
	}
	public void setInventory_code(String inve_code) {
		this.inventory_code = inve_code;
	}

	@Override
	public String toString() {
		return "Item [id=" + item_no + ", name=" + name + ", amount=" + amount + ", inventory_code=" + inventory_code + "]";
	}

}