package com.oganbelema.nfcforecommerce.base

import android.nfc.NfcAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.oganbelema.nfcforecommerce.R

/**
 * This base activity for the application that will serve as the entry point to the app
 */
class BaseActivity : AppCompatActivity() {

    /**
     * This is the device's default nfc adapter
     * It will be used to register for and unregister from listening to nfc events
     * Check out: https://developer.android.com/reference/android/nfc/NfcAdapter
     */
    private val nfcAdapter: NfcAdapter? by lazy {
        NfcAdapter.getDefaultAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        checkNfcAvailability()
    }

    /**
     * Checks that the device has nfc capability and that nfc is enabled
     * Displays a toast message for each case
     */
    private fun checkNfcAvailability() {
        if (nfcAdapter != null && nfcAdapter!!.isEnabled) {
            Toast.makeText(this, "Nfc ia available", Toast.LENGTH_LONG)
                .show()
        } else {
            Toast.makeText(this, "Nfc is not available", Toast.LENGTH_LONG)
                .show()
        }
    }
}
