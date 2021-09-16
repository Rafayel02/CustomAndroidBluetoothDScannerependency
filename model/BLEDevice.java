package am.threesmart.navio.bluetooth.model;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;

/*
* BLEDevice is combination of BluetoothDevice of android and rssi value
* */
public class BLEDevice {

    private final BluetoothDevice bluetoothDevice;
    private final String rssi;

    public BLEDevice(final BluetoothDevice bluetoothDevice, final String rssi) {
        this.bluetoothDevice = bluetoothDevice;
        this.rssi = rssi;
    }

    public String getAddress() {
        return this.bluetoothDevice.getAddress();
    }

    public String getRssi() {
        return rssi;
    }

    @NonNull
    @Override
    public String toString() {
        return "BLEDevice{" +
                "Address=" + getAddress() +
                ", rssi='" + rssi + '\'' +
                '}';
    }

}
