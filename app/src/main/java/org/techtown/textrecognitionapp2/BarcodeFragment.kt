package org.techtown.textrecognitionapp2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.techtown.textrecognitionapp2.databinding.FragmentBarcodeBinding

class BarcodeFragment : androidx.fragment.app.Fragment(){
    var mainActivity: MainActivity? = null
    var text:TextView?=null

    override fun onAttach(context: Context) { // 넘어온 Context를 인자로 받음
        super.onAttach(context)
        if(context is MainActivity) mainActivity = context // Context 타입이 MainActivity인 것을 확인한 후 프로퍼티에 저장
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.setupForAccessibility() // 프래그먼트 접근성이 이전 프래그먼트 view에 유지되어 보이스 오버 사용에 문제가 생기는 현상을 해결하기 위해 코드 추가
        // 새로 정의한 FragmentManager의 setupForAccessibility() 호출
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 버튼 클릭 시 main에 있는 fragment 이동 함수가 실행되도록 함
        val binding = FragmentBarcodeBinding.inflate(inflater, container, false)
        binding.btnBarcodeToExpiration.setOnClickListener { mainActivity?.goExpirationDate() }
        binding.btnBarcodeToMain.setOnClickListener { mainActivity?.goMain() }
        binding.btnBarcode.setOnClickListener { mainActivity?.startBarcodeReader() }

        return binding.root
    }


}