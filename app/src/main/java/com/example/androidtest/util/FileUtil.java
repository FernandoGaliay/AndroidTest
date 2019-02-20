package com.example.androidtest.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.androidtest.TestApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {

    public static String readFromRaw(int rawId) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        InputStream inputStream = TestApplication.getINSTANCE().getResources().openRawResource(rawId);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            Log.e(FileUtil.class.getSimpleName(), e.getMessage());
        }
        return stringBuilder.toString();
    }

    public static String readFromAssets(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line;
            InputStream inputStream = TestApplication.getINSTANCE().getAssets().open(name);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            Log.e(FileUtil.class.getSimpleName(), e.getMessage());
        }
        return stringBuilder.toString();
    }

    private static Bitmap loadBitmapFromAssets(String name) {
        try {
            return BitmapFactory.decodeStream(TestApplication.getINSTANCE().getAssets().open(name));
        } catch (IOException e) {
            Log.e(FileUtil.class.getSimpleName(), e.getMessage());
            return null;
        }
    }
}
