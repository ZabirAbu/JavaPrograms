package uk.ac.le.co2103.part2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ShoppingListActivity extends AppCompatActivity {

    private static final String TAG = ShoppingListActivity.class.getSimpleName();

    private ShopViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        RecyclerView productRecyclerView = findViewById(R.id.product_recyclerView);
        final ProductListAdaptor adaptor = new ProductListAdaptor(new ProductListAdaptor.ProductDiff());
        productRecyclerView.setAdapter(adaptor);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        productViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        productViewModel.getAllProducts().observe(this, p -> {
            adaptor.submitList(p);
        });

    }
}