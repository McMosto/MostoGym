package com.example.loginorsignup;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Dataset {
    private static Dataset instance;
    private Context context;
    private List<String[]> data;

    private Dataset(Context context) {
        this.context = context;
        loadData();
    }

    public static Dataset getInstance(Context context) {
        if (instance == null) {
            instance = new Dataset(context);
        }
        return instance;
    }

    private void loadData() {
        data = new ArrayList<>();
        InputStream is = context.getResources().openRawResource(R.raw.gymdataset);
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
