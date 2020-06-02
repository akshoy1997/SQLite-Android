package com.abc.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnDbOpListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }

            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment).commit();
        }
    }

    @Override
    public void dBOpPerformed(int method) {
        switch (method){
            case 0:
                AddContactFragment addContactFragment = new AddContactFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, addContactFragment).addToBackStack(null).commit();
                break;
            case 1:
                ReadContactsFragment readContactsFragment = new ReadContactsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, readContactsFragment).addToBackStack(null).commit();
                break;
            case 2:
                UpdateContactFragment updateContactFragment = new UpdateContactFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, updateContactFragment).addToBackStack(null).commit();
                break;
            case 3:
                DeleteContactFragment deleteContactFragment = new DeleteContactFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, deleteContactFragment).addToBackStack(null).commit();
                break;
        }
    }
}
