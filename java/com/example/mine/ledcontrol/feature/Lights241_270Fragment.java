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

public class Lights241_270Fragment extends Fragment{

    private Button light241;
    private Button light242;
    private Button light243;
    private Button light244;
    private Button light245;
    private Button light246;
    private Button light247;
    private Button light248;
    private Button light249;
    private Button light250;
    private Button light251;
    private Button light252;
    private Button light253;
    private Button light254;
    private Button light255;
    private Button light256;
    private Button light257;
    private Button light258;
    private Button light259;
    private Button light260;
    private Button light261;
    private Button light262;
    private Button light263;
    private Button light264;
    private Button light265;
    private Button light266;
    private Button light267;
    private Button light268;
    private Button light269;
    private Button light270;

    private Button save9;

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

        view = inflater.inflate(R.layout.lights241_270, container, false);

        save9 = view.findViewById(R.id.save9);

        save9.setOnClickListener(new View.OnClickListener() {
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

        light241 = view.findViewById(R.id.light241);

        light241.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light241);
            }
        });

        light242 = view.findViewById(R.id.light242);

        light242.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light242);
            }

        });

        light243 = view.findViewById(R.id.light243);

        light243.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light243);
            }
        });

        light244 = view.findViewById(R.id.light244);

        light244.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light244);
            }
        });

        light245 = view.findViewById(R.id.light245);

        light245.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light245);
            }
        });

        light246 = view.findViewById(R.id.light246);

        light246.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light246);
            }
        });

        light247 = view.findViewById(R.id.light247);

        light247.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light247);
            }
        });

        light248 = view.findViewById(R.id.light248);

        light248.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light248);
            }
        });

        light249 = view.findViewById(R.id.light249);

        light249.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light249);
            }
        });

        light250 = view.findViewById(R.id.light250);

        light250.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light250);
            }
        });

        light251 = view.findViewById(R.id.light251);

        light251.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light251);
            }
        });

        light252 = view.findViewById(R.id.light252);

        light252.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light252);
            }
        });

        light253 = view.findViewById(R.id.light253);

        light253.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light253);
            }
        });

        light254 = view.findViewById(R.id.light254);

        light254.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light254);
            }
        });

        light255 = view.findViewById(R.id.light255);

        light255.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light255);
            }
        });

        light256 = view.findViewById(R.id.light256);

        light256.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light256);
            }
        });

        light257 = view.findViewById(R.id.light257);

        light257.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light257);
            }
        });

        light258 = view.findViewById(R.id.light258);

        light258.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light258);
            }
        });

        light259 = view.findViewById(R.id.light259);

        light259.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light259);
            }
        });

        light260 = view.findViewById(R.id.light260);

        light260.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light260);
            }
        });

        light261 = view.findViewById(R.id.light261);

        light261.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light261);
            }
        });

        light262 = view.findViewById(R.id.light262);

        light262.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light262);
            }
        });

        light263 = view.findViewById(R.id.light263);

        light263.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light263);
            }
        });

        light264 = view.findViewById(R.id.light264);

        light264.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light264);
            }
        });

        light265 = view.findViewById(R.id.light265);

        light265.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light265);
            }
        });

        light266 = view.findViewById(R.id.light266);

        light266.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light266);
            }
        });

        light267 = view.findViewById(R.id.light267);

        light267.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light267);
            }
        });

        light268 = view.findViewById(R.id.light268);

        light268.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light268);
            }
        });

        light269 = view.findViewById(R.id.light269);

        light269.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light269);
            }
        });

        light270 = view.findViewById(R.id.light270);

        light270.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light270);
            }
        });

        return view;
    }
}
