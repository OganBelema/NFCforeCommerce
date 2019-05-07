package com.oganbelema.basicnfclibrary

import android.content.Intent
import android.nfc.NfcAdapter
import android.nfc.Tag
import androidx.fragment.app.Fragment
import com.oganbelema.basicnfclibrary.BaseActivityWithNfcListeners
import com.oganbelema.basicnfclibrary.NfcTagDiscoveredListener


/**
 * A base fragment that listens for nfc tag discovered notifications from a BaseActivityWithNfcListeners.
 * Contains helper methods that are required by an nfc listener fragment
 * Extend this to listen for nfc tag discovered notifications from a BaseActivityWithNfcListeners activity in a fragment
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
     * Registers the fragment as a listener for dispatched nfc tag discovered intent
     */
    private fun registerAsListener() {
        if (activity != null) {
            (activity as BaseActivityWithNfcListeners).registerTagDiscoveredListener(this)
        }
    }

    /**
     * Unregisters the fragment as a listener for dispatched nfc tag discovered intent
     */
    private fun unregisterAsListener() {
        if (activity != null) {
            (activity as BaseActivityWithNfcListeners).unregisterTagDiscoveredListener(this)
        }
    }

    override fun onStart() {
        super.onStart()
        registerAsListener()
    }

    override fun onStop() {
        unregisterAsListener()
        super.onStop()
    }
}
