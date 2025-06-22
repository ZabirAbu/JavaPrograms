package uk.ac.le.co2103.part2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;

    private ShopViewModel shopViewModel;

    public static final int ADD_ITEM_ACTIVITY_REQUEST_CODE = 1;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ShopListAdapter adapter = new ShopListAdapter(new ShopListAdapter.ShopDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        shopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        shopViewModel.getAllShoppingItems().observe(this, items -> {
            adapter.submitList(items);
        });

//        final FloatingActionButton button = findViewById(R.id.fab);
//        button.setOnClickListener(view -> {
//            Log.d(TAG, "Floating action button clicked.");
//            Toast.makeText(getApplicationContext(), "Not implemented yet.", Toast.LENGTH_LONG).show();
//        });
//
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, CreateListActivity.class));
//            }
//        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Log.d(TAG, "Floating action button clicked.");
            Toast.makeText(getApplicationContext(), "Not implemented yet.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, CreateListActivity.class);
            startActivityForResult(intent, ADD_ITEM_ACTIVITY_REQUEST_CODE);
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_ITEM_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            ShoppingList shop = new ShoppingList(data.getStringExtra(CreateListActivity.EXTRA_REPLY), data.getByteArrayExtra(CreateListActivity.EXTRA_REPLY_2));
            shopViewModel.insert(shop);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Shopping List Name cannot be empty",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, ShoppingListActivity.class));
    }

}