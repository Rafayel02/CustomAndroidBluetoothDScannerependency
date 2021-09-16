package am.threesmart.navio.bluetooth.scanner.callback;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;

public class ScannerCallBack {

    public static ScanCallback scanCallback = null;

    public static ScanCallback getScanCallBack() {
        if (scanCallback != null) {
            return scanCallback;
        }
        scanCallback = new ScanCallback() {
            @Override
            public void onScanResult(int callbackType, ScanResult result) {
                System.out.println("New device detected: ");
                System.out.println(result.getDevice().getAddress() + " - " + result.getRssi());
            }
        };
        return scanCallback;
    }


}
