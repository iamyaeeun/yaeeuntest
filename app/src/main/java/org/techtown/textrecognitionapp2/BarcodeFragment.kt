package org.techtown.textrecognitionapp2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.techtown.textrecognitionapp2.databinding.FragmentBarcodeBinding

class BarcodeFragment : Fragment() {

    var mainActivity: MainActivity? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_barcode, container, false)
        val binding = FragmentBarcodeBinding.inflate(inflater, container, false)
        binding.btnNext.setOnClickListener { mainActivity?.goExpirationDate() }
        binding.btnBackToMain.setOnClickListener { mainActivity?.goMain() }
        return binding.root
    }

}