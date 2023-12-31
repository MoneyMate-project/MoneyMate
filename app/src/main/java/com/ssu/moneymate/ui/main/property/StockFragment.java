package com.ssu.moneymate.ui.main.property;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.ssu.moneymate.R;
import com.ssu.moneymate.databinding.FragmentBankBinding;
import com.ssu.moneymate.databinding.FragmentStockBinding;

import java.util.ArrayList;
import java.util.List;

public class StockFragment extends Fragment {
    private FragmentStockBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStockBinding.inflate(inflater, container, false);

        CheckBox kb_lifeplanet = binding.check1;

        binding.btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CheckBox 상태를 확인하여 필요한 정보를 저장할 리스트를 만듭니다.
                List<String> selectedCheckBoxes = new ArrayList<>();

                if (kb_lifeplanet.isChecked()) {
                    selectedCheckBoxes.add("KB 체크");
                }

                // 선택된 CheckBox 정보를 다른 곳으로 넘깁니다.
                for (String checkBoxInfo : selectedCheckBoxes) {
                    Log.d("CheckBoxInfo", checkBoxInfo);
                }

                Intent intent = new Intent(getActivity(), MyStockActivity.class);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}