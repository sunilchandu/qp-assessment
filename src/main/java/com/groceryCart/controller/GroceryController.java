package com.groceryCart.controller;


import com.groceryCart.Dto.GroceryItem;
import com.groceryCart.entity.*;
import com.groceryCart.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class GroceryController {
    
	@Autowired
    private GroceryService groceryService;
	
  

   
 // Build Update Category REST API
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping(value = {"/getallusers"})
//    public ResponseEntity<List<User>> getallUSers() throws Exception{
//    	List<User> allusers= authService.getallusers(); 
//        return ResponseEntity.ok(allusers);
//    }
    

	
	
    @PostMapping(value = {"/addtocart"})
    public ResponseEntity<String> addItemtoCart(@RequestBody GroceryItem grocery) throws Exception{
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth!=null) {
    		User userObj = (User) auth.getPrincipal();
    		
    		String username=userObj.getUsername();
    		
    		 String response = groceryService.addToCart(username,grocery);
    		
    		
    		return new ResponseEntity<>(response, HttpStatus.CREATED);
    	}
    	
    	return null;
    	
    	
    	
    }
    
    // Build Register REST API
	@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = {"/additem"})
    public ResponseEntity<String> addItem(@RequestBody Grocery grocery) throws Exception{
        String response = groceryService.addGrocery(grocery);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    // Build Update Category REST API
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = {"/getallitems"})
    public ResponseEntity<List<Grocery>> getallItems() throws Exception{
    	List<Grocery> allItems=groceryService.getAllGroceries();
        return ResponseEntity.ok(allItems);
    }
    
    
}