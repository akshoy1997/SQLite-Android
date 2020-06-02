package com.abc.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateContactFragment extends Fragment {

    private Button BnUpdate;
    EditText Update_Id, Update_Name, Update_Email;

    public UpdateContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_contact, container, false);

        BnUpdate = view.findViewById(R.id.bn_update_save);
        Update_Id = view.findViewById(R.id.txt_update_id);
        Update_Name = view.findViewById(R.id.txt_update_name);
        Update_Email = view.findViewById(R.id.txt_update_email);

        BnUpdate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                updateContact();
            }
        });
        return view;
    }

    private void updateContact(){
        int id = Integer.parseInt(Update_Id.getText().toString());
        String name = Update_Name.getText().toString();
        String email = Update_Email.getText().toString();

        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase db = contactDbHelper.getWritableDatabase();
        contactDbHelper.updateContact(id, name, email, db);
        contactDbHelper.close();

        Toast.makeText(getActivity(),"Contact Updated..", Toast.LENGTH_SHORT).show();

        Update_Id.setText("");
        Update_Name.setText("");
        Update_Email.setText("");
    }

}