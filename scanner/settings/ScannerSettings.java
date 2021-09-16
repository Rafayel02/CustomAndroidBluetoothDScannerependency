package am.threesmart.navio.bluetooth.scanner.settings;

import android.bluetooth.le.ScanSettings;

public class ScannerSettings {

    public static ScanSettings getScanSettings() {
        ScanSettings.Builder settingBuilder = new ScanSettings.Builder();
        return settingBuilder.build();
    }

}
