package com.example.dongja94.sampleslidingmenu;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    public static final int MENU_MAIN = 0;
    public static final int MENU_FIRST = 1;
    public static final int MENU_SECOND = 2;

    public interface OnMenuItemSelectListener {
        public void onMenuItemSelected(int menuId);
    }

    OnMenuItemSelectListener mCallback;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        View menu = view.findViewById(R.id.text_main);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback != null) {
                    mCallback.onMenuItemSelected(MENU_MAIN);
                }
            }
        });

        menu = view.findViewById(R.id.text_first);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback != null) {
                    mCallback.onMenuItemSelected(MENU_FIRST);
                }
            }
        });

        menu = view.findViewById(R.id.text_second);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback != null) {
                    mCallback.onMenuItemSelected(MENU_SECOND);
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMenuItemSelectListener) {
            mCallback = (OnMenuItemSelectListener)context;
        }
    }
}
