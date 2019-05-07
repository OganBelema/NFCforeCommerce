package com.oganbelema.basicnfclibrary

import android.app.Activity
import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter

/**
 * Use this class to register to detect nfc tags in an activity
 * @param activity to be notified when nfc tag is discovered
 * @author Belema Ogan
 */
class NFCRegistration(private val activity: Activity) {

    /**
     * This is the device's default nfc adapter.
     * Null if device does not have nfc technology
     */
    private val nfcAdapter = NfcAdapter.getDefaultAdapter(activity)

    fun isNfcAvailable(): Boolean {
        return nfcAdapter?.isEnabled ?: false
    }

    /**
     * This method enables the activity to be called when an nfc tag is discovered
     * It should be only called when activity is in foreground (resumed) state
     * @throws IllegalStateException if the Activity is not currently in the foreground
     * @throws UnsupportedOperationException if FEATURE_NFC is unavailable.
     */
    fun enableForegroundDispatch(){
        if (isNfcAvailable()){
            val nfcIntent = Intent(activity, activity::class.java)
            nfcIntent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING)
            val pendingIntent = PendingIntent.getActivity(activity, 0, nfcIntent, 0)
            val intentFilter = Array(0){ IntentFilter() }
            nfcAdapter?.enableForegroundDispatch(activity, pendingIntent, intentFilter, null)
        }
    }

    /**
     * This method disables the activity form being called when an nfc tag is discovered
     * this is for when activity is not in foreground state
     */
    fun disableForegroundDispatch() {
        if (isNfcAvailable()){
            nfcAdapter?.disableForegroundDispatch(activity)
        }
    }

}