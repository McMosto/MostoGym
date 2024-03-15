package com.example.loginorsignup;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DatasetManager {
    private static DatasetManager instance;
    private Context context;
    private List<String[]> data;

    private DatasetManager(Context context) {
        this.context = context;
        loadData();
    }

    public static DatasetManager getInstance(Context context) {
        if (instance == null) {
            instance = new DatasetManager(context);
        }
        return instance;
    }

    private void loadData() {
        data = new ArrayList<>();
        InputStream is = context.getResources().openRawResource(R.raw.megagymdataset);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");
                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public List<String[]> getData() {
        return data;
    }
}
