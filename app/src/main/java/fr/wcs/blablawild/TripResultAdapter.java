package fr.wcs.blablawild;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TripResultAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<TripResultModel> list;

    public TripResultAdapter(Context ctxt,ArrayList<TripResultModel> lst){
        this.context=ctxt;
        this.list=lst;
    }
    public int getCount() {
        return list.size();
    }
    public Object getItem(int position) {
        return list.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.trip_item, parent, false);
        }
        TripResultModel currentItem = (TripResultModel) getItem(position);
        TextView textViewItemName = convertView.findViewById(R.id.textViewFirstName);
        TextView textViewItemDepart = convertView.findViewById(R.id.textViewDepartureTime);
        TextView textViewItemPrice = convertView.findViewById(R.id.textViewViewPrice);
        textViewItemName.setText(currentItem.getName());
        textViewItemDepart.setText(currentItem.getDateDeparture().toString());
        textViewItemPrice.setText(String.valueOf(currentItem.getPrice()));
        return convertView;
    }
}