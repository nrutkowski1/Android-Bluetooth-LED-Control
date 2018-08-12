package com.example.mine.ledcontrol.feature;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothSocket;
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

public class Lights271_300Fragment extends Fragment{

    private Button light271;
    private Button light272;
    private Button light273;
    private Button light274;
    private Button light275;
    private Button light276;
    private Button light277;
    private Button light278;
    private Button light279;
    private Button light280;
    private Button light281;
    private Button light282;
    private Button light283;
    private Button light284;
    private Button light285;
    private Button light286;
    private Button light287;
    private Button light288;
    private Button light289;
    private Button light290;
    private Button light291;
    private Button light292;
    private Button light293;
    private Button light294;
    private Button light295;
    private Button light296;
    private Button light297;
    private Button light298;
    private Button light299;
    private Button light300;

    private Button save10;

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

        view = inflater.inflate(R.layout.lights271_300, container, false);

        save10 = view.findViewById(R.id.save10);

        save10.setOnClickListener(new View.OnClickListener() {
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

        light271 = view.findViewById(R.id.light271);

        light271.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light271);
            }
        });

        light272 = view.findViewById(R.id.light272);

        light272.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light272);
            }

        });

        light273 = view.findViewById(R.id.light273);

        light273.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light273);
            }
        });

        light274 = view.findViewById(R.id.light274);

        light274.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light274);
            }
        });

        light275 = view.findViewById(R.id.light275);

        light275.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light275);
            }
        });

        light276 = view.findViewById(R.id.light276);

        light276.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light276);
            }
        });

        light277 = view.findViewById(R.id.light277);

        light277.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light277);
            }
        });

        light278 = view.findViewById(R.id.light278);

        light278.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light278);
            }
        });

        light279 = view.findViewById(R.id.light279);

        light279.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light279);
            }
        });

        light280 = view.findViewById(R.id.light280);

        light280.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light280);
            }
        });

        light281 = view.findViewById(R.id.light281);

        light281.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light281);
            }
        });

        light282 = view.findViewById(R.id.light282);

        light282.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light282);
            }
        });

        light283 = view.findViewById(R.id.light283);

        light283.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light283);
            }
        });

        light284 = view.findViewById(R.id.light284);

        light284.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light284);
            }
        });

        light285 = view.findViewById(R.id.light285);

        light285.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light285);
            }
        });

        light286 = view.findViewById(R.id.light286);

        light286.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light286);
            }
        });

        light287 = view.findViewById(R.id.light287);

        light287.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light287);
            }
        });

        light288 = view.findViewById(R.id.light288);

        light288.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light288);
            }
        });

        light289 = view.findViewById(R.id.light289);

        light289.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light289);
            }
        });

        light290 = view.findViewById(R.id.light290);

        light290.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light290);
            }
        });

        light291 = view.findViewById(R.id.light291);

        light291.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light291);
            }
        });

        light292 = view.findViewById(R.id.light292);

        light292.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light292);
            }
        });

        light293 = view.findViewById(R.id.light293);

        light293.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light293);
            }
        });

        light294 = view.findViewById(R.id.light294);

        light294.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light294);
            }
        });

        light295 = view.findViewById(R.id.light295);

        light295.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light295);
            }
        });

        light296 = view.findViewById(R.id.light296);

        light296.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light296);
            }
        });

        light297 = view.findViewById(R.id.light297);

        light297.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light297);
            }
        });

        light298 = view.findViewById(R.id.light298);

        light298.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light298);
            }
        });

        light299 = view.findViewById(R.id.light299);

        light299.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light299);
            }
        });

        light300 = view.findViewById(R.id.light300);

        light300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDialog(light300);
            }
        });

        return view;
    }
}
