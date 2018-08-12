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

public class Lights31_60Fragment extends Fragment {

    private Button light31;
    private Button light32;
    private Button light33;
    private Button light34;
    private Button light35;
    private Button light36;
    private Button light37;
    private Button light38;
    private Button light39;
    private Button light40;
    private Button light41;
    private Button light42;
    private Button light43;
    private Button light44;
    private Button light45;
    private Button light46;
    private Button light47;
    private Button light48;
    private Button light49;
    private Button light50;
    private Button light51;
    private Button light52;
    private Button light53;
    private Button light54;
    private Button light55;
    private Button light56;
    private Button light57;
    private Button light58;
    private Button light59;
    private Button light60;

    private Button save2;

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

        view = inflater.inflate(R.layout.lights31_60, container, false);

        save2 = view.findViewById(R.id.save2);

        save2.setOnClickListener(new View.OnClickListener() {
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

        light31 = view.findViewById(R.id.light31);

        light31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light31);
            }
        });

        light32 = view.findViewById(R.id.light32);

        light32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light32);
            }
        });

        light33 = view.findViewById(R.id.light33);

        light33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light33);
            }
        });

        light34 = view.findViewById(R.id.light34);

        light34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light34);
            }
        });

        light35 = view.findViewById(R.id.light35);

        light35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light35);
            }
        });

        light36 = view.findViewById(R.id.light36);

        light36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light36);
            }
        });

        light37 = view.findViewById(R.id.light37);

        light37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light37);
            }
        });

        light38 = view.findViewById(R.id.light38);

        light38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light38);
            }
        });

        light39 = view.findViewById(R.id.light39);

        light39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light39);
            }
        });

        light40 = view.findViewById(R.id.light40);

        light40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light40);
            }
        });

        light41 = view.findViewById(R.id.light41);

        light41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light41);
            }
        });

        light42 = view.findViewById(R.id.light42);

        light42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light42);
            }
        });

        light43 = view.findViewById(R.id.light43);

        light43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light43);
            }
        });

        light44 = view.findViewById(R.id.light44);

        light44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light44);
            }
        });

        light45 = view.findViewById(R.id.light45);

        light45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light45);
            }
        });

        light46 = view.findViewById(R.id.light46);

        light46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light46);
            }
        });

        light47 = view.findViewById(R.id.light47);

        light47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light47);
            }
        });

        light48 = view.findViewById(R.id.light48);

        light48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light48);
            }
        });

        light49 = view.findViewById(R.id.light49);

        light49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light49);
            }
        });

        light50 = view.findViewById(R.id.light50);

        light50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light50);
            }
        });

        light51 = view.findViewById(R.id.light51);

        light51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light51);
            }
        });

        light52 = view.findViewById(R.id.light52);

        light52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light52);
            }
        });

        light53 = view.findViewById(R.id.light53);

        light53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light53);
            }
        });

        light54 = view.findViewById(R.id.light54);

        light54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light54);
            }
        });

        light55 = view.findViewById(R.id.light55);

        light55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light55);
            }
        });

        light56 = view.findViewById(R.id.light56);

        light56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light56);
            }
        });

        light57 = view.findViewById(R.id.light57);

        light57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light57);
            }
        });

        light58 = view.findViewById(R.id.light58);

        light58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light58);
            }
        });

        light59 = view.findViewById(R.id.light59);

        light59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light59);
            }
        });

        light60 = view.findViewById(R.id.light60);

        light60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light60);
            }
        });

        return view;
    }
}
