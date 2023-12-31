package com.ssu.moneymate.ui.main.property;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.ssu.moneymate.R;
import com.ssu.moneymate.databinding.FragmentBankBinding;
import com.ssu.moneymate.ui.main.goal.GoalActivity;

import java.util.ArrayList;
import java.util.List;

public class BankFragment extends Fragment {
        private FragmentBankBinding binding;
    private boolean kbChecked = false;
    private boolean nhChecked = false;
    private PropertyViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBankBinding.inflate(inflater, container, false);

        CheckBox kb_check = binding.check1;
        CheckBox nh_check = binding.check2;

        viewModel = new ViewModelProvider(this).get(PropertyViewModel.class);

        binding.btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CheckBox 상태를 확인하여 필요한 정보를 저장할 리스트를 만듭니다.
                List<String> selectedCheckBoxes = new ArrayList<>();

                if (kb_check.isChecked()) {
                    selectedCheckBoxes.add("KB 체크");
                    kbChecked = true;
                }
                if (nh_check.isChecked()) {
                    selectedCheckBoxes.add("NH 체크");
                    nhChecked = true;
                }
                /*if (nh_finance_check.isChecked()) {
                    selectedCheckBoxes.add("NH 금융 체크");
                }*/

                // 선택된 CheckBox 정보를 다른 곳으로 넘깁니다.
                for (String checkBoxInfo : selectedCheckBoxes) {
                    Log.d("CheckBoxInfo", checkBoxInfo);
                }

                Intent intent = new Intent(getActivity(), PropertyAgreeActivity.class);
                intent.putExtra("kbChecked", kbChecked);
                intent.putExtra("nhChecked", nhChecked);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}