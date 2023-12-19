package com.example.buysell.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import com.example.buysell.adapters.CategoryAdapter;
import com.example.buysell.R;
import com.example.buysell.adapters.ProductAdapter;
import com.example.buysell.databinding.ActivityMainBinding;
import com.example.buysell.model.Category;
import com.example.buysell.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;
    ProductAdapter productAdapter;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initCategories();
        initProducts();


    }

    void initCategories(){
        categories = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(this,categories);
        categories.add(new Category("UB","","#18ab4e","",1));
        categories.add(new Category("Mayuri","","#18ab4e","",2));
        categories.add(new Category("Night Canteen Boys","","#18ab4e","",3));
        categories.add(new Category("Night Canteen Girls","","#18ab4e","",4));

        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        binding.categorieslist.setLayoutManager(layoutManager);

        binding.categorieslist.setAdapter(categoryAdapter);
    }
    void initProducts(){
        products = new ArrayList<>();
        products.add(new Product("Butter Paneer","","Available",200,1));
        products.add(new Product("Butter Chicken","","Available",200,1));
        products.add(new Product("Kadhai Paneer","","Available",200,1));
        products.add(new Product("Kadhai Chicken","","Available",200,1));
        products.add(new Product("Sandwich","","Available",200,1));
        productAdapter = new ProductAdapter(this,products);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        binding.productList.setLayoutManager(layoutManager);
        binding.productList.setAdapter(productAdapter);
    }
}