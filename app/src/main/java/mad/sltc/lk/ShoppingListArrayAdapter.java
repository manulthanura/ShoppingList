package mad.sltc.lk;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListArrayAdapter extends RecyclerView.Adapter<ShoppingListArrayAdapter.ShoppingListItemViewHolder> {

    private List<ShoppingListItem> shoppingList;
    private Activity activity;

    public ShoppingListArrayAdapter(List<ShoppingListItem> shoppingList, MainActivity mainActivity) {
        this.shoppingList = shoppingList;
        this.activity = activity;
    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    @NonNull
    @Override
    public ShoppingListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_list_item, parent, false);
        return new ShoppingListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListItemViewHolder holder, int position) {
        ShoppingListItem listItem = shoppingList.get(position);

        holder.nameEditText.setText(listItem.getName());

        holder.purchasedCheckbox.setChecked(listItem.isPurchased());

        if (position == shoppingList.size() - 1) { // last item is empty
            holder.purchasedCheckbox.setEnabled(false);
        } else {
            holder.purchasedCheckbox.setEnabled(true);
        }

        holder.purchasedCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            listItem.setPurchased(isChecked);
            filterShoppingList();
            refresh();
        });

        holder.nameEditText.setOnEditorActionListener((v, actionId, event) -> {
            if ((actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE
                    || actionId == EditorInfo.IME_ACTION_GO) && listItem.isEmptyItem()) {
                addItem(v.getText().toString());
            } else {
                listItem.setName(v.getText().toString());
                notifyDataSetChanged();
            }
            return true;
        });
    }

    private void filterShoppingList() {
        List<ShoppingListItem> filteredList = new ArrayList<>();
        for (ShoppingListItem listItem : this.shoppingList) {
            if (!listItem.isPurchased()) {
                filteredList.add(listItem);
            }
        }
        this.shoppingList = filteredList;
    }

    private void refresh() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            activity.runOnUiThread(() -> {
                notifyDataSetChanged();
            });
        }, 1000);
    }

    private void addItem(String name) {
        ShoppingListItem item = new ShoppingListItem(name, false);
        this.shoppingList.add(shoppingList.size() - 1, item);
        notifyDataSetChanged();
    }

    public static class ShoppingListItemViewHolder<EditText, CheckBox> extends RecyclerView.ViewHolder {
        EditText nameEditText;
        CheckBox purchasedCheckbox;

        public ShoppingListItemViewHolder(View itemView) {
            super(itemView);
            nameEditText = (EditText) itemView.findViewById(R.id.item_name);
            purchasedCheckbox = (CheckBox) itemView.findViewById(R.id.item_checkbox);
        }
    }
}




