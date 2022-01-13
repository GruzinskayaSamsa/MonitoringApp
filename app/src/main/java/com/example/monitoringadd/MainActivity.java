package com.example.monitoringadd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.monitoringadd.adapters.CellAdapter;
import com.example.monitoringadd.models.Cell;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView cellRecycler;
    CellAdapter cellAdapter;
    JSONObject object;
    static List<Cell> cellList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cellList.add(new Cell(1, "1", "no data"));
        cellList.add(new Cell(2, "2", "no data"));
        cellList.add(new Cell(3, "3", "no data"));
        cellList.add(new Cell(4, "4", "no data"));

        setCellRecycler(cellList);


        String url = "http://service.gilenko.net/crcommand/getLatest";

//        Client client = new Client();
//        CellAdapter cellAdapter = new CellAdapter(this, cellList);



    }

    public void setCellRecycler(List<Cell> cellList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        cellRecycler = findViewById(R.id.cellRecycler);
        cellRecycler.setLayoutManager(layoutManager);

        cellAdapter = new CellAdapter(this, cellList);
        cellRecycler.setAdapter(cellAdapter);

    }


    public void updateCellRecycler(int cellCount, List<Double> cells) {

        List<Cell> cellList = new ArrayList<>();

        for (int i = 0; i < cellCount; i++) {
            cellList.add(new Cell(i+1, Integer.toString(i+1), cells.toString()));
        }

        setCellRecycler(cellList);

    }

}