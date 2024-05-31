package com.joptimus.capacitor.datawedge;

import android.content.Context;
import android.content.Intent;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.plugin.util.Logger;

@CapacitorPlugin(name = "DataWedge")
public class DataWedgePlugin extends Plugin {

    private Context context;

    @Override
    public void load() {
        context = getContext();
    }

    @PluginMethod
    public void sendCommand(PluginCall call) {
        String command = call.getString("command");
        if (command == null) {
            call.reject("Must provide a command");
            return;
        }

        Intent intent = new Intent();
        intent.setAction("com.symbol.datawedge.api.ACTION");
        intent.putExtra("com.symbol.datawedge.api.SOFT_SCAN_TRIGGER", command);
        context.sendBroadcast(intent);
        call.resolve();
    }
}

