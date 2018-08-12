package com.example.mine.ledcontrol.feature;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothSocket;
import android.nfc.Tag;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.DialogInterface;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;
import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;

public class Lights1_30Fragment extends Fragment {

    private Button light1;
    private Button light2;
    private Button light3;
    private Button light4;
    private Button light5;
    private Button light6;
    private Button light7;
    private Button light8;
    private Button light9;
    private Button light10;
    private Button light11;
    private Button light12;
    private Button light13;
    private Button light14;
    private Button light15;
    private Button light16;
    private Button light17;
    private Button light18;
    private Button light19;
    private Button light20;
    private Button light21;
    private Button light22;
    private Button light23;
    private Button light24;
    private Button light25;
    private Button light26;
    private Button light27;
    private Button light28;
    private Button light29;
    private Button light30;

    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    private Button save1;

    private View view;

    private FragmentActivity context;

    String TAG = "Lights1_30";

    @Override
    public void onAttach(Activity activity){

        context = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    public void createDialog(final Button btn){

        final ColorPicker colorPickerView = new ColorPicker(getContext());

        AlertDialog dialog = new AlertDialog.Builder(getContext()).create();

        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case BUTTON_POSITIVE:
                        int selectedColor = colorPickerView.getColor();
                        btn.setBackgroundColor(selectedColor);

                        int red = red(selectedColor);
                        int green = green(selectedColor);
                        int blue = blue(selectedColor);

                        CharSequence lightNum = btn.getText();

                        BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

                        if(btSocket != null) {

                            try {

                                OutputStream outputStream = btSocket.getOutputStream();

                                if(outputStream != null){

                                    outputStream.write(("zR" + red + "G" + green + "B" + blue + "L" + lightNum + '\n').getBytes());
                                }

                            } catch (IOException e) {

                                e.printStackTrace();
                            }
                        }
                        else{

                            Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case BUTTON_NEGATIVE:
                        dialog.dismiss();
                        break;
                }
            }
        };

        dialog.setButton(BUTTON_POSITIVE, getString(android.R.string.ok), onClickListener);
        dialog.setButton(BUTTON_NEGATIVE, getString(android.R.string.cancel), onClickListener);

        dialog.setView(colorPickerView);

        dialog.show();
    }

    private void searchBackStack(Fragment fragment){

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
    }

    private void replaceFragment (Fragment fragment){

        String backStateName = fragment.getClass().getName();

        FragmentManager manager = context.getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.lights1_30, container, false);

        save1 = view.findViewById(R.id.save1);

        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment switchFragment = new SwitchFragmentTab4();

                FragmentManager fm = context.getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                /*if(switchFragment.isAdded()){

                    ft.show(switchFragment);
                }
                else{

                    ft.add(R.id.fragment_container, switchFragment);
                }*/

                ft.replace(R.id.fragment_container, switchFragment);
                ft.commit();
                //replaceFragment(switchFragment);
                //searchBackStack(switchFragment);
            }
        });

        light1 = view.findViewById(R.id.light1);

        light1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light1);
            }
        });

        light2 = view.findViewById(R.id.light2);

        light2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light2);
            }
        });

        light3 = view.findViewById(R.id.light3);

        light3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light3);
            }
        });

        light4 = view.findViewById(R.id.light4);

        light4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light4);
            }
        });

        light5 = view.findViewById(R.id.light5);

        light5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light5);
            }
        });

        light6 = view.findViewById(R.id.light6);

        light6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light6);
            }
        });

        light7 = view.findViewById(R.id.light7);

        light7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light7);
            }
        });

        light8 = view.findViewById(R.id.light8);

        light8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light8);
            }
        });

        light9 = view.findViewById(R.id.light9);

        light9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light9);
            }
        });

        light10 = view.findViewById(R.id.light10);

        light10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light10);
            }
        });

        light11 = view.findViewById(R.id.light11);

        light11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light11);
            }
        });

        light12 = view.findViewById(R.id.light12);

        light12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light12);
            }
        });

        light13 = view.findViewById(R.id.light13);

        light13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light13);
            }
        });

        light14 = view.findViewById(R.id.light14);

        light14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light14);
            }
        });

        light15 = view.findViewById(R.id.light15);

        light15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light15);
            }
        });

        light16 = view.findViewById(R.id.light16);

        light16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light16);
            }
        });

        light17 = view.findViewById(R.id.light17);

        light17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light17);
            }
        });

        light18 = view.findViewById(R.id.light18);

        light18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light18);
            }
        });

        light19 = view.findViewById(R.id.light19);

        light19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light19);
            }
        });

        light20 = view.findViewById(R.id.light20);

        light20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light20);
            }
        });

        light21 = view.findViewById(R.id.light21);

        light21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light21);
            }
        });

        light22 = view.findViewById(R.id.light22);

        light22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light22);
            }
        });

        light23 = view.findViewById(R.id.light23);

        light23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light23);
            }
        });

        light24 = view.findViewById(R.id.light24);

        light24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light24);
            }
        });

        light25 = view.findViewById(R.id.light25);

        light25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light25);
            }
        });

        light26 = view.findViewById(R.id.light26);

        light26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light26);
            }
        });

        light27 = view.findViewById(R.id.light27);

        light27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light27);
            }
        });

        light28 = view.findViewById(R.id.light28);

        light28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light28);
            }
        });

        light29 = view.findViewById(R.id.light29);

        light29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light29);
            }
        });

        light30 = view.findViewById(R.id.light30);

        light30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light30);
            }
        });

        return view;
    }
}
