package mad.sltc.lk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ShoppingListItem> shoppingList;
    private RecyclerView rvShoppingList;
    private ShoppingListArrayAdapter adapter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Initialize the shopping list and populate it with items
//        shoppingList = new ArrayList<>();
//        populateShoppingList();
//        shoppingList.add(new ShoppingListItem("", false)); // Add an empty item
//
//        // Find the RecyclerView and set its adapter
//        rvShoppingList = findViewById(R.id.rv_shopping_list);
//        adapter = new ShoppingListArrayAdapter(shoppingList, this);
//        rvShoppingList.setAdapter(adapter);
//
//        // Set the layout manager for the RecyclerView
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        rvShoppingList.setLayoutManager(layoutManager);
//
//    }

    private void populateShoppingList() {
        shoppingList.add(new ShoppingListItem("Apples", false));
        shoppingList.add(new ShoppingListItem("Bananas", true));
        shoppingList.add(new ShoppingListItem("Oranges", false));
    }
    private RecyclerView shoppingListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView
        shoppingListRecyclerView = findViewById(R.id.rv_shopping_list);

        // Populate the shopping list with some items
        List<ShoppingListItem> shoppingList = new ArrayList<>();
        shoppingList.add(new ShoppingListItem("Milk", false));
        shoppingList.add(new ShoppingListItem("Bread", false));
        shoppingList.add(new ShoppingListItem("", true)); // empty item at the end

        // Create the ShoppingListArrayAdapter and set it to the RecyclerView
        ShoppingListArrayAdapter shoppingListAdapter = new ShoppingListArrayAdapter(shoppingList, this);
        shoppingListRecyclerView.setAdapter(shoppingListAdapter);
        shoppingListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
