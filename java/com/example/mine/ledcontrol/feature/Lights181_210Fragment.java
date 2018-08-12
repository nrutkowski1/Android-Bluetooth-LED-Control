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

public class Lights181_210Fragment extends Fragment{

    private Button light181;
    private Button light182;
    private Button light183;
    private Button light184;
    private Button light185;
    private Button light186;
    private Button light187;
    private Button light188;
    private Button light189;
    private Button light190;
    private Button light191;
    private Button light192;
    private Button light193;
    private Button light194;
    private Button light195;
    private Button light196;
    private Button light197;
    private Button light198;
    private Button light199;
    private Button light200;
    private Button light201;
    private Button light202;
    private Button light203;
    private Button light204;
    private Button light205;
    private Button light206;
    private Button light207;
    private Button light208;
    private Button light209;
    private Button light210;

    private Button save7;

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

        view = inflater.inflate(R.layout.lights181_210, container, false);

        save7 = view.findViewById(R.id.save7);

        save7.setOnClickListener(new View.OnClickListener() {
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

        light181 = view.findViewById(R.id.light181);

        light181.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light181);
            }
        });

        light182 = view.findViewById(R.id.light182);

        light182.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light182);

            }

        });

        light183 = view.findViewById(R.id.light183);

        light183.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light183);
            }
        });

        light184 = view.findViewById(R.id.light184);

        light184.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light184);
            }
        });

        light185 = view.findViewById(R.id.light185);

        light185.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light185);
            }
        });

        light186 = view.findViewById(R.id.light186);

        light186.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light186);
            }
        });

        light187 = view.findViewById(R.id.light187);

        light187.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light187);
            }
        });

        light188 = view.findViewById(R.id.light188);

        light188.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light188);
            }
        });

        light189 = view.findViewById(R.id.light189);

        light189.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light189);
            }
        });

        light190 = view.findViewById(R.id.light190);

        light190.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light190);
            }
        });

        light191 = view.findViewById(R.id.light191);

        light191.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light191);
            }
        });

        light192 = view.findViewById(R.id.light192);

        light192.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light192);
            }
        });

        light193 = view.findViewById(R.id.light193);

        light193.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light193);
            }
        });

        light194 = view.findViewById(R.id.light194);

        light194.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light194);
            }
        });

        light195 = view.findViewById(R.id.light195);

        light195.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light195);
            }
        });

        light196 = view.findViewById(R.id.light196);

        light196.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light196);
            }
        });

        light197 = view.findViewById(R.id.light197);

        light197.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light197);
            }
        });

        light198 = view.findViewById(R.id.light198);

        light198.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light198);
            }
        });

        light199 = view.findViewById(R.id.light199);

        light199.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light199);
            }
        });

        light200 = view.findViewById(R.id.light200);

        light200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light200);
            }
        });

        light201 = view.findViewById(R.id.light201);

        light201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light201);
            }
        });

        light202 = view.findViewById(R.id.light202);

        light202.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light202);
            }
        });

        light203 = view.findViewById(R.id.light203);

        light203.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light203);
            }
        });

        light204 = view.findViewById(R.id.light204);

        light204.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light204);
            }
        });

        light205 = view.findViewById(R.id.light205);

        light205.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light205);
            }
        });

        light206 = view.findViewById(R.id.light206);

        light206.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light206);
            }
        });

        light207 = view.findViewById(R.id.light207);

        light207.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light207);
            }
        });

        light208 = view.findViewById(R.id.light208);

        light208.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light208);
            }
        });

        light209 = view.findViewById(R.id.light209);

        light209.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light209);
            }
        });

        light210 = view.findViewById(R.id.light210);

        light210.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light210);
            }
        });

        return view;
    }
}
