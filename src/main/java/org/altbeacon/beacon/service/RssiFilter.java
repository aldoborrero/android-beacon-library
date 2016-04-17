package org.altbeacon.beacon.service;

/**
 * Interface that can be implemented to overwrite measurement and filtering
 * of RSSI values
 */
public interface RssiFilter {

  void addMeasurement(Integer rssi);

  boolean noMeasurementsAvailable();

  double calculateRssi();
}
