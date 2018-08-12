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

public class Lights61_90Fragment extends Fragment{

    private Button light61;
    private Button light62;
    private Button light63;
    private Button light64;
    private Button light65;
    private Button light66;
    private Button light67;
    private Button light68;
    private Button light69;
    private Button light70;
    private Button light71;
    private Button light72;
    private Button light73;
    private Button light74;
    private Button light75;
    private Button light76;
    private Button light77;
    private Button light78;
    private Button light79;
    private Button light80;
    private Button light81;
    private Button light82;
    private Button light83;
    private Button light84;
    private Button light85;
    private Button light86;
    private Button light87;
    private Button light88;
    private Button light89;
    private Button light90;

    private Button save3;

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

        view = inflater.inflate(R.layout.lights61_90, container, false);

        save3 = view.findViewById(R.id.save3);

        save3.setOnClickListener(new View.OnClickListener() {
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

        light61 = view.findViewById(R.id.light61);

        light61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light61);
            }
        });

        light62 = view.findViewById(R.id.light62);

        light62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light62);
            }
        });

        light63 = view.findViewById(R.id.light63);

        light63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light63);
            }
        });

        light64 = view.findViewById(R.id.light64);

        light64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light64);
            }
        });

        light65 = view.findViewById(R.id.light65);

        light65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light65);
            }
        });

        light66 = view.findViewById(R.id.light66);

        light66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light66);
            }
        });

        light67 = view.findViewById(R.id.light67);

        light67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light67);
            }
        });

        light68 = view.findViewById(R.id.light68);

        light68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light68);
            }
        });

        light69 = view.findViewById(R.id.light69);

        light69.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light69);
            }
        });

        light70 = view.findViewById(R.id.light70);

        light70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light70);
            }
        });

        light71 = view.findViewById(R.id.light71);

        light71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light71);
            }
        });

        light72 = view.findViewById(R.id.light72);

        light72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light72);
            }
        });

        light73 = view.findViewById(R.id.light73);

        light73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light73);
            }
        });

        light74 = view.findViewById(R.id.light74);

        light74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light74);
            }
        });

        light75 = view.findViewById(R.id.light75);

        light75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light75);
            }
        });

        light76 = view.findViewById(R.id.light76);

        light76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light76);
            }
        });

        light77 = view.findViewById(R.id.light77);

        light77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light77);
            }
        });

        light78 = view.findViewById(R.id.light78);

        light78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light78);
            }
        });

        light79 = view.findViewById(R.id.light79);

        light79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light79);
            }
        });

        light80 = view.findViewById(R.id.light80);

        light80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light80);
            }
        });

        light81 = view.findViewById(R.id.light81);

        light81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light81);
            }
        });

        light82 = view.findViewById(R.id.light82);

        light82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light82);
            }
        });

        light83 = view.findViewById(R.id.light83);

        light83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light83);
            }
        });

        light84 = view.findViewById(R.id.light84);

        light84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light84);
            }
        });

        light85 = view.findViewById(R.id.light85);

        light85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light85);
            }
        });

        light86 = view.findViewById(R.id.light86);

        light86.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light86);
            }
        });

        light87 = view.findViewById(R.id.light87);

        light87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light87);
            }
        });

        light88 = view.findViewById(R.id.light88);

        light88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light88);
            }
        });

        light89 = view.findViewById(R.id.light89);

        light89.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light89);
            }
        });

        light90 = view.findViewById(R.id.light90);

        light90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light90);
            }
        });

        return view;
    }
}
