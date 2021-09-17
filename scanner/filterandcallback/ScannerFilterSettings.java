package am.threesmart.navio.bluetooth.scanner.filterandcallback;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;

import am.threesmart.navio.bluetooth.scanner.BLEScanner;
import am.threesmart.navio.bluetooth.scanner.filterandcallback.callback.ScannerCallBack;
import am.threesmart.navio.bluetooth.scanner.filterandcallback.filtersettings.bluetoothfilterforscreenofftime.ScannerFilter;
import am.threesmart.navio.bluetooth.scanner.filterandcallback.filtersettings.settings.ScannerSettings;

public class ScannerFilterSettings {

    private final ScanCallback scanCallback;
    private final ScanFilter scanFilter;
    private final ScanSettings scanSettings;

    public ScannerFilterSettings(BLEScanner scanner) {
        this.scanCallback = ScannerCallBack.getScanCallBack(scanner);
        this.scanFilter = ScannerFilter.getScanFilter();
        this.scanSettings = ScannerSettings.getScanSettings();
    }

    public ScanCallback getScanCallback() {
        return scanCallback;
    }

    public ScanFilter getScanFilter() {
        return scanFilter;
    }

    public ScanSettings getScanSettings() {
        return scanSettings;
    }
}
