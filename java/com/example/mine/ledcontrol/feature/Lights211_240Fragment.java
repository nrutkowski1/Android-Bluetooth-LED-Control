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

public class Lights211_240Fragment extends Fragment{

    private Button light211;
    private Button light212;
    private Button light213;
    private Button light214;
    private Button light215;
    private Button light216;
    private Button light217;
    private Button light218;
    private Button light219;
    private Button light220;
    private Button light221;
    private Button light222;
    private Button light223;
    private Button light224;
    private Button light225;
    private Button light226;
    private Button light227;
    private Button light228;
    private Button light229;
    private Button light230;
    private Button light231;
    private Button light232;
    private Button light233;
    private Button light234;
    private Button light235;
    private Button light236;
    private Button light237;
    private Button light238;
    private Button light239;
    private Button light240;

    private Button save8;

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

        view = inflater.inflate(R.layout.lights211_240, container, false);

        save8 = view.findViewById(R.id.save8);

        save8.setOnClickListener(new View.OnClickListener() {
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

        light211 = view.findViewById(R.id.light211);

        light211.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light211);
            }
        });

        light212 = view.findViewById(R.id.light212);

        light212.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light212);

            }

        });

        light213 = view.findViewById(R.id.light213);

        light213.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light213);
            }
        });

        light214 = view.findViewById(R.id.light214);

        light214.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light214);
            }
        });

        light215 = view.findViewById(R.id.light215);

        light215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light215);
            }
        });

        light216 = view.findViewById(R.id.light216);

        light216.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light216);
            }
        });

        light217 = view.findViewById(R.id.light217);

        light217.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light217);
            }
        });

        light218 = view.findViewById(R.id.light218);

        light218.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light218);
            }
        });

        light219 = view.findViewById(R.id.light219);

        light219.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light219);
            }
        });

        light220 = view.findViewById(R.id.light220);

        light220.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light220);
            }
        });

        light221 = view.findViewById(R.id.light221);

        light221.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light221);
            }
        });

        light222 = view.findViewById(R.id.light222);

        light222.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light222);
            }
        });

        light223 = view.findViewById(R.id.light223);

        light223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light223);
            }
        });

        light224 = view.findViewById(R.id.light224);

        light224.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light224);
            }
        });

        light225 = view.findViewById(R.id.light225);

        light225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light225);
            }
        });

        light226 = view.findViewById(R.id.light226);

        light226.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light226);
            }
        });

        light227 = view.findViewById(R.id.light227);

        light227.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light227);
            }
        });

        light228 = view.findViewById(R.id.light228);

        light228.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light228);
            }
        });

        light229 = view.findViewById(R.id.light229);

        light229.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light229);
            }
        });

        light230 = view.findViewById(R.id.light230);

        light230.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light230);
            }
        });

        light231 = view.findViewById(R.id.light231);

        light231.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light231);
            }
        });

        light232 = view.findViewById(R.id.light232);

        light232.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light232);
            }
        });

        light233 = view.findViewById(R.id.light233);

        light233.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light233);
            }
        });

        light234 = view.findViewById(R.id.light234);

        light234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light234);
            }
        });

        light235 = view.findViewById(R.id.light235);

        light235.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light235);
            }
        });

        light236 = view.findViewById(R.id.light236);

        light236.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light236);
            }
        });

        light237 = view.findViewById(R.id.light237);

        light237.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light237);
            }
        });

        light238 = view.findViewById(R.id.light238);

        light238.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light238);
            }
        });

        light239 = view.findViewById(R.id.light239);

        light239.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light239);
            }
        });

        light240 = view.findViewById(R.id.light240);

        light240.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light240);
            }
        });

        return view;
    }
}
