package uk.ac.le.co2103.part2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ShoppingList.class, Product.class}, version = 1, exportSchema = false)
public abstract class Shoppingdb extends RoomDatabase {

    public abstract ShoppingListDao shoppingListDao();

    public abstract ProductDao productDao();

    private static volatile Shoppingdb INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static Shoppingdb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Shoppingdb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Shoppingdb.class, "Basket_db")
//                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

//    static byte [] filler;

//    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            databaseWriteExecutor.execute(() -> {
//                ProductDao dao2 = INSTANCE.productDao();
//                dao2.deleteAllProducts();
//                Product test2 = new Product("prime", 5, 2.3f, 1);
//                dao2.insert(test2);
//            });
//        }
//    };

}
