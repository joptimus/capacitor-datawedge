package com.joptimus.capacitor.datawedge;

import android.content.Context;
import android.content.Intent;
import netscape.javascript.JSObject;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "DataWedge")
public class DataWedgePlugin extends Plugin {

    private DataWedge implementation = new DataWedge();

    private Context context;

    @Override
    public void load() {
        context = getContext();
    }

    // @PluginMethod
    // public void echo(PluginCall call) {
    //     String value = call.getString("value");

    //     JSObject ret = new JSObject();
    //     ret.put("value", implementation.echo(value));
    //     call.resolve(ret);
    // }

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

    @PluginMethod
    public void echo(PluginCall call) {

        if (!getBridge().getPlatform().equalsIgnoreCase("android")) {
            call.reject("This method is only available on Android");
            return;
        }

        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.resolve(ret);
    }

    @PluginMethod
    public void setConfigProfile(PluginCall call) {
        try {
            JSONObject config = call.getObject("config");
            if (config == null) {
                call.reject("Missing config object");
                return;
            }

            String profileName = config.optString("profileName");
            if (profileName == null || profileName.isEmpty()) {
                call.reject("Profile name is required");
                return;
            }

            Intent intent = new Intent();
            intent.setAction("com.symbol.datawedge.api.ACTION");
            intent.putExtra("com.symbol.datawedge.api.SET_CONFIG", config.toString());

            Context context = getContext();
            context.sendBroadcast(intent);

            call.resolve();
        } catch (JSONException e) {
            call.reject("Error setting config profile", e);
        } catch (Exception e) {
            call.reject("Unexpected error in setting config", e);
        }
    }

    @PluginMethod
    public void enable(PluginCall call) {
        Intent intent = implementation.enable();

        try {
            broadcast(intent);
        } catch (ActivityNotFoundException e) {
            call.reject("DataWedge is not installed or not running");
        }
    }
    @PluginMethod
    public void disable(PluginCall call) {
        Intent intent = implementation.disable();

        try {
            broadcast(intent);
        } catch (ActivityNotFoundException e) {
            call.reject("DataWedge is not installed or not running");
        }
    }

    @PluginMethod
    public void enableScanner(PluginCall call) {
        Intent intent = implementation.enableScanner();

        try {
            broadcast(intent);
        } catch (ActivityNotFoundException e) {
            call.reject("DataWedge is not installed or not running");
        }
    }

    @PluginMethod
    public void disableScanner(PluginCall call) {
        Intent intent = implementation.disableScanner();

        try {
            broadcast(intent);
        } catch (ActivityNotFoundException e) {
            call.reject("DataWedge is not installed or not running");
        }
    }

    @PluginMethod
    public void startScanning(PluginCall call) {
         Intent intent = implementation.startScanning();

         try {
            broadcast(intent);
         } catch (ActivityNotFoundException e) {
            call.reject("DataWedge is not installed or not running");
         }
    }

    @PluginMethod
    public void stopScanning(PluginCall call) {
        Intent intent = implementation.stopScanning();

        try {
            broadcast(intent);
        } catch (ActivityNotFoundException e) {
            call.reject("DataWedge is not installed or not running");
        }
    }

    @PluginMethod
    public void __registerReceiver(PluginCall call) { 
        if (isReceiverRegistered) return;

        Context context = getBridge().getContext();
        try {
            IntentFilter filter = new IntentFilter(DataWedge.DATAWEDGE_INPUT_FILTER);
            context.registerReceiver(broadcastReceiver, filter);
            isReceiverRegistered = true;
        } catch(Exception e) {
            Log.d("Capacitor/DataWedge", "Failed to register event receiver");
        }
    }

    private void broadcast(Intent intent) {
        Context context = getBridge().getContext();
        context.sendBroadcast(intent);
    }

    private boolean isReceiverRegistered = false;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (!action.equals(DataWedge.DATAWEDGE_INPUT_FILTER)) return;

            try {
                String data = intent.getStringExtra("com.symbol.datawedge.data_string");
                String type = intent.getStringExtra("com.symbol.datawedge.label_type");

                JSObject ret = new JSObject();
                ret.put("data", data);
                ret.put("type", type);

                notifyListeners("scan", ret);
            } catch(Exception e) {}
        }
    };
}