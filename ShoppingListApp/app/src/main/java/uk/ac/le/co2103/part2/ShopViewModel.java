package uk.ac.le.co2103.part2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ShopViewModel extends AndroidViewModel {

    private ShoppingListRepo repo;

    private final LiveData<List<ShoppingList>> allShoppingLists;

    private final LiveData<List<Product>> allProducts;

    public ShopViewModel (Application application) {
        super(application);
        repo = new ShoppingListRepo(application);
        allShoppingLists = repo.getAllShoppingList();
        allProducts = repo.getAllProduct();
    }

    LiveData<List<ShoppingList>> getAllShoppingItems() {
        return allShoppingLists;
    }

    LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }

    public void insert(ShoppingList shoppingList) {
        repo.insert(shoppingList);
    }

    public void insert(Product product) {
        repo.insert(product);
    }

}
