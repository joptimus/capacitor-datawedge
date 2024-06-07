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

    private DataWedgePlugin implementation = new DataWedgePlugin();

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
}