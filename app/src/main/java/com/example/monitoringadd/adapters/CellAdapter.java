package com.example.monitoringadd.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monitoringadd.Client;
import com.example.monitoringadd.R;
import com.example.monitoringadd.models.Cell;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.List;

public class CellAdapter extends RecyclerView.Adapter<CellAdapter.CellViewHolder> {

    List<Cell> cellList;
    Context context;
    JSONObject object;

    public CellAdapter(Context context, List<Cell> cellList) {
        this.context = context;
        this.cellList = cellList;
    }


    @NonNull
    public CellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellItems = LayoutInflater.from(context).inflate(R.layout.cell_item, parent, false);

        return new CellAdapter.CellViewHolder(cellItems);
    }


    public void onBindViewHolder(@NonNull CellViewHolder holder, int position) {

        holder.cellNumber.setText(cellList.get(position).getCellNumber());
        holder.cellData.setText(cellList.get(position).getCellData());


    }



    public int getItemCount() {
        return cellList.size();
    }

    public void setCellObject(JSONObject object) {
        this.object = object;
    }



    public static final class CellViewHolder extends RecyclerView.ViewHolder{

        TextView cellNumber, cellData;
        ImageView cellImage;

        public CellViewHolder(@NonNull View itemView) {
            super(itemView);

            cellNumber = itemView.findViewById(R.id.cellNumber);
            cellData = itemView.findViewById(R.id.cellData);
            cellImage = itemView.findViewById(R.id.cellImage);
        }
    }
}
