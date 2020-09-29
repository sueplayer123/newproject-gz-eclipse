package com.example.bottommenu_vp_imgv_tv.fragment;

import com.example.bottommenu_vp_imgv_tv.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DiscoveryFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.fragment_discovery, null);
		return view;
	}
}
