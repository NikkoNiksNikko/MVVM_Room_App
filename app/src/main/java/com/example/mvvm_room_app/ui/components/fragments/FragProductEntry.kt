package com.example.mvvm_room_app.ui.components.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_room_app.R
import com.example.mvvm_room_app.domain.RequestCallback
import com.example.mvvm_room_app.models.`object`.Product
import com.example.mvvm_room_app.ui.base.BaseFragment
import com.example.mvvm_room_app.ui.components.adapter.RecvProduct
import com.example.mvvm_room_app.ui.viewModels.ProductViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class FragProductEntry : BaseFragment() {

    private val mViewModel : ProductViewModel by activityViewModel()

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchBtn : Button
    private lateinit var editText: EditText
    private lateinit var addBtn : Button

    override fun setLayoutId(): Int {
        return R.layout.frag_product_entry
    }

    override fun initViews(savedInstanceState: Bundle?) {
        editText = requireView().findViewById(R.id.searchEditText)
        searchBtn = requireView().findViewById(R.id.searchBtn)
        recyclerView = requireView().findViewById(R.id.recycleViewId)
        addBtn = requireView().findViewById(R.id.addBtn)

        addBtn.setOnClickListener(mOnAddClicked)
        searchBtn.setOnClickListener(mOnSearchClicked)
        initRevTask()
    }

    override fun initData() {
        displayAllData()
    }

    private fun displayAllData(){
        // STATE FLOW
        viewLifecycleOwner.lifecycleScope.launch {
            mViewModel.products.collectLatest {
                (recyclerView.adapter as RecvProduct).apply {
                    list = it
                    notifyDataSetChanged()
                }
            }
        }

        mViewModel.loadAllProducts()
    }

    private fun initRevTask(){
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = RecvProduct(listOf())
    }

    private val mOnAddClicked = View.OnClickListener {
        findNavController().navigate(FragProductEntryDirections.actionFragProductEntryToFragProductDetails())
    }

    private val mOnSearchClicked = View.OnClickListener {
        mViewModel.searchProductsByName(editText.text.toString(), object : RequestCallback<List<Product>>{
            override fun onSuccess(data: List<Product>) {
//                if(data.isEmpty()) displayAllData()
            }

            override fun onFail(throwable: Throwable) {
                Log.e("Error ", "$throwable")
            }
        })
    }

}