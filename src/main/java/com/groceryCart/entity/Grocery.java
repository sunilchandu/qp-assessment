package com.groceryCart.entity;



import jakarta.persistence.*;



@Entity
@Table(name = "Grocery_items")
public class Grocery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    
    @Column(nullable = false)
    private String itemName;
    
    @Column(nullable = false)
    private String itemPrice;
    
    @Column(nullable = false)
    private String itemQuantity;
    
   

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
    
    
  
  


    


}
