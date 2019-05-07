package com.oganbelema.basicnfclibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class BaseActivityWithNfcListeners : AppCompatActivity() {

    /**
     * Stores the listeners for when an nfc tag is discovered by the device and the
     * BaseActivity is called
     */
    private val nfcTagDiscoveredListeners: MutableList<NfcTagDiscoveredListener> = arrayListOf()

    /**
    * Registers the listener to receive the detected tag from the activity
     * @param nfcTagDiscoveredListener a listener for discovered nfc tag
    */
    fun registerTagDiscoveredListener(nfcTagDiscoveredListener: NfcTagDiscoveredListener) {
        nfcTagDiscoveredListeners.add(nfcTagDiscoveredListener)
    }

    /**
     * Unregisters the listener from receiving the detected tag from the activity
     * @param nfcTagDiscoveredListener a listener for discovered nfc tag
     */
    fun unregisterTagDiscoveredListener(nfcTagDiscoveredListener: NfcTagDiscoveredListener){
        nfcTagDiscoveredListeners.remove(nfcTagDiscoveredListener)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        notifyListenersOfDetectedTag(intent)
    }

    /**
     * Notifies the listeners that the tag was detected
     * @param intent containing the discovered tag
     */
    private fun notifyListenersOfDetectedTag(intent: Intent?) {
        for (nfcTagDiscoveredListener in nfcTagDiscoveredListeners) {
            nfcTagDiscoveredListener.onNfcTagDiscovered(intent)
        }
    }
}
