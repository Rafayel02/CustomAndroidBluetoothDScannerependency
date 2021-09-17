package am.threesmart.navio.bluetooth.blefilter;

import android.bluetooth.le.ScanResult;

import am.threesmart.navio.bluetooth.model.BLEDevice;

public interface Filter {
    BLEDevice filter(ScanResult result);
}
