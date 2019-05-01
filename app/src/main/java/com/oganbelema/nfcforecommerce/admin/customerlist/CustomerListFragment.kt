package com.oganbelema.nfcforecommerce.admin.customerlist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController

import com.oganbelema.nfcforecommerce.R
import kotlinx.android.synthetic.main.customer_list_fragment.*

class CustomerListFragment : Fragment() {

    companion object {
        fun newInstance() = CustomerListFragment()
    }

    private lateinit var navController: NavController

    private lateinit var viewModel: CustomerListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.customer_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        addCustomerButton.setOnClickListener {
            navController.navigate(R.id.action_customerListFragment_to_addCustomerFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CustomerListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
