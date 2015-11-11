package com.example.administrator.work4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class UpdateContactsActivity extends Activity {
    private EditText name,mobile,qq,danwei,address;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contacts);
        name=(EditText)findViewById(R.id.xm1);
        mobile=(EditText)findViewById(R.id.dh1);
        qq=(EditText)findViewById(R.id.qq1);
        danwei=(EditText)findViewById(R.id.dw1);
        address=(EditText)findViewById(R.id.dz1);
        Bundle localBundle=getIntent().getExtras();
        int id=localBundle.getInt("user_ID");
        ContactsTable ct=new ContactsTable(this);
        user=ct.getUserByID(id);
        name.setText(user.getName());
        mobile.setText(user.getMobile());
        qq.setText(user.getQq());
        danwei.setText(user.getDanwei());
        address.setText(user.getAddress());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1:
                if (!name.getText().toString().equals("")){
                    user.setName(name.getText().toString());
                    user.setMobile(mobile.getText().toString());
                    user.setDanwei(danwei.getText().toString());
                    user.setQq(qq.getText().toString());
                    user.setAddress(address.getText().toString());
                    ContactsTable ct=new ContactsTable(UpdateContactsActivity.this);
                    if(ct.updateUser(user)){
                        Toast.makeText(UpdateContactsActivity.this, "修改成功！", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(UpdateContactsActivity.this,"修改失败！",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(UpdateContactsActivity.this,"数据不能为空！",Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}