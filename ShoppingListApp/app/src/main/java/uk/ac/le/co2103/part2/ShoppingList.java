package uk.ac.le.co2103.part2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopping_lists")
public class ShoppingList {

    @PrimaryKey(autoGenerate = true)
    private int listId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "image")
    @Nullable
    private byte [] image;

    public ShoppingList(String name, @Nullable byte[] image) {
        this.name = name;
        this.image = image;
    }

    public ShoppingList() {
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public byte[] getImage() {
        return image;
    }

    public void setImage(@Nullable byte[] image) {
        this.image = image;
    }
}
