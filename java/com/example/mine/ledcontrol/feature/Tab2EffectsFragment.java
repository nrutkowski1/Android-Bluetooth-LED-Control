package com.example.mine.ledcontrol.feature;

import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;

public class Tab2EffectsFragment extends Fragment {

    private Switch switch1;
    private Switch switch2;
    private Switch switch3;
    private Switch switch4;
    private Switch switch5;
    private Switch switch6;
    private Switch switch7;
    private Switch switch8;
    private Switch switch9;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.tab2_fragment, container, false);

        switch1 = view.findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

                if (isChecked) {

                    switch2.setChecked(false);
                    switch3.setChecked(false);
                    switch4.setChecked(false);
                    switch5.setChecked(false);
                    switch6.setChecked(false);
                    switch7.setChecked(false);
                    switch8.setChecked(false);
                    switch9.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if(outputStream != null) {

                                outputStream.write(("ySWITCH1" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else {

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
                if(!isChecked){

                    switch1.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if (outputStream != null) {

                                outputStream.write(("ySWITCH0" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        switch2 = view.findViewById(R.id.switch2);

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

                if(isChecked) {

                    switch1.setChecked(false);
                    switch3.setChecked(false);
                    switch4.setChecked(false);
                    switch5.setChecked(false);
                    switch6.setChecked(false);
                    switch7.setChecked(false);
                    switch8.setChecked(false);
                    switch9.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if(outputStream != null){

                                outputStream.write(("ySWITCH2" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
                if(!isChecked){

                    switch2.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if (outputStream != null) {

                                outputStream.write(("ySWITCH0" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        switch3 = view.findViewById(R.id.switch3);

        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

                if (isChecked) {

                    switch1.setChecked(false);
                    switch2.setChecked(false);
                    switch4.setChecked(false);
                    switch5.setChecked(false);
                    switch6.setChecked(false);
                    switch7.setChecked(false);
                    switch8.setChecked(false);
                    switch9.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if (outputStream != null) {

                                outputStream.write(("ySWITCH3" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    } else {

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
                if (!isChecked) {

                    switch3.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if (outputStream != null) {

                                outputStream.write(("ySWITCH0" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    } else {

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        switch4 = view.findViewById(R.id.switch4);

        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

                if(isChecked) {

                    switch1.setChecked(false);
                    switch2.setChecked(false);
                    switch3.setChecked(false);
                    switch5.setChecked(false);
                    switch6.setChecked(false);
                    switch7.setChecked(false);
                    switch8.setChecked(false);
                    switch9.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if(outputStream != null){

                                outputStream.write(("ySWITCH4" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
                if(!isChecked){

                    switch4.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if (outputStream != null) {

                                outputStream.write(("ySWITCH0" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        switch5 = view.findViewById(R.id.switch5);

        switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

                if(isChecked) {

                    switch1.setChecked(false);
                    switch2.setChecked(false);
                    switch3.setChecked(false);
                    switch4.setChecked(false);
                    switch6.setChecked(false);
                    switch7.setChecked(false);
                    switch8.setChecked(false);
                    switch9.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if(outputStream != null){

                                outputStream.write(("ySWITCH5" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
                if(!isChecked){

                    switch5.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if (outputStream != null) {

                                outputStream.write(("ySWITCH0" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        switch6 = view.findViewById(R.id.switch6);

        switch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

                if(isChecked) {

                    switch1.setChecked(false);
                    switch2.setChecked(false);
                    switch3.setChecked(false);
                    switch4.setChecked(false);
                    switch5.setChecked(false);
                    switch7.setChecked(false);
                    switch8.setChecked(false);
                    switch9.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if(outputStream != null){

                                outputStream.write(("ySWITCH6" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
                if(!isChecked){

                    switch6.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if (outputStream != null) {

                                outputStream.write(("ySWITCH0" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        switch7 = view.findViewById(R.id.switch7);

        switch7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

                if(isChecked) {

                    switch1.setChecked(false);
                    switch2.setChecked(false);
                    switch3.setChecked(false);
                    switch4.setChecked(false);
                    switch5.setChecked(false);
                    switch6.setChecked(false);
                    switch8.setChecked(false);
                    switch9.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if(outputStream != null){

                                outputStream.write(("ySWITCH7" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
                if(!isChecked){

                    switch7.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if (outputStream != null) {

                                outputStream.write(("ySWITCH0" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        switch8 = view.findViewById(R.id.switch8);

        switch8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

                if(isChecked) {

                    switch1.setChecked(false);
                    switch2.setChecked(false);
                    switch3.setChecked(false);
                    switch4.setChecked(false);
                    switch5.setChecked(false);
                    switch6.setChecked(false);
                    switch7.setChecked(false);
                    switch9.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if(outputStream != null){

                                outputStream.write(("ySWITCH8" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
                if(!isChecked){

                    switch8.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if (outputStream != null) {

                                outputStream.write(("ySWITCH0" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        switch9 = view.findViewById(R.id.switch9);

        switch9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                BluetoothSocket btSocket = ((MainActivity) getActivity()).getBtSocket();

                if (isChecked) {

                    switch1.setChecked(false);
                    switch2.setChecked(false);
                    switch3.setChecked(false);
                    switch4.setChecked(false);
                    switch5.setChecked(false);
                    switch6.setChecked(false);
                    switch7.setChecked(false);
                    switch8.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if(outputStream != null){

                                outputStream.write(("ySWITCH9" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
                if(!isChecked){

                    switch9.setChecked(false);

                    if (btSocket != null) {

                        try {

                            OutputStream outputStream = btSocket.getOutputStream();

                            if (outputStream != null) {

                                outputStream.write(("ySWITCH0" + '\n').getBytes());
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    else{

                        Toast.makeText(getActivity(), "Not Connected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }
}