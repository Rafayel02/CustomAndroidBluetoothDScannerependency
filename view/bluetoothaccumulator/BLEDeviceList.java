package am.threesmart.navio.bluetooth.view.bluetoothaccumulator;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import am.threesmart.navio.bluetooth.model.BLEDevice;

public class BLEDeviceList extends ArrayAdapter<BLEDevice> {
    private final Activity activity;
    private final int layoutResourceId;
    private final ArrayList<BLEDevice> devices;

    public BLEDeviceList(Activity activity, int resource, ArrayList<BLEDevice> devices) {
        super(activity.getApplicationContext(), resource, devices);
        this.activity = activity;
        this.layoutResourceId = resource;
        this.devices = devices;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.layoutResourceId, parent, false);
        }
        return convertView;
    }
}
