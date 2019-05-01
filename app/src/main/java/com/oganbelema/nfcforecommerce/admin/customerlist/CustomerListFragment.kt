package com.oganbelema.nfcforecommerce.admin.customerlist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.oganbelema.nfcforecommerce.R

class CustomerListFragment : Fragment() {

    companion object {
        fun newInstance() = CustomerListFragment()
    }

    private lateinit var viewModel: CustomerListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.customer_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CustomerListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
