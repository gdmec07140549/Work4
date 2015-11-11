package com.example.administrator.work4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Objects;

public class MyContactsActivity extends Activity {
    private ListView lv;
    private BaseAdapter  lvAdapter;
    private User users[];
    private  int selectItem=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv = (ListView)findViewById(R.id.ListView);
        loadContacts();
    }



    private  void  loadContacts() {
             ContactsTable ct = new ContactsTable(this);
             users = ct.getAllUser();
        lvAdapter = new BaseAdapter() {
            @Override
            public  int  getCount(){
                return  users.length;
            }
            @Override
        public Object getItem(int i){
                return users[i];
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
        public View getView(int i, View view,ViewGroup viewGroup){
                if (view==null){
                    TextView tv = new TextView(MyContactsActivity.this);
                    tv.setTextSize(22);
                    view=tv;
                }
                String mobile = users[i].getMobile()==null?"":users[i].getMobile();
                TextView tv = (TextView)view;
                tv.setText(users[i].getName()+"---"+mobile);
                if (i==selectItem){
                    view.setBackgroundColor(Color.YELLOW);
                }else {
                    view.setBackgroundColor(0);
                }return view;
            }
        };
        lv.setAdapter(lvAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectItem = i;
                lvAdapter.notifyDataSetChanged();
            }

        });
         }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       menu.add(0,1,1,"添加");
        menu.add(0,2,2,"编辑");
        menu.add(0,3,3,"查看信息");
        menu.add(0,4,4,"删除");
        menu.add(0,5,5,"查询");
        menu.add(0,6,6,"导入到手机电话簿");
        menu.add(0,7,7,"退出");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(MyContactsActivity.this, AddContactsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ContactsTable ct = new ContactsTable(this);
        users= ct.getAllUser();
        lvAdapter.notifyDataSetChanged();
    }
}
