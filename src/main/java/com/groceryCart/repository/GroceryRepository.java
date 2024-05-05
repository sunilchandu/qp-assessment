package com.groceryCart.repository;

import com.groceryCart.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroceryRepository extends JpaRepository<Grocery, Long> {
	
	Optional<Grocery> findByitemName(String Itemname);
    
}
