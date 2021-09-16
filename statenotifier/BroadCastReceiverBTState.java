package am.threesmart.navio.bluetooth.statenotifier;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import am.threesmart.navio.MainActivity;

public class BroadCastReceiverBTState extends BroadcastReceiver {

    private final MainActivity activity;

    public BroadCastReceiverBTState(final MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
            System.out.println("Changed state of bluetooth");
            switch (state) {
                case BluetoothAdapter.STATE_OFF: {
                    Toast.makeText(this.activity, "Bluetooth is off...", Toast.LENGTH_SHORT).show();
                    break;
                }
                case BluetoothAdapter.STATE_TURNING_OFF: {
                    Toast.makeText(this.activity, "Bluetooth is turning off...", Toast.LENGTH_SHORT).show();
                    break;
                }
                case BluetoothAdapter.STATE_ON: {
                    Toast.makeText(this.activity, "Bluetooth is on...", Toast.LENGTH_SHORT).show();
                    break;
                }
                case BluetoothAdapter.STATE_TURNING_ON: {
                    Toast.makeText(this.activity, "Bluetooth is turning on...", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }


    }
}
