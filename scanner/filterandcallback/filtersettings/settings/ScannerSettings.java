package am.threesmart.navio.bluetooth.scanner.filterandcallback.filtersettings.settings;

import android.bluetooth.le.ScanSettings;

public class ScannerSettings {

    public static ScanSettings getScanSettings() {
        ScanSettings.Builder settingBuilder = new ScanSettings.Builder();
        settingBuilder.setScanMode(ScanSettings.SCAN_MODE_LOW_POWER);
        return settingBuilder.build();
    }

}
