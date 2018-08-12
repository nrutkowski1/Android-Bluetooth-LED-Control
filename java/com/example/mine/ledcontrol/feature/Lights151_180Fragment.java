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
import android.content.DialogInterface;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_POSITIVE;
import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;


public class Lights151_180Fragment extends Fragment {

    private Button light151;
    private Button light152;
    private Button light153;
    private Button light154;
    private Button light155;
    private Button light156;
    private Button light157;
    private Button light158;
    private Button light159;
    private Button light160;
    private Button light161;
    private Button light162;
    private Button light163;
    private Button light164;
    private Button light165;
    private Button light166;
    private Button light167;
    private Button light168;
    private Button light169;
    private Button light170;
    private Button light171;
    private Button light172;
    private Button light173;
    private Button light174;
    private Button light175;
    private Button light176;
    private Button light177;
    private Button light178;
    private Button light179;
    private Button light180;

    private Button save6;

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

        view = inflater.inflate(R.layout.lights151_180, container, false);

        save6 = view.findViewById(R.id.save6);

        save6.setOnClickListener(new View.OnClickListener() {
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

        light151 = view.findViewById(R.id.light151);

        light151.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light151);
            }
        });

        light152 = view.findViewById(R.id.light152);

        light152.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light152);

            }

        });

        light153 = view.findViewById(R.id.light153);

        light153.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light153);
            }
        });

        light154 = view.findViewById(R.id.light154);

        light154.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light154);
            }
        });

        light155 = view.findViewById(R.id.light155);

        light155.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light155);
            }
        });

        light156 = view.findViewById(R.id.light156);

        light156.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light156);
            }
        });

        light157 = view.findViewById(R.id.light157);

        light157.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light157);
            }
        });

        light158 = view.findViewById(R.id.light158);

        light158.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light158);
            }
        });

        light159 = view.findViewById(R.id.light159);

        light159.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light159);
            }
        });

        light160 = view.findViewById(R.id.light160);

        light160.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light160);
            }
        });

        light161 = view.findViewById(R.id.light161);

        light161.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light161);
            }
        });

        light162 = view.findViewById(R.id.light162);

        light162.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light162);
            }
        });

        light163 = view.findViewById(R.id.light163);

        light163.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light163);
            }
        });

        light164 = view.findViewById(R.id.light164);

        light164.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light164);
            }
        });

        light165 = view.findViewById(R.id.light165);

        light165.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light165);
            }
        });

        light166 = view.findViewById(R.id.light166);

        light166.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light166);
            }
        });

        light167 = view.findViewById(R.id.light167);

        light167.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light167);
            }
        });

        light168 = view.findViewById(R.id.light168);

        light168.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light168);
            }
        });

        light169 = view.findViewById(R.id.light169);

        light169.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light169);
            }
        });

        light170 = view.findViewById(R.id.light170);

        light170.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light170);
            }
        });

        light171 = view.findViewById(R.id.light171);

        light171.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light171);
            }
        });

        light172 = view.findViewById(R.id.light172);

        light172.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light172);
            }
        });

        light173 = view.findViewById(R.id.light173);

        light173.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light173);
            }
        });

        light174 = view.findViewById(R.id.light174);

        light174.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light174);
            }
        });

        light175 = view.findViewById(R.id.light175);

        light175.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light175);
            }
        });

        light176 = view.findViewById(R.id.light176);

        light176.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light176);
            }
        });

        light177 = view.findViewById(R.id.light177);

        light177.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light177);
            }
        });

        light178 = view.findViewById(R.id.light178);

        light178.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light178);
            }
        });

        light179 = view.findViewById(R.id.light179);

        light179.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light179);
            }
        });

        light180 = view.findViewById(R.id.light180);

        light180.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light180);
            }
        });

        return view;
    }
}
