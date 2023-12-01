package com.example.message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.message.Models.MsgModel;
import com.example.message.databinding.ActivityDashboardBinding;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    ActivityDashboardBinding binding;
    ArrayList<MsgModel> datalist = new ArrayList<> ();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_dashboard);
        binding = ActivityDashboardBinding.inflate (getLayoutInflater ());
        setContentView (binding.getRoot ());
        binding.sendMsg.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                String input = binding.messageBox.getText ().toString ().trim ();
                if(!input.equals ("")){
                    MsgModel model = new MsgModel("1",input,"send");
                    datalist.add(model);
                    MyAdapter adapter = new MyAdapter(Dashboard.this,datalist);
                    binding.listView.setAdapter(adapter);
                    binding.messageBox.setText(null);
                }
            }
        });

    }

    public class MyAdapter extends BaseAdapter{

        Context context;
        ArrayList<MsgModel> data;

        public MyAdapter(Context context, ArrayList<MsgModel> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size ();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.msg_listview,null);
            TextView reciverMsg, sendMsg;
            reciverMsg = itemView.findViewById(R.id.reciverMsg);
            sendMsg = itemView.findViewById(R.id.sendMsg);
            if(data.get(i).getType().equals("send")){
                sendMsg.setVisibility(View.VISIBLE);
                reciverMsg.setVisibility(View.GONE);
                sendMsg.setText(data.get(i).getMessage());
            } else if(data.get(i).getType().equals("recieve")){
                sendMsg.setVisibility(View.GONE);
                reciverMsg.setVisibility(View.VISIBLE);
                reciverMsg.setText(data.get(i).getMessage());
            }
            return itemView;
        }
    }
}