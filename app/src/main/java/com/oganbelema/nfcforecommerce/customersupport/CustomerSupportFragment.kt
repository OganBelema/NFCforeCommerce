package com.oganbelema.nfcforecommerce.customersupport

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar

import com.oganbelema.nfcforecommerce.R
import com.oganbelema.basicnfclibrary.BaseNfcListenerFragment
import com.oganbelema.nfcforecommerce.util.Util
import kotlinx.android.synthetic.main.add_customer_fragment.scanNfcTagHintViews
import kotlinx.android.synthetic.main.customer_support_fragment.*

class CustomerSupportFragment : BaseNfcListenerFragment() {

    override fun showTagDetectedViewState() {
        if (scanNfcTagHintViews != null && creditCustomerViews != null) {
            scanNfcTagHintViews.visibility = View.GONE
            creditCustomerViews.visibility = View.VISIBLE
        }
    }

    override fun onExtractTagId(tagId: ByteArray?) {
        val tagIdInHexString = Util.byteArrayToHexString(tagId)
        tagIdTextView.text = tagIdInHexString
        Snackbar.make(this.view!!, "Nfc tag discovered with tag id: $tagIdInHexString",
            Snackbar.LENGTH_LONG).show()

        //TODO write code to query the db for customer and populateView
    }

    private lateinit var customerSupportViewModel: CustomerSupportViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.customer_support_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        customerSupportViewModel = ViewModelProviders.of(this).get(CustomerSupportViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
