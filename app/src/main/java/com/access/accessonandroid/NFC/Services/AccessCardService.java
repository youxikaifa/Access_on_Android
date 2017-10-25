package com.access.accessonandroid.NFC.Services;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;

import com.access.accessonandroid.Data.EmployeeRecord;
import com.access.accessonandroid.NFC.HCE.HCEAccessProtocolEngine;
import com.access.accessonandroid.NFC.HCE.IHCEProtocolEngine;

/**
 * The AccessCardService class extends the HostAdpuService class and provides the communication
 * interface between the NFC controller and the application. As such, this class is responsible for
 * receiving and responding to incoming NFC data.
 *
 * Created by Tyler Collison on 10/24/2017.
 */
public class AccessCardService extends HostApduService  {

    private static IHCEProtocolEngine protocolEngine =
            new HCEAccessProtocolEngine(EmployeeRecord.getInstance());

    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {
        return protocolEngine.getResponse(commandApdu);
    }

    @Override
    public void onDeactivated(int reason) {}
}
