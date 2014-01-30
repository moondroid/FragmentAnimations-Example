package it.moondroid.example.fragmentanimations;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements OnClickListener {

    public static interface OnActionListener {
        public void onButtonClick(View v);
    }

    protected OnActionListener mBaseFragmentListener;

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        try {
            mBaseFragmentListener = (OnActionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    "containing activity must implement OnActionListener");
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.home_fragment,
                container, false);

        Button b1 = (Button)v.findViewById(R.id.button1);
        b1.setOnClickListener(this);

        return v;

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (mBaseFragmentListener != null) {
            mBaseFragmentListener.onButtonClick(v);
        }
    }




}
