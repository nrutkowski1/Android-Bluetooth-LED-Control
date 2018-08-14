package com.example.mine.ledcontrol.feature;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
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

public class SwitchFragmentTab4 extends Fragment {


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

    public Fragment lights1_30 = new Lights1_30Fragment();
    public Fragment lights31_60 = new Lights31_60Fragment();
    public Fragment lights61_90 = new Lights61_90Fragment();
    public Fragment lights91_120 = new Lights91_120Fragment();
    public Fragment lights121_150 = new Lights121_150Fragment();
    public Fragment lights151_180 = new Lights151_180Fragment();
    public Fragment lights181_210 = new Lights181_210Fragment();
    public Fragment lights211_240 = new Lights211_240Fragment();
    public Fragment lights241_270 = new Lights241_270Fragment();
    public Fragment lights271_300 = new Lights271_300Fragment();

    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    private View view;

    private FragmentActivity context;

    public String TAG = "switch";

    @Override
    public void onAttach(Activity activity){

        context = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    /*private void replaceFragment (Fragment fragment){

        String backStateName = fragment.getClass().getName();

        FragmentManager manager = context.getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped){
            //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
        else{

            FragmentTransaction ft = manager.beginTransaction();
            manager.popBackStack(backStateName, POP_BACK_STACK_INCLUSIVE);
            ft.commit();
        }
    }*/

    /*private void searchBackStack(Fragment fragment){

        FragmentManager fm = context.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        for(int i = 0; i < fm.getBackStackEntryCount(); i++ ){

            if(fm.getBackStackEntryAt(i).getClass().getName().equals(fragment.getClass().getName())){

                fm.popBackStack(fm.getBackStackEntryAt(i).getClass().getName(), POP_BACK_STACK_INCLUSIVE);
                ft.commit();
            }
            else{

                ft.replace(R.id.fragment_container, fragment);
                ft.addToBackStack(fragment.getClass().getName());
                ft.commit();
            }
        }
    }*/

    private void switchFrag(Fragment frag, String tag){

        FragmentManager fm = context.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, frag, tag);
        ft.addToBackStack(tag);
        ft.commit();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState){

        view = inflater.inflate(R.layout.switch_fragment_buttons_tab4, container, false);

        btn1 = view.findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFrag(lights1_30, "lights1_30");
            }
        });

        btn2 = view.findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFrag(lights31_60, "lights31_60");
            }
        });

        btn3 = view.findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFrag(lights61_90, "lights61_90");
            }
        });

        btn4 = view.findViewById(R.id.btn4);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFrag(lights91_120, "lights91_120");
            }
        });

        btn5 = view.findViewById(R.id.btn5);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFrag(lights121_150, "lights121_150");
            }
        });

        btn6 = view.findViewById(R.id.btn6);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFrag(lights151_180, "lights151_180");
            }
        });

        btn7 = view.findViewById(R.id.btn7);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFrag(lights181_210, "lights181_210");
            }
        });

        btn8 = view.findViewById(R.id.btn8);

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFrag(lights211_240, "lights211_240");
            }
        });

        btn9 = view.findViewById(R.id.btn9);

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFrag(lights241_270, "lights241_270");
            }
        });

        btn10 = view.findViewById(R.id.btn10);

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switchFrag(lights271_300, "lights271_300");
            }
        });

        return view;
    }
}
