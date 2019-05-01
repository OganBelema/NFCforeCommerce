package com.oganbelema.nfcforecommerce.admin

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.oganbelema.nfcforecommerce.R

class AddCustomerFragment : Fragment() {

    companion object {
        fun newInstance() = AddCustomerFragment()
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
