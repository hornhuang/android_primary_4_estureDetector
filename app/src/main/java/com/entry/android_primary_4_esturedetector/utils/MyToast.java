package com.entry.android_primary_4_esturedetector.utils;

import android.content.Context;
import android.widget.Toast;

public class MyToast {

    public static void makeToast(Context context, String centent){
        Toast.makeText(context, centent, Toast.LENGTH_SHORT).show();
    }

}
