package am.threesmart.navio.bluetooth.scanner;

import android.bluetooth.le.ScanResult;

public interface BLEScanner {
    void start();
    void stop();
    boolean isScanning();
    void handleNewDeviceFromScannerResult(ScanResult result);
}
