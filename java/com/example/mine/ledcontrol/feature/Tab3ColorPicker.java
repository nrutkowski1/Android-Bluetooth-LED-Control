package com.example.mine.ledcontrol.feature;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.io.IOException;
import java.io.OutputStream;
import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;

public class Tab3ColorPicker extends Fragment{

    private ColorPicker colorPickerView;

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.tab3_fragment, container, false);

            colorPickerView = view.findViewById(R.id.colorPicker);

            colorPickerView.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if (event.getAction() == (MotionEvent.ACTION_UP)) {

                        int Color = colorPickerView.getColor();

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
                        return true;

                    } else {

                        return false;
                    }
                }
            });

        return view;
    }
}