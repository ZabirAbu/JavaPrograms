package uk.ac.le.co2103.part2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ShopViewHolder extends RecyclerView.ViewHolder {

    public final TextView listTextView;
    public final ImageView Icon;

    private ShopViewHolder(View shopView) {
        super(shopView);
        listTextView = shopView.findViewById(R.id.textView);
        Icon = shopView.findViewById(R.id.icon);

    }

//    public void bindShoppingList(String text, byte[] array) {
//        listTextView.setText(text);
//        if (Icon != null) {
//            Icon.setImageBitmap(byteArrayToBitmap(array));
//        }
//    }

    public void bindByteArray(byte[] arrr) {
        if (Icon != null) {
            Icon.setImageBitmap(byteArrayToBitmap(arrr));
        }
    }

    static ShopViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ShopViewHolder(view);
    }

    public static Bitmap byteArrayToBitmap(byte[] byteArray) {
        if (byteArray != null && byteArray.length > 0) {
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        } else {
            return null;
        }
    }

}
