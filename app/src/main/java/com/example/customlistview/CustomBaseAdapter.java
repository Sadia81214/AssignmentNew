package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    String[] listFruit;
    int[] listImages;
    LayoutInflater inflater;
    int expandedPosition = -1; // Keeps track of the expanded item

    public CustomBaseAdapter(Context ctx, String[] fruitList, int[] images) {
        this.context = ctx;
        this.listFruit = fruitList;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listFruit.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        }

        TextView txtView = convertView.findViewById(R.id.textView);
        ImageView fruitImg = convertView.findViewById(R.id.imageIcon);
        TextView expandedText = convertView.findViewById(R.id.expandedText);

        txtView.setText(listFruit[position]);
        fruitImg.setImageResource(listImages[position]);

        // Dummy text for expanded view
        String dummyText = "Details about " + listFruit[position];

        if (position == expandedPosition) {
            expandedText.setVisibility(View.VISIBLE);
            expandedText.setText(dummyText);
        } else {
            expandedText.setVisibility(View.GONE);
        }

        txtView.setOnClickListener(v -> {
            if (expandedPosition == position) {
                // Collapse if the same item is clicked again
                expandedPosition = -1;
            } else {
                // Expand the clicked item and collapse the rest
                expandedPosition = position;
            }
            notifyDataSetChanged();
        });

        return convertView;
    }
}
