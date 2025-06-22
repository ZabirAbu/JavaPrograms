package uk.ac.le.co2103.part2;

import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class ProductListAdaptor  extends ListAdapter<Product, ProductViewHolder> {

    public ProductListAdaptor(@NonNull DiffUtil.ItemCallback<Product> diffCallBack) {
        super(diffCallBack);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ProductViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product current = getItem(position);
        holder.bindProduct(current.getName(), current.getQuantity(), current.getUnit());
    }

    static class ProductDiff extends DiffUtil.ItemCallback<Product> {

        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }

}
