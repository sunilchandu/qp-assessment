package com.groceryCart.service;

import com.groceryCart.Dto.GroceryItem;
import com.groceryCart.entity.*;

import com.groceryCart.repository.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class GroceryService{

 
    @Autowired
    private GroceryRepository groceryRepository;
    
    @Autowired
    private AuthService authService;
    
    @Autowired
    private UserRepository userRepo;
    

    public String addGrocery(Grocery grocery) {
    	groceryRepository.save(grocery);
        return "grocery added";
    }
    
  public List<Grocery> getAllGroceries() {

        return groceryRepository.findAll();
    }
  
  public String addToCart(String username, GroceryItem grocery) {
	 
	  User user=authService.getUserByUsername(username);
	  
	  Grocery groceryItem = groceryRepository.findByitemName(grocery.getGroceryItemname()).get();
	  
	  Set<Grocery> groceries = user.getGroceries();
	  
	  groceries.add(groceryItem);
	  
	  user.setGroceries(groceries);
	  
	  userRepo.save(user);
	  
	  
	  
	  
	  
	  return "added to cart";
  }
  
  public String deleteItem(long id) {
	  groceryRepository.deleteById(id);
	  
	  return "deleted succesfully";
  }
    
   
}
