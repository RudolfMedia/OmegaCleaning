package com.rudolfmedia.danrudolf.omegacleaning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class SignUp extends android.app.Fragment {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);
		return rootView;
    }
}
