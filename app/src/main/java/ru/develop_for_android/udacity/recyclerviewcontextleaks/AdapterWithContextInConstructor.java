package ru.develop_for_android.udacity.recyclerviewcontextleaks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AdapterWithContextInConstructor
        extends RecyclerView.Adapter<AdapterWithContextInConstructor.ViewHolder> {

    private final int numberOfItems = 100;
    private Context context;

    public AdapterWithContextInConstructor(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewForListItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(viewForListItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(context.getResources()
                .getQuantityString(R.plurals.apple, position, position));
    }

    @Override
    public int getItemCount() {
        return numberOfItems;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View view;
        final TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            title = itemView.findViewById(R.id.item_title);
        }
    }
}
