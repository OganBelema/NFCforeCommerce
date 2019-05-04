package com.oganbelema.nfcforecommerce.base

import androidx.fragment.app.Fragment


/**
 * A base fragment that listens for nfc tag discovered notifications from the base
 * activity.
 * Contains helper methods that are required by an nfc listener fragment
 * Extend this to listen for nfc tag discovered notifications from the base activity in a fragment
 */
abstract class BaseNfcListenerFragment : Fragment(), NfcTagDiscoveredListener {

    /**
     * Registers the fragment to receive the detected tag from the activity
     */
    private fun registerTagDiscoveredListener() {
        if (activity != null){
            (activity as BaseActivity).nfcTagDiscoveredListener = this
        }
    }

    /**
     * Unregisters the fragment from receiving the detected tag from the activity
     */
    private fun unregisterTagDiscoveredListener(){
        if (activity != null){
            (activity as BaseActivity).nfcTagDiscoveredListener = null
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
