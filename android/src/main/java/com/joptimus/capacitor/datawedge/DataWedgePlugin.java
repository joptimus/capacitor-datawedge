package com.joptimus.capacitor.datawedge;

import android.util.Log;

public class DataWedgePlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
