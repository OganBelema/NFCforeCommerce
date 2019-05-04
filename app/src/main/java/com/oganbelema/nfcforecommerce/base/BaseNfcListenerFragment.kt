package com.oganbelema.nfcforecommerce.base

import android.content.Intent
import android.nfc.NfcAdapter
import android.nfc.Tag
import androidx.fragment.app.Fragment


/**
 * A base fragment that listens for nfc tag discovered notifications from the base
 * activity.
 * Contains helper methods that are required by an nfc listener fragment
 * Extend this to listen for nfc tag discovered notifications from the base activity in a fragment
 */
abstract class BaseNfcListenerFragment : Fragment(), NfcTagDiscoveredListener {

    /**
     * {@inheritDoc}
     */
    override fun onNfcTagDiscovered(intent: Intent?) {
        showTagDetectedViewState()
        processReceivedIntent(intent)
    }

    /**
     * Update the view to show the tag has been detected
     */
    abstract fun showTagDetectedViewState()

    /**
     * Extracts the tag id from the nfc tag contained in the received intent
     * @param intent containing the discovered tag
     */
    private fun processReceivedIntent(intent: Intent?){
        if (intent != null){
            val nfcTag = intent.getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG)
            onExtractTagId(nfcTag?.id)
        }
    }

    /**
     * Use this extracted tag id
     * @param tagId The unique id of the discovered nfc tag
     */
    abstract fun onExtractTagId(tagId: ByteArray?)

    /**
     * Registers the fragment to receive the detected tag from the activity
     */
    private fun registerTagDiscoveredListener() {
        if (activity != null){
            (activity as BaseActivity).nfcTagDiscoveredListeners.add(this)
        }
    }

    /**
     * Unregisters the fragment from receiving the detected tag from the activity
     */
    private fun unregisterTagDiscoveredListener(){
        if (activity != null){
            (activity as BaseActivity).nfcTagDiscoveredListeners.remove(this)
        }
    }

    override fun onStart() {
        super.onStart()
        registerTagDiscoveredListener()
    }

    override fun onStop() {
        unregisterTagDiscoveredListener()
        super.onStop()
    }

}
