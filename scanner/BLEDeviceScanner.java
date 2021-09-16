package am.threesmart.navio.bluetooth.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.pm.PackageManager;

import android.os.Handler;
import android.widget.Toast;

import java.util.Collections;

import am.threesmart.navio.MainActivity;
import am.threesmart.navio.bluetooth.checker.BluetoothChecker;
import am.threesmart.navio.bluetooth.scanner.callback.ScannerCallBack;
import am.threesmart.navio.bluetooth.scanner.filter.ScannerFilter;
import am.threesmart.navio.bluetooth.scanner.settings.ScannerSettings;


//This class can be singleton also...
public final class BLEDeviceScanner implements BLEScanner {

    private Handler handler;
    private int scanPeriod;
    private int timeout = 0;
    private long signalStrength;
    private boolean isScanning;
    private BluetoothAdapter adapter;
    private final MainActivity mainActivity;

    //Bluetooth adapter scanner settings
    private ScanCallback scanCallback;
    private ScanFilter scanFilter;
    private ScanSettings scanSettings;
    private Thread timeOutThread = null;

    public BLEDeviceScanner(final MainActivity mainActivity, final int periodOfScanning, final long signalStrength) {
        if (periodOfScanning < 0) {
            throw new RuntimeException("Scanning period must b bigger than 0...");
        }
        this.mainActivity = mainActivity;
        if (!mainActivity.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(mainActivity.getApplicationContext(), "BLE not supported!", Toast.LENGTH_SHORT).show();
            return;
        }

        this.handler = new Handler();
        this.scanPeriod = periodOfScanning;
        this.signalStrength = signalStrength;

        this.scanCallback = ScannerCallBack.getScanCallBack();
        this.scanFilter = ScannerFilter.getScanFilter();
        this.scanSettings = ScannerSettings.getScanSettings();

        BluetoothManager manager =
                (BluetoothManager) this.mainActivity.getSystemService(Context.BLUETOOTH_SERVICE);

        adapter = manager.getAdapter();
    }

    public BLEDeviceScanner(final MainActivity mainActivity,
                            final int periodOfScanning,
                            final int timeout,
                            final long signalStrength) {
        this(mainActivity, periodOfScanning, signalStrength);
        if (timeout < 0) {
            throw new RuntimeException("Timeout must be bigger than 0...");
        }
        this.timeout = timeout;
    }

    @Override
    public void start() {
        if (!BluetoothChecker.checkBluetooth(adapter)) {
            BluetoothChecker.requestUserBluetooth(this.mainActivity);
            return;
        }
        if (this.isScanning) {
            Toast.makeText(mainActivity.getApplicationContext(), "Already scanning...", Toast.LENGTH_SHORT).show();
            System.out.println("Already scanning...");
            return;
        }
        decideMethodOfScanningAndStart();
    }

    /*
     * The thread will be stopped after starting with given period,
     * don't disturb the handler finish it's work.
     * */
    @Override
    public void stop() {
        if (this.timeOutThread != null) {
            this.timeOutThread.interrupt();
            timeOutThread = null;
            return;
        }
        if (isScanning) {
            System.out.println("You can't stop one time scanning, just wait few moment...");
            return;
        }
        System.out.println("Scanning is off..");
    }

    @Override
    public boolean isScanning() {
        return isScanning;
    }

    private void decideMethodOfScanningAndStart() {
        if (timeout == 0) {
            startOneTimeWithPeriod();
            return;
        }
        startWithTimeout();
    }


    private void startWithTimeout() {
        timeOutThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    if (!isScanning) {
                        startOneTimeWithPeriod();
                        try {
                            Thread.sleep(timeout + scanPeriod);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        timeOutThread.start();
    }

    private void startOneTimeWithPeriod() {
        this.handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mainActivity.getApplicationContext(), "Stopping scanning...", Toast.LENGTH_SHORT).show();
                isScanning = false;
                adapter.getBluetoothLeScanner().stopScan(scanCallback);
                System.out.println("Stopping scanning...");
            }
        }, scanPeriod);

        System.out.println("Starting scanning...");
        //Toast.makeText(mainActivity.getApplicationContext(), "Starting scanning...", Toast.LENGTH_SHORT).show();
        adapter.getBluetoothLeScanner()
                .startScan(
                        Collections.singletonList(this.scanFilter),
                        this.scanSettings,
                        scanCallback
                );
        isScanning = true;
    }

}