package com.oganbelema.nfcforecommerce.base

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.oganbelema.basicnfclibrary.BaseActivityWithNfcListeners
import com.oganbelema.basicnfclibrary.NFCRegistration
import com.oganbelema.nfcforecommerce.R
import kotlinx.android.synthetic.main.activity_base.*


/**
 * This base activity for the application that will serve as the entry point to the app
 */
class BaseActivity : BaseActivityWithNfcListeners() {

    /**
     * This is the device's default nfc adapter
     * It will be used to register for and unregister from listening to nfc events
     * Check out: https://developer.android.com/reference/android/nfc/NfcAdapter
     */
    private val nfcRegistration: NFCRegistration by lazy {
        NFCRegistration(this)
    }


    /**
     * Navigation controller to handle app's navigation
     */
    private lateinit var navController: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        navController = findNavController(R.id.nav_host_fragment)

        setupActionBarWithNavController(navController, null)

        bottom_navigation.setupWithNavController(navController)

        if (nfcRegistration.isNfcAvailable()){
            Toast.makeText(this, "Nfc ia available", Toast.LENGTH_LONG)
                .show()
        } else {
            Toast.makeText(this, "Nfc is not available", Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    override fun onResume() {
        super.onResume()
        nfcRegistration.enableForegroundDispatch()
    }

    override fun onPause() {
        super.onPause()
        nfcRegistration.disableForegroundDispatch()
    }


}
