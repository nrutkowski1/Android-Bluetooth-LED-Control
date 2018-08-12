package com.example.mine.ledcontrol.feature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Tab4CreateColorPattern extends Fragment{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;

    //private Fragment buttons = new SwitchFragmentTab4();

    private View view;

    private FragmentActivity context;

    public static final int POP_BACK_STACK_INCLUSIVE = 0;

    @Override
    public void onAttach(Activity activity){

        context = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    /*
     * remove this tab file and just make the SwitchFragmentTab4 the one in the sections page adapter
     * such that tab4createcolorpattern is eliminated
     *
     * right now we have the following
     *
     * Tab4CreateColorPattern is parent ---> SwitchFragmentTab4 is child
     * SwitchFragmentTab4 is parent ---> Lights1_30Fragment, Lights31_60Fragment.... are children
     *
     * What we want now is the following
     *
     * SwitchFragmentTab4 = Tab$CreateColorPattern is parent ---> Lights1_30Fragment, Lights31_60Fragment.... are children
     */

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){

        view = inflater.inflate(R.layout.tab4_fragment, container, false);

        /*FragmentManager fm = context.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment buttons = new SwitchFragmentTab4();

        if(buttons.isAdded()){

            ft.show(buttons);
        }
        else{

            ft.add(R.id.fragment_container, buttons);
        }

        ft.commit();*/
        Fragment switchFragment = new SwitchFragmentTab4();
        FragmentManager manager = context.getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragment_container, switchFragment);
        ft.commit();

        return view;
    }
}

