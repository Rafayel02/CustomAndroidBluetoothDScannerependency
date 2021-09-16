package am.threesmart.navio.bluetooth.scanner.filter;

import android.bluetooth.le.ScanFilter;
import android.os.ParcelUuid;

public class ScannerFilter {

    public static ScanFilter getScanFilter() {
        ScanFilter.Builder builder = new ScanFilter.Builder();
        ParcelUuid uuid = ParcelUuid.fromString("9B4EF172-BA6E-3E08-DA6B-08A8AEE14561");
        ParcelUuid uuidMask = ParcelUuid.fromString("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF");
        builder.setServiceUuid(uuid, uuidMask);
        return builder.build();
    }

}
