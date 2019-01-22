package com.example.androidtest.recyclerview.repository;

import com.example.androidtest.recyclerview.data.RecyclerData;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class RecyclerRepositoryUtil {

    private static final String RECYCLER_IMAGE_URL = "https://img.icons8.com/color/1600/person-female.png";

    public static List<RecyclerData> getRecyclerList() {
        List<RecyclerData> recyclerDataList = Collections.emptyList();
        recyclerDataList.add(new RecyclerData("Juan", Calendar.getInstance().getTime(), RECYCLER_IMAGE_URL, 16, true, "This is my message", false));
        recyclerDataList.add(new RecyclerData("Pedro", Calendar.getInstance().getTime(), RECYCLER_IMAGE_URL, 32, true, "This is my message", true));
        recyclerDataList.add(new RecyclerData("Roberto", Calendar.getInstance().getTime(), RECYCLER_IMAGE_URL, 24, false, "This is my message", false));
        recyclerDataList.add(new RecyclerData("María", Calendar.getInstance().getTime(), RECYCLER_IMAGE_URL, 64, true, "This is my message", true));
        recyclerDataList.add(new RecyclerData("Ana", Calendar.getInstance().getTime(), RECYCLER_IMAGE_URL, 48, false, "This is my message", false));
        recyclerDataList.add(new RecyclerData("Pablo", Calendar.getInstance().getTime(), RECYCLER_IMAGE_URL, 86, true, "This is my message", true));
        return recyclerDataList;
    }

}