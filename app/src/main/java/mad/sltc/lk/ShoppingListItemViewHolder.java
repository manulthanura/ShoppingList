package mad.sltc.lk;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

public class ShoppingListItemViewHolder extends RecyclerView.ViewHolder {
    private CheckBox itemCheckbox;
    private EditText itemName;

    public ShoppingListItemViewHolder(View itemView) {
        super(itemView);
        itemCheckbox = itemView.findViewById(R.id.item_checkbox);
        itemName = itemView.findViewById(R.id.item_name);
    }

    public CheckBox getItemCheckbox() {
        return itemCheckbox;
    }

    public EditText getItemName() {
        return itemName;
    }
}

