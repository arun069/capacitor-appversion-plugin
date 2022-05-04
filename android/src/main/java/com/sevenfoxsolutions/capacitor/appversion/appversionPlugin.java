package com.sevenfoxsolutions.capacitor.appversion;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "appversion")
public class appversionPlugin extends Plugin {

    private aversion implementation = new aversion();

    @PluginMethod
    public void getInfoFromOs(PluginCall call) {
        try {
            Integer value = call.getInt("requestFor"); // getting request for
            switch (value){
                case 0: // appName
                    implementation.appName(call, this.getContext());
                    break;
                case 1: //PackageName
                    implementation.PackageName(call, this.getContext());
                    break;
                case 2: // VersionNumber
                    implementation.VersionNumber(call, this.getContext());
                    break;
                case 3: // VersionCode
                    implementation.VersionCode(call, this.getContext());
                    break;
                case 4: // androidVer
                    implementation.androidVer(call);
                    break;
                case 5: // androidSdkVersion
                    implementation.androidSdkVersion(call);
                    break;
                case 6: // androidOsName
                    implementation.androidOsName(call);
                    break;
                default: // if not match any
                    call.errorCallback("Invalid Operation Called!");
                    break;
            }
        }catch (Exception ex){
            call.errorCallback(ex.getMessage());
        }
    }
}
