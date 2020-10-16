package com.hr.smariaicamerav2.utils;

/**
 * Created by Hardik Patel on 02-12-2019.
 */
public interface OnUsbHidDeviceListener {
    void onUsbHidDeviceConnected(UsbHidDevice device);
    void onUsbHidDeviceConnectFailed(UsbHidDevice device);
}