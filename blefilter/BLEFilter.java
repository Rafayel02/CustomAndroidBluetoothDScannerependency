package am.threesmart.navio.bluetooth.blefilter;

import android.bluetooth.le.ScanResult;

import am.threesmart.navio.bluetooth.model.BLEDevice;

public class BLEFilter implements Filter {

    /*Filter objects array keeps all needed objects for making filtration
    * RULES:
    *   1.First element (index 0) is always signal strength
    *   2. ...
    *   3. ...
    * Define rules yourself and follow them!
    * */
    private final Object[] filterObjects;

    public BLEFilter(Object... filterObjects) {
        this.filterObjects = filterObjects;
    }

    @Override
    public BLEDevice filter(ScanResult result) {

        if(this.filterObjects.length == 0) {
            return new BLEDevice(result.getDevice(), result.getRssi());
        }

        BLEDevice device = null;
        if (result.getRssi() > (Integer) filterObjects[0]) {
            device = new BLEDevice(
                    result.getDevice(),
                    result.getRssi()
            );
        }
        return device;
    }
}
