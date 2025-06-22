package uk.ac.le.co2103.part2;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ShoppingListRepo {

    private ShoppingListDao shoppingListDao;

    private ProductDao productDao;
    private LiveData<List<ShoppingList>> allShoppingList;

    private LiveData<List<Product>> allProducts;


    // shopping list and product repository
    ShoppingListRepo(Application application) {
        Shoppingdb db = Shoppingdb.getDatabase(application);
        shoppingListDao = db.shoppingListDao();
        allShoppingList = shoppingListDao.getShoppingList();

        productDao = db.productDao();
        allProducts = productDao.getAllProduct();

    }
    LiveData<List<ShoppingList>> getAllShoppingList() {
        return allShoppingList;
    }

    LiveData<List<Product>> getAllProduct() {
        return allProducts;
    }

    void insert(ShoppingList shoppingList) {
        Shoppingdb.databaseWriteExecutor.execute(() -> {
            shoppingListDao.insert(shoppingList);
        });
    }

    void insert(Product product) {
        Shoppingdb.databaseWriteExecutor.execute(() -> {
            productDao.insert(product);
        });
    }

//    void getProductById( -?- ) {
//        Shoppingdb.databaseWriteExecutor.execute(() -> {
//            productDao.getProductById( -?- );
//        });
//    }

}
