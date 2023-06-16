package com.example.project2_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link first_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class first_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText nombre, apellido;
    Button btn1, btn2;

    TextView tv1, tv2;


    public first_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment first_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static first_fragment newInstance(String param1, String param2) {
        first_fragment fragment = new first_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View main =  inflater.inflate(R.layout.fragment_first_fragment, container, false);
        nombre = (EditText)main.findViewById(R.id.cfn);
        apellido = (EditText)main.findViewById(R.id.cln);
        btn1 = (Button)main.findViewById(R.id.btn1);
        btn2 = (Button)main.findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombre.getText().toString().equals("") || apellido.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Ingrese el nombre y apellido", Toast.LENGTH_SHORT)
                            .show();
                }else{
                    tv1 = (TextView)getActivity().findViewById(R.id.tv);
                    tv2 = (TextView)getActivity().findViewById(R.id.tv1);
                    tv1.setText(nombre.getText().toString());
                    tv2.setText(apellido.getText().toString());
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre.setText("");
                apellido.setText("");
                tv1 = (TextView)getActivity().findViewById(R.id.tv);
                tv2 = (TextView)getActivity().findViewById(R.id.tv1);
                tv1.setText("");
                tv2.setText("");
            }
        });
        return main;
    }
}