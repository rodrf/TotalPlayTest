package com.universe.totalplaytest.ui.view

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.universe.totalplaytest.R
import com.universe.totalplaytest.core.helpers.ActivityHelper
import com.universe.totalplaytest.databinding.ActivityClientResponseBinding
import com.universe.totalplaytest.ui.view.adapter.BankRefAdapter
import com.universe.totalplaytest.ui.viewmodel.ClientResponseViewModel
import com.universe.totalplaytest.ui.viewmodel.NetworkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClientResponseActivity : ActivityHelper(), OnClickListener {
    private lateinit var binding: ActivityClientResponseBinding

    private val clResponseViewModel: ClientResponseViewModel by viewModels()
    private val networkViewModel: NetworkViewModel by viewModels()
    private var netWorkConnected = false
    private var idSession: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientResponseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        idSession = intent.getStringExtra("idSession").toString()
        if (!idSession.isNullOrEmpty()) {
            clResponseViewModel.onCreate(idSession)
        }

        binding.tool.ivBackPressed.setOnClickListener(this)
        initRecycler()
        initObservers()

    }

    private fun initRecycler() {
        binding.rcvBankRef.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)

    }

    private fun initObservers() {
        clResponseViewModel.clientResponse.observe(this) { bankList ->
            binding.rcvBankRef.adapter = BankRefAdapter(bankList)
            binding.rcvBankRef.adapter?.notifyDataSetChanged()
            binding.rcvBankRef.scheduleLayoutAnimation()
        }
        clResponseViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                this.showLoader(getString(R.string.loading))
            } else {
                this.hideLoader()
            }
        }
        networkViewModel.connected.observe(this) { connected ->
            netWorkConnected = connected
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.tool.ivBackPressed.id -> {
                onBackPressed()
            }
        }
    }

}