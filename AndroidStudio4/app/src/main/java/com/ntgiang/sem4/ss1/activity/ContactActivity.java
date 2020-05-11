package com.ntgiang.sem4.ss1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ntgiang.sem4.ss1.adapter.ContactAdapter;
import com.ntgiang.sem4.ss1.R;
import com.ntgiang.sem4.ss1.model.ContactModel;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        
        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(listContacts, this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel contactModel = listContacts.get(position);
                Toast.makeText(ContactActivity.this, contactModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        ContactModel contactModel = new ContactModel("Nguyen Bao A", "0123456789", R.drawable.skaarf);
        listContacts.add(contactModel);
        listContacts.add(new ContactModel("Nguyen Bao A", "0123456789", R.drawable.skaarf));
        listContacts.add(new ContactModel("Nguyen Van A", "011278389", R.drawable.avatar1));
        listContacts.add(new ContactModel("Nguyen Truong A", "1209910489", R.drawable.avatar3));
        listContacts.add(new ContactModel("Truong Nam A", "1209910489", R.drawable.avatar3));
        listContacts.add(new ContactModel("Nguyen Bao C", "10928390", R.drawable.webber));
        listContacts.add(new ContactModel("Nguyen Long A", "2309490120", R.drawable.avatar1));
        listContacts.add(new ContactModel("Nguyen Thanh A", "010923891", R.drawable.avatar3));
        listContacts.add(new ContactModel("Tran Bao C", "01823798", R.drawable.webber));
        listContacts.add(new ContactModel("Loi Chi C", "01823798", R.drawable.webber));
        listContacts.add(new ContactModel("Nguyen Bao B", "018293879", R.drawable.skaarf));
        listContacts.add(new ContactModel("Dang Bao D", "081293789274", R.drawable.avatar3));
        listContacts.add(new ContactModel("Nguyen Bao E", "018923792847", R.drawable.avatar1));
        listContacts.add(new ContactModel("Tran Bao E", "018923792847", R.drawable.skaarf));
        listContacts.add(new ContactModel("Nguyen Thanh F", "0812938798", R.drawable.webber));
    }
}
