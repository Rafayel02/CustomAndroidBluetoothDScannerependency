package am.threesmart.navio.bluetooth.scanner.filterandcallback.callback;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;

import am.threesmart.navio.bluetooth.scanner.BLEScanner;

public class ScannerCallBack {

    private static ScanCallback scanCallback = null;

    public static ScanCallback getScanCallBack(BLEScanner scanner) {
        if (scanCallback != null) {
            return scanCallback;
        }
        scanCallback = new ScanCallback() {
            @Override
            public void onScanResult(int callbackType, ScanResult result) {
                scanner.handleNewDeviceFromScannerResult(result);
            }
        };
        return scanCallback;
    }


}
