package com.example.mine.ledcontrol.feature;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothSocket;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.io.IOException;
import java.io.OutputStream;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;
import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;
import static android.support.v4.os.LocaleListCompat.create;


public class Lights121_150Fragment extends Fragment{

    private Button light121;
    private Button light122;
    private Button light123;
    private Button light124;
    private Button light125;
    private Button light126;
    private Button light127;
    private Button light128;
    private Button light129;
    private Button light130;
    private Button light131;
    private Button light132;
    private Button light133;
    private Button light134;
    private Button light135;
    private Button light136;
    private Button light137;
    private Button light138;
    private Button light139;
    private Button light140;
    private Button light141;
    private Button light142;
    private Button light143;
    private Button light144;
    private Button light145;
    private Button light146;
    private Button light147;
    private Button light148;
    private Button light149;
    private Button light150;

    private Button save5;

    private View view;

    private FragmentActivity context;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.lights121_150, container, false);

        save5 = view.findViewById(R.id.save5);

        save5.setOnClickListener(new View.OnClickListener() {
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
            }
        });

        light121 = view.findViewById(R.id.light121);

        light121.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light121);
            }
        });

        light122 = view.findViewById(R.id.light122);

        light122.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light122);
            }
        });

        light123 = view.findViewById(R.id.light123);

        light123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light123);
            }
        });

        light124 = view.findViewById(R.id.light124);

        light124.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light124);
            }
        });

        light125 = view.findViewById(R.id.light125);

        light125.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light125);
            }
        });

        light126 = view.findViewById(R.id.light126);

        light126.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light126);
            }
        });

        light127 = view.findViewById(R.id.light127);

        light127.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light127);
            }
        });

        light128 = view.findViewById(R.id.light128);

        light128.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light128);
            }
        });

        light129 = view.findViewById(R.id.light129);

        light129.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light129);
            }
        });

        light130 = view.findViewById(R.id.light130);

        light130.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light130);
            }
        });

        light131 = view.findViewById(R.id.light131);

        light131.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light131);
            }
        });

        light132 = view.findViewById(R.id.light132);

        light132.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light132);
            }
        });

        light133 = view.findViewById(R.id.light133);

        light133.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light133);
            }
        });

        light134 = view.findViewById(R.id.light134);

        light134.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light134);
            }
        });

        light135 = view.findViewById(R.id.light135);

        light135.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light135);
            }
        });

        light136 = view.findViewById(R.id.light136);

        light136.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light136);
            }
        });

        light137 = view.findViewById(R.id.light137);

        light137.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light137);
            }
        });

        light138 = view.findViewById(R.id.light138);

        light138.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light138);
            }
        });

        light139 = view.findViewById(R.id.light139);

        light139.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light139);
            }
        });

        light140 = view.findViewById(R.id.light140);

        light140.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light140);
            }
        });

        light141 = view.findViewById(R.id.light141);

        light141.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light141);
            }
        });

        light142 = view.findViewById(R.id.light142);

        light142.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light142);
            }
        });

        light143 = view.findViewById(R.id.light143);

        light143.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light143);
            }
        });

        light144 = view.findViewById(R.id.light144);

        light144.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light144);
            }
        });

        light145 = view.findViewById(R.id.light145);

        light145.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light145);
            }
        });

        light146 = view.findViewById(R.id.light146);

        light146.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light146);
            }
        });

        light147 = view.findViewById(R.id.light147);

        light147.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light147);
            }
        });

        light148 = view.findViewById(R.id.light148);

        light148.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light148);
            }
        });

        light149 = view.findViewById(R.id.light149);

        light149.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light149);
            }
        });

        light150 = view.findViewById(R.id.light150);

        light150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light150);
            }
        });

        return view;
    }
}
