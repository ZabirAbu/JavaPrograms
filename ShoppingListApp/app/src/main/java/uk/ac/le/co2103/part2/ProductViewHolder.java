package uk.ac.le.co2103.part2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    private final TextView name, quantity, unit;

    private ProductViewHolder(View productView) {
        super(productView);
        name = productView.findViewById(R.id.name);
        quantity = productView.findViewById(R.id.quantity);
        unit = productView.findViewById(R.id.unit);
    }

    public void bindProduct(String t, int i, float f) {
        name.setText(t);
        quantity.setText(i);
        unit.setText(Float.toString(f));
    }

    static ProductViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_products, parent, false);
        return new ProductViewHolder(view);
    }

}
