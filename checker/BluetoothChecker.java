package am.threesmart.navio.bluetooth.checker;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

import am.threesmart.navio.MainActivity;

public class BluetoothChecker {

    // Bluetooth adapter validation
    public static boolean checkBluetooth(BluetoothAdapter bluetoothAdapter) {
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    // Bluetooth request
    public static void requestUserBluetooth(Activity activity) {
        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        activity.startActivityForResult(enableBtIntent, MainActivity.REQUEST_ENABLE_BLE);
    }

}
