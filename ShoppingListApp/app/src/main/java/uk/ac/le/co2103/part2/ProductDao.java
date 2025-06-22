package uk.ac.le.co2103.part2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAllProduct();

    @Query("SELECT * FROM product WHERE shoppingListId = :shoppingListId")
    LiveData<List<Product>> getProductById(int shoppingListId);

    @Query("DELETE FROM product WHERE id = :ID")
    void deleteProductById(int ID);

    @Query("DELETE FROM product")
    void deleteAllProducts();

}
