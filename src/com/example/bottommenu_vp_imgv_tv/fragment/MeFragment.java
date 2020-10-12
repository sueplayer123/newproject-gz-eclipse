package com.example.bottommenu_vp_imgv_tv.fragment;

import java.io.FileInputStream;

import com.example.bottommenu_vp_imgv_tv.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MeFragment extends Fragment {
	private TextView textV1;
	public static final String FILE_NAME3 = "file.txt";

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.fragment_me, null);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		textV1 = (TextView) getActivity().findViewById(R.id.textV1);

		textV1.setText(read());
	}

	private String read() {
		try {
			FileInputStream fis = getActivity().openFileInput(FILE_NAME3);
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			StringBuilder sb = new StringBuilder("");
			while ((hasRead = fis.read(buffer)) > 0) {
				sb.append(new String(buffer, 0, hasRead));
			}
			return sb.toString();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}