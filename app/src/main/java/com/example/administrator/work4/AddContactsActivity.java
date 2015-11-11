package com.example.administrator.work4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class AddContactsActivity extends Activity {
    private EditText name,mobile,qq,danwei,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        name=(EditText)findViewById(R.id.xm1);
        mobile=(EditText)findViewById(R.id.dh1);
        qq=(EditText)findViewById(R.id.qq1);
        danwei=(EditText)findViewById(R.id.dw1);
        address=(EditText)findViewById(R.id.dz1);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_contacts, menu);
        menu.add(0, 1, 1, "保存");
        menu.add(0,2,2,"返回");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case 1:
                if (!name.getText().toString().equals("")){
                    User user=new User();
                    user.setName(name.getText().toString());
                    user.setMobile(mobile.getText().toString());
                    user.setDanwei(danwei.getText().toString());
                    user.setQq(qq.getText().toString());
                    user.setAddress(address.getText().toString());
                    ContactsTable ct=new ContactsTable(this);
                    if ((ct.addData(user))){
                        Toast.makeText(this,"添加成功！",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(this,"添加失败！",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(this,"请先输入姓名！",Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                finish();
                break;
            default:
                break;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
