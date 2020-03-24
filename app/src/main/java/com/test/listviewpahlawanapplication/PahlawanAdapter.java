package com.test.listviewpahlawanapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.listviewpahlawanapplication.Pahlawan;
import com.test.listviewpahlawanapplication.R;

import java.util.ArrayList;

public class PahlawanAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pahlawan> pahlawans = new ArrayList<>();

    public void setPahlawans(ArrayList<Pahlawan> pahlawans) {
        this.pahlawans = pahlawans;
    }

    public PahlawanAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return pahlawans.size();
    }

    @Override
    public Object getItem(int i) {
        return pahlawans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder (itemView);

        Pahlawan pahlawan = (Pahlawan) getItem(i);
        viewHolder.bind(pahlawan);
        return itemView;
    }


    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder (View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind (Pahlawan pahlawan) {
            txtName.setText(pahlawan.getName());
            txtDescription.setText(pahlawan.getDescription());
            imgPhoto.setImageResource(pahlawan.getPhoto());
        }
    }
}
