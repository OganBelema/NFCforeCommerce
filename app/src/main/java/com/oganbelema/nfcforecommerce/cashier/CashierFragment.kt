package com.oganbelema.nfcforecommerce.cashier

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.oganbelema.nfcforecommerce.R
import com.oganbelema.basicnfclibrary.BaseNfcListenerFragment

class CashierFragment : BaseNfcListenerFragment() {

    override fun showTagDetectedViewState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onExtractTagId(tagId: ByteArray?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var viewModel: CashierViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cashier_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CashierViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
