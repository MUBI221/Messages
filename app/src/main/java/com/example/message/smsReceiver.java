package com.example.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class smsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Bundle bundle = intent.getExtras ();
        Object[] smsObj = (Object[]) bundle.get ("pdus");

        for (Object obj : smsObj) {
            SmsMessage.createFromPdu ((byte[]) obj);
            SmsMessage message = null;
            String mobNo = message.getDisplayOriginatingAddress ();
            String msg = message.getDisplayMessageBody ();

            Log.d ("MSgDetails", "MobNo" + mobNo + ",Msg:" + msg);


            SmsManager smsManager = SmsManager.getDefault ();
            smsManager.sendTextMessage ("+92432977915",null,"Hello",null,null);



        }
    }
}
