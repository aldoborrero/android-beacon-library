package org.altbeacon.beacon.service.scanner;

import android.bluetooth.BluetoothDevice;

public interface CycledLeScanCallback {
  void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord);

  void onCycleEnd();
}
