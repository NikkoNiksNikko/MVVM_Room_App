package com.example.mvvm_room_app.ui.components.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.mvvm_room_app.R
import com.example.mvvm_room_app.domain.RequestCallback
import com.example.mvvm_room_app.models.`object`.Product
import com.example.mvvm_room_app.ui.base.BaseFragment
import com.example.mvvm_room_app.ui.viewModels.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class FragProductDetails : BaseFragment() {

    private val mViewModel : ProductViewModel by activityViewModel()

    private lateinit var saveBtn : Button
    private lateinit var cancelBtn : Button
    private lateinit var nameEditText : EditText
    private lateinit var descEditText : EditText
    private lateinit var createBtn : Button
    private lateinit var deleteBtn : Button

    override fun setLayoutId(): Int {
        return R.layout.frag_product_details
    }

    override fun initViews(savedInstanceState: Bundle?) {
        saveBtn = requireView().findViewById(R.id.saveBtn)
        nameEditText = requireView().findViewById(R.id.nameEditText)
        descEditText = requireView().findViewById(R.id.descEditText)
        cancelBtn = requireView().findViewById(R.id.cancelBtn)
        createBtn = requireActivity().findViewById(R.id.createBtn)
        deleteBtn = requireActivity().findViewById(R.id.deleteBtn)

        createBtn.setOnClickListener(mOnCreateBtnClicked)
        cancelBtn.setOnClickListener { findNavController().navigateUp() }
    }

    override fun initData() {
    }

    private val mOnCreateBtnClicked = View.OnClickListener {
        val data = Product(
            productName = nameEditText.text.toString(),
            productDescription = descEditText.text.toString()
        )

        mViewModel.insertNewProduct(data, object : RequestCallback<Product>{
            override fun onSuccess(data: Product) {
                onNavBack()
            }

            override fun onFail(throwable: Throwable) {
                Log.e("Error ", "$throwable")
            }
        })
    }

    private fun onNavBack(){
        activity?.runOnUiThread { findNavController().navigateUp() }
    }
}