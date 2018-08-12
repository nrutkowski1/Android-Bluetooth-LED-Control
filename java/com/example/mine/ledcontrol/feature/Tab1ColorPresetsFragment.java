package com.example.mine.ledcontrol.feature;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothSocket;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import java.io.OutputStream;

import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;

public class Tab1ColorPresetsFragment extends Fragment{

    private Button ColorPreset1;
    private Button ColorPreset2;
    private Button ColorPreset3;
    private Button ColorPreset4;
    private Button ColorPreset5;
    private Button ColorPreset6;
    private Button ColorPreset7;
    private Button ColorPreset8;
    private Button ColorPreset9;
    private Button ColorPreset10;
    private Button ColorPreset11;
    private Button ColorPreset12;
    private Button ColorPreset13;
    private Button ColorPreset14;
    private Button ColorPreset15;
    private Button ColorPreset16;
    private Button ColorPreset17;
    private Button ColorPreset18;
    private Button ColorPreset19;
    private Button ColorPreset20;
    private Button ColorPreset21;
    private Button ColorPreset22;
    private Button ColorPreset23;
    private Button ColorPreset24;
    private Button ColorPreset25;

    public void sendData(Button btn){

        int Color = ((ColorDrawable) btn.getBackground()).getColor();

        int red = red(Color);
        int green = green(Color);
        int blue = blue(Color);

        BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

        if(btSocket != null) {

            try {

                OutputStream outputStream = btSocket.getOutputStream();

                if(outputStream != null){

                    outputStream.write(("xR" + red + "G" + green + "B" + blue + '\n').getBytes());
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        else{

            Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.tab1_fragment, container, false);

        ColorPreset1 = view.findViewById(R.id.ColorPreset1);

        ColorPreset1.setOnClickListener(new View.OnClickListener(){
            @TargetApi(19)
            @Override
            public void onClick(View view) {

                sendData(ColorPreset1);
            }
        });

        ColorPreset2 = view.findViewById(R.id.ColorPreset2);

        ColorPreset2.setOnClickListener(new View.OnClickListener(){
            @TargetApi(19)
            @Override
            public void onClick(View view) {

                sendData(ColorPreset2);
            }
        });

        ColorPreset3 = view.findViewById(R.id.ColorPreset3);

        ColorPreset3.setOnClickListener(new View.OnClickListener(){
            @TargetApi(19)
            @Override
            public void onClick(View view) {

                sendData(ColorPreset3);
            }
        });

        ColorPreset4 = view.findViewById(R.id.ColorPreset4);

        ColorPreset4.setOnClickListener(new View.OnClickListener(){
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset4);
            }
        });

        ColorPreset5 = view.findViewById(R.id.ColorPreset5);

        ColorPreset5.setOnClickListener(new View.OnClickListener(){
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset5);
            }
        });

        ColorPreset6 = view.findViewById(R.id.ColorPreset6);

        ColorPreset6.setOnClickListener(new View.OnClickListener(){
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset6);
            }
        });

        ColorPreset7 = view.findViewById(R.id.ColorPreset7);

        ColorPreset7.setOnClickListener(new View.OnClickListener(){
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset7);
            }
        });

        ColorPreset8 = view.findViewById(R.id.ColorPreset8);

        ColorPreset8.setOnClickListener(new View.OnClickListener(){
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset8);
            }
        });

        ColorPreset9 = view.findViewById(R.id.ColorPreset9);

        ColorPreset9.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset9);
            }
        });

        ColorPreset10 = view.findViewById(R.id.ColorPreset10);

        ColorPreset10.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset10);
            }
        });

        ColorPreset11 = view.findViewById(R.id.ColorPreset11);

        ColorPreset11.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset11);
            }
        });

        ColorPreset12 = view.findViewById(R.id.ColorPreset12);

        ColorPreset12.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset12);
            }
        });

        ColorPreset13 = view.findViewById(R.id.ColorPreset13);

        ColorPreset13.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

               sendData(ColorPreset13);
            }
        });

        ColorPreset14 = view.findViewById(R.id.ColorPreset14);

        ColorPreset14.setOnClickListener(new View.OnClickListener(){
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset14);
            }
        });

        ColorPreset15 = view.findViewById(R.id.ColorPreset15);

        ColorPreset15.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset15);
            }
        });

        ColorPreset16 = view.findViewById(R.id.ColorPreset16);

        ColorPreset16.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset16);
            }
        });

        ColorPreset17 = view.findViewById(R.id.ColorPreset17);

        ColorPreset17.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset17);
            }
        });

        ColorPreset18 = view.findViewById(R.id.ColorPreset18);

        ColorPreset18.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset18);
            }
        });

        ColorPreset19 = view.findViewById(R.id.ColorPreset19);

        ColorPreset19.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset19);
            }
        });

        ColorPreset20 = view.findViewById(R.id.ColorPreset20);

        ColorPreset20.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset20);
            }
        });

        ColorPreset21 = view.findViewById(R.id.ColorPreset21);

        ColorPreset21.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset21);
            }
        });

        ColorPreset22 = view.findViewById(R.id.ColorPreset22);

        ColorPreset22.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset22);
            }
        });

        ColorPreset23 = view.findViewById(R.id.ColorPreset23);

        ColorPreset23.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset23);
            }
        });

        ColorPreset24 = view.findViewById(R.id.ColorPreset24);

        ColorPreset24.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset24);
            }
        });

        ColorPreset25 = view.findViewById(R.id.ColorPreset25);

        ColorPreset25.setOnClickListener(new View.OnClickListener() {
            @TargetApi(19)
            @Override
            public void onClick(View view){

                sendData(ColorPreset25);
            }
        });

        return view;
    }
}
