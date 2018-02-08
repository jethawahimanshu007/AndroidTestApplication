package com.example.himanshu.kubratest;

import android.util.Log;

/**
 * Created by Himanshu on 1/22/2018.
 */
/*Class to make logging easy*/
public class Logger {
    public static void log_d(String message){
        Log.d(new Exception().getStackTrace()[1].getClassName(),message);
    }
}
