package uk.ac.le.co2103.part2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class ShopListAdapter extends ListAdapter<ShoppingList, ShopViewHolder> {

    public ShopListAdapter(DiffUtil.ItemCallback<ShoppingList> diffCallBack) {
        super(diffCallBack);
    }

    @Override
    public ShopViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return ShopViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(ShopViewHolder holder, int position) {
        ShoppingList current = getItem(position);
        holder.listTextView.setText(current.getName());
        holder.bindByteArray(current.getImage());
//        byte[] imageByteArray = current.getImage();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length);
//        holder.Icon.setImageBitmap(bitmap);
    }

    static class ShopDiff extends DiffUtil.ItemCallback<ShoppingList> {

        @Override
        public boolean areItemsTheSame(ShoppingList oldItem, ShoppingList newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(ShoppingList oldItem, ShoppingList newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
