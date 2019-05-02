package com.oganbelema.nfcforecommerce.base

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.oganbelema.nfcforecommerce.R
import kotlinx.android.synthetic.main.activity_base.*

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


    /**
     * Navigation controller to handle app's navigation
     */
    private lateinit var navController: NavController

    /**
     * A listener for when an nfc tag is discovered by the device and the
     * BaseActivity is called
     */
    var nfcTagDiscoveredListener: NfcTagDiscoveredListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        navController = findNavController(R.id.nav_host_fragment)

        setupActionBarWithNavController(navController, null)

        bottom_navigation.setupWithNavController(navController)

        if (isNfcAvailable()){
            Toast.makeText(this, "Nfc ia available", Toast.LENGTH_LONG)
                .show()
        } else {
            Toast.makeText(this, "Nfc is not available", Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    /**
     * Checks that the device has nfc capability and that nfc is enabled
     * @return true if nfc feature is available and enabled
     * @return false if it's not
     */
    private fun isNfcAvailable(): Boolean {
        return nfcAdapter?.isEnabled ?: false
    }

    /**
     * This method enables the activity to be called when an nfc tag is discovered
     * It should be only called when activity is in foreground (resumed) state
     * @throws IllegalStateException if the Activity is not currently in the foreground
     * @throws UnsupportedOperationException if FEATURE_NFC is unavailable.
     */
    private fun enableForegroundDispatch(){
        if (isNfcAvailable()){
            val nfcIntent = Intent(this, BaseActivity::class.java)
            nfcIntent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING)
            val pendingIntent = PendingIntent.getActivity(this, 0, nfcIntent, 0)
            val intentFilter = Array(0){ IntentFilter() }
            nfcAdapter?.enableForegroundDispatch(this, pendingIntent, intentFilter, null)
        }
    }

    /**
     * This method disables the activity form being called when an nfc tag is discovered
     * this is for when activity is not in foreground state
     */
    private fun disableForegroundDispatch() {
        if (isNfcAvailable()){
            nfcAdapter?.disableForegroundDispatch(this)
        }
    }

    override fun onResume() {
        super.onResume()
        enableForegroundDispatch()
    }

    override fun onPause() {
        super.onPause()
        disableForegroundDispatch()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        if (nfcTagDiscoveredListener != null){
            nfcTagDiscoveredListener?.onNfcTagDiscovered(intent)
        }
    }


}
