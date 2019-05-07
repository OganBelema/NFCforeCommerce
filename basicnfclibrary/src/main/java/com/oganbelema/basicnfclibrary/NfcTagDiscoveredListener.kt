package com.oganbelema.basicnfclibrary

import android.content.Intent

/**
 * Implement this to be able to receive nfc tag intent from the BaseActivity's onNewIntent
 * @author Belema Ogan
 */
interface NfcTagDiscoveredListener {

    /**
     * Called when the activity receives a tag found intent
     * @param intent the intent containing the nfc tag
     */
    fun onNfcTagDiscovered(intent: Intent?)
}