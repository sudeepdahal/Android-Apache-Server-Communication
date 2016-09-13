package com.example.sudip.xampp_register;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sudip on 9/8/2016.
 */
public class AdapterClass extends ArrayAdapter<StudentModel> {
    Context context;
    List<StudentModel> studentModels;

    public AdapterClass(Context context, int resource, List<StudentModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.studentModels = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_layout,parent,false);
        TextView tname,tfaculty,taddress,temail,tphone;
        tname = (TextView) view.findViewById(R.id.textView);
        tfaculty = (TextView) view.findViewById(R.id.textView2);
        taddress = (TextView) view.findViewById(R.id.textView3);
        temail = (TextView) view.findViewById(R.id.textView4);
        tphone = (TextView) view.findViewById(R.id.textView5);

        StudentModel studentModel = studentModels.get(position);


        tname.setText(studentModel.getName());

        tfaculty.setText(studentModel.getFaculty());

        taddress.setText(studentModel.getAddress());

        temail.setText(studentModel.getEmail());

        tphone.setText(String.valueOf(studentModel.getPhone()));


        return view;
    }
}
