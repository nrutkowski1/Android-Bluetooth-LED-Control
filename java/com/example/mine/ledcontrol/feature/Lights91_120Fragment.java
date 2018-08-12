package com.example.mine.ledcontrol.feature;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
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
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;
import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;

public class Lights91_120Fragment extends Fragment{


    private Button light91;
    private Button light92;
    private Button light93;
    private Button light94;
    private Button light95;
    private Button light96;
    private Button light97;
    private Button light98;
    private Button light99;
    private Button light100;
    private Button light101;
    private Button light102;
    private Button light103;
    private Button light104;
    private Button light105;
    private Button light106;
    private Button light107;
    private Button light108;
    private Button light109;
    private Button light110;
    private Button light111;
    private Button light112;
    private Button light113;
    private Button light114;
    private Button light115;
    private Button light116;
    private Button light117;
    private Button light118;
    private Button light119;
    private Button light120;

    private Button save4;

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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.lights91_120, container, false);

        save4 = view.findViewById(R.id.save4);

        save4.setOnClickListener(new View.OnClickListener() {
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

        light91 = view.findViewById(R.id.light91);

        light91.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light91);
            }
        });

        light92 = view.findViewById(R.id.light92);

        light92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light92);
            }
        });

        light93 = view.findViewById(R.id.light93);

        light93.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light93);
            }
        });

        light94 = view.findViewById(R.id.light94);

        light94.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light94);
            }
        });

        light95 = view.findViewById(R.id.light95);

        light95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light95);
            }
        });

        light96 = view.findViewById(R.id.light96);

        light96.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light96);
            }
        });

        light97 = view.findViewById(R.id.light97);

        light97.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light97);
            }
        });

        light98 = view.findViewById(R.id.light98);

        light98.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light98);
            }
        });

        light99 = view.findViewById(R.id.light99);

        light99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light99);
            }
        });

        light100 = view.findViewById(R.id.light100);

        light100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light100);
            }
        });

        light101 = view.findViewById(R.id.light101);

        light101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light101);
            }
        });

        light102 = view.findViewById(R.id.light102);

        light102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light102);
            }
        });

        light103 = view.findViewById(R.id.light103);

        light103.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light103);
            }
        });

        light104 = view.findViewById(R.id.light104);

        light104.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light104);
            }
        });

        light105 = view.findViewById(R.id.light105);

        light105.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light105);
            }
        });

        light106 = view.findViewById(R.id.light106);

        light106.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light106);
            }
        });

        light107 = view.findViewById(R.id.light107);

        light107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light107);
            }
        });

        light108 = view.findViewById(R.id.light108);

        light108.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light108);
            }
        });

        light109 = view.findViewById(R.id.light109);

        light109.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light109);
            }
        });

        light110 = view.findViewById(R.id.light110);

        light110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light110);
            }
        });

        light111 = view.findViewById(R.id.light111);

        light111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light111);
            }
        });

        light112 = view.findViewById(R.id.light112);

        light112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light112);
            }
        });

        light113 = view.findViewById(R.id.light113);

        light113.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light113);
            }
        });

        light114 = view.findViewById(R.id.light114);

        light114.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light114);
            }
        });

        light115 = view.findViewById(R.id.light115);

        light115.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light115);
            }
        });

        light116 = view.findViewById(R.id.light116);

        light116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light116);
            }
        });

        light117 = view.findViewById(R.id.light117);

        light117.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light117);
            }
        });

        light118 = view.findViewById(R.id.light118);

        light118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light118);
            }
        });

        light119 = view.findViewById(R.id.light119);

        light119.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light119);
            }
        });

        light120 = view.findViewById(R.id.light120);

        light120.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light120);
            }
        });

        return view;
    }
}
