package com.example.rupeektask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * Author : Shankar
 * github : https://github.com/shankarsimu/
 * Reach out for this project is available on github
 */

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rupeektask.R;
import com.example.rupeektask.DataModel;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Context context;
    private List<DataModel> dataModelList;

    public DataAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;

    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.data_list, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        holder.tempView.setText(dataModelList.get(position).getTemp()+"");
        holder.timeView.setText(dataModelList.get(position).getTime()+"");
        holder.rainView.setText(dataModelList.get(position).getRain()+"");
        holder.windView.setText(dataModelList.get(position).getWind()+"");

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tempView;
        TextView timeView;
        TextView rainView;
        TextView windView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tempView = itemView.findViewById(R.id.tempTxt);
            timeView = itemView.findViewById(R.id.timeTxt);
            rainView = itemView.findViewById(R.id.rainTxt);
            windView = itemView.findViewById(R.id.windTxt);

        }
    }
}
