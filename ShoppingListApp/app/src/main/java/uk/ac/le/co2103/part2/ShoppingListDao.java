package uk.ac.le.co2103.part2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShoppingListDao {

    @Insert
    void insert(ShoppingList shoppingList);

    @Update
    void update(ShoppingList shoppingList);

    @Query("SELECT * FROM shopping_lists ORDER BY name ASC")
    LiveData<List<ShoppingList>> getShoppingList();

    @Query("DELETE FROM shopping_lists WHERE listId = :listId")
    void deleteShoppingListById(int listId);

    @Query("DELETE FROM shopping_lists")
    void deleteAllShoppingLists();

}
