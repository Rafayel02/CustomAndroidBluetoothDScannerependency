package am.threesmart.navio.bluetooth.scanner;

public interface BLEScanner {
    void start();
    void stop();
    boolean isScanning();
}
