package com.oganbelema.nfcforecommerce.admin.addcustomer

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar

import com.oganbelema.nfcforecommerce.R
import com.oganbelema.nfcforecommerce.base.BaseNfcListenerFragment
import com.oganbelema.nfcforecommerce.util.Util
import kotlinx.android.synthetic.main.add_customer_fragment.*

class AddCustomerFragment : BaseNfcListenerFragment() {

    /**
     * {@inheritDoc}
     * It hides the scan tag animation and shows the add customer view elements
     */
    override fun showTagDetectedViewState() {
        if (scanNfcTagHintViews != null && addCustomerViews != null) {
            scanNfcTagHintViews.visibility = View.GONE
            addCustomerViews.visibility = View.VISIBLE
        }
    }

    override fun onExtractTagId(tagId: ByteArray?) {
        val tagIdInHexString = Util.byteArrayToHexString(tagId)
        tagIdEditText.setText(tagIdInHexString)
        Snackbar.make(this.view!!, "Nfc tag discovered with tag id: $tagIdInHexString",
            Snackbar.LENGTH_LONG).show()
    }

    private lateinit var viewModel: AddCustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_customer_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddCustomerViewModel::class.java)
        // TODO: Use the ViewModel
    }



}
