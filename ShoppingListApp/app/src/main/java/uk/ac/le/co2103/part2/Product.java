package uk.ac.le.co2103.part2;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "product",
        foreignKeys = @ForeignKey(entity = ShoppingList.class,
                parentColumns = "listId",
                childColumns = "shoppingListId",
                onDelete = CASCADE,
                onUpdate = CASCADE))
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "quantity")
    private int quantity;

    @ColumnInfo(name = "unit")
    private float unit;

    @Nullable
    private int shoppingListId;  // foreign key

    public Product(String name, int quantity, float unit, int shoppingListId) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.shoppingListId = shoppingListId;
    }

    public Product() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnit() {
        return unit;
    }

    public void setUnit(float unit) {
        this.unit = unit;
    }

    public int getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        this.shoppingListId = shoppingListId;
    }
}
