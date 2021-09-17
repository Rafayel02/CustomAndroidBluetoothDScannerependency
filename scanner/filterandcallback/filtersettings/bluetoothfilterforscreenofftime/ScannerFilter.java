package am.threesmart.navio.bluetooth.scanner.filterandcallback.filtersettings.bluetoothfilterforscreenofftime;

import android.bluetooth.le.ScanFilter;

public class ScannerFilter {

    public static ScanFilter getScanFilter() {
        ScanFilter.Builder builder = new ScanFilter.Builder();
        builder.setDeviceAddress("BE:AC:10:00:00:02");
        builder.setDeviceAddress("BE:AC:10:00:00:01");
        return builder.build();
    }

}
