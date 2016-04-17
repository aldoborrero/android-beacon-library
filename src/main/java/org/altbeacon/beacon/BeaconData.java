package org.altbeacon.beacon;

/**
 * Server-side data associated with a beacon.  Requires registration of a web service to fetch the
 * data.
 */
public interface BeaconData {
  Double getLatitude();

  void setLatitude(Double latitude);

  void setLongitude(Double longitude);

  Double getLongitude();

  String get(String key);

  void set(String key, String value);

  void sync(BeaconDataNotifier notifier);

  boolean isDirty();
}
