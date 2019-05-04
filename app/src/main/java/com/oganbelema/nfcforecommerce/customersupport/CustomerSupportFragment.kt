package com.oganbelema.nfcforecommerce.customersupport

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.oganbelema.nfcforecommerce.R
import com.oganbelema.nfcforecommerce.base.BaseNfcListenerFragment

class CustomerSupportFragment : BaseNfcListenerFragment() {

    override fun onNfcTagDiscovered(intent: Intent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var customerSupportViewModel: CustomerSupportViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.customer_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        customerSupportViewModel = ViewModelProviders.of(this).get(CustomerSupportViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
