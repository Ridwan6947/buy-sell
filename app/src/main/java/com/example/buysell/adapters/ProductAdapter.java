package com.example.buysell.adapters;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buysell.R;
import com.example.buysell.model.Product;

import com.example.buysell.databinding.ItemProductBinding;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductviewHolder> {

    Context context;
    ArrayList<Product> products;

    public ProductAdapter(Context context , ArrayList<Product> products){
        this.context = context;
        this.products = products;
    }
    @NonNull
    @Override
    public ProductviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductviewHolder(LayoutInflater.from(context).inflate(R.layout.item_product,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductviewHolder holder, int position) {
        Product product = products.get(position);
        Glide.with(context).load(product.getImage()).into(holder.binding.image);
        holder.binding.label.setText(product.getName());
        holder.binding.price.setText("INR " + product.getPrice());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductviewHolder extends RecyclerView.ViewHolder{
        ItemProductBinding binding;
        public ProductviewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemProductBinding.bind(itemView);
        }
    }
}
