package com.example.administrator.work4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class ContactsMessageActivity extends Activity {
    private TextView name2,mobile2,company2,qq2,address2;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        name2=(TextView)findViewById(R.id.xm4);
        mobile2=(TextView)findViewById(R.id.dh4);
        company2=(TextView)findViewById(R.id.dw4);
        qq2=(TextView)findViewById(R.id.qq4);
        address2=(TextView)findViewById(R.id.dz4);
        Bundle localBundle=getIntent().getExtras();
        int id=localBundle.getInt("user_ID");
        ContactsTable ct=new ContactsTable(this);
        user=ct.getUserByID(id);
        name2.setText("姓名："+user.getName());
        mobile2.setText("电话："+user.getMobile());
        qq2.setText("QQ："+user.getQq());
        company2.setText("单位："+user.getDanwei());
        address2.setText("地址："+user.getAddress());

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
        menu.add(Menu.NONE,1,Menu.NONE,"返回");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
