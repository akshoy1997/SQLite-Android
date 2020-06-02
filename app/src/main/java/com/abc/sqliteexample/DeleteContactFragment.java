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
public class DeleteContactFragment extends Fragment {

    private Button BnDelete;
    EditText Delete_Id;

    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_contact, container, false);

        BnDelete = view.findViewById(R.id.bn_delete);
        Delete_Id = view.findViewById(R.id.txt_delete_id);

        BnDelete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });
        return view;
    }

    private void deleteContact(){
        int id = Integer.parseInt(Delete_Id.getText().toString());

        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase db = contactDbHelper.getWritableDatabase();
        contactDbHelper.deleteContact(id, db);
        contactDbHelper.close();

        Toast.makeText(getActivity(),"Contact Removed Successfully..", Toast.LENGTH_SHORT).show();

        Delete_Id.setText("");
    }

}
