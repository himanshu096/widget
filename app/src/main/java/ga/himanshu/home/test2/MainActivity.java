package ga.himanshu.home.test2;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




import java.util.ArrayList;
import java.util.List;

import ga.himanshu.home.test2.model.Datum;
import ga.himanshu.home.test2.model.Message;
import ga.himanshu.home.test2.services.Callback;
import ga.himanshu.home.test2.services.MyNoticeService;

import static android.view.Gravity.CENTER;
import static android.view.ViewGroup.LayoutParams;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class MainActivity extends AppCompatActivity {

    private List<Datum> mNoticeList;
    public String branch;
    private CustomAdapter mAdapter;
    Button seconda;
    RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seconda = (Button) findViewById(R.id.button);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        seconda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


//        mNoticeList = new ArrayList<Datum>();
//        mLayoutManager = new LinearLayoutManager(MainActivity.this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.hasFixedSize();
//        branch="";
//        mAdapter = new CustomAdapter(branch,MainActivity.this, mNoticeList);
//        mRecyclerView.setAdapter(mAdapter);
//
//


        String times= String.valueOf(System.currentTimeMillis());


        MyNoticeService service = new MyNoticeService();
        service.listNotices(times,new Callback<Message>() {
            @Override
            public void onSuccess(Message response) {

//                mNoticeList.addAll(response.getData());
//                mAdapter.notifyDataSetChanged();
//
//                String k = response.getData().get(0).getNotice();
//
                Log.d("codeo", "agya");


            }

            @Override
            public void onFailure(Error error) {

            }
        });
    }




    //View Holder Class
    public class CustomViewHolder extends RecyclerView.ViewHolder {


        TextView mTextView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.view_holder_custom_text_view);

        }


    }


    //Adapter Class
    public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {



        private List<Datum> dataList;
        private LayoutInflater inflater;

        public CustomAdapter(String branch, Context context, List<Datum> dataList) {
            inflater = LayoutInflater.from(context);
            this.dataList = dataList;

        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CustomViewHolder(inflater.inflate(R.layout.view_holder_custom, parent, false));
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            holder.itemView.setVisibility(View.INVISIBLE);
            if (dataList.get(position).getBranch().contains(branch)==true) {
                holder.mTextView.setText(dataList.get(position).getBranch() + "   " + dataList.get(position).getNotice());
                holder.itemView.setVisibility(View.VISIBLE);
            }


//        if(position > previousPosition){ // We are scrolling DOWN
//
//            Animationutil.animate(holder, true);
//
//        }else{ // We are scrolling UP
//
//            Animationutil.animate(holder, false);
//
//
//        }
//
//        previousPosition = position;1


            final int currentPosition = position;


        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }
}

