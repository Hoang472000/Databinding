package com.android.demoviewbinding1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.demoviewbinding1.databinding.ActivityMainBinding;
import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {

    private Account account;
    private MyClickHandlers handlers;
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.toolbar_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Account account = new Account("demo","demo","3","null", 0);
        account.setUsername("Ravi Tamada");
        account.setPassword("@12345");
        account.setProfileImage("https://d36v3uyzob3tcl.cloudfront.net/products/ILEA000803502/thumbnails/thumbnail.jpg");
        binding.setAccount(account);
        binding.content.setStr("84dp");
        binding.content.setIndex(84);
        account.setPadding(50);
        Log.d("HoangCV", "onCreate: "+toolbar.getHeight()+" : "+toolbar.getMeasuredHeight());
        //binding.content.setStr(String.valueOf(toolbar.getHeight()));

        handlers = new MyClickHandlers(this);
        binding.content.setHandlers(handlers);
       /* mBinding = DataBindingUtil.setContentView(this, R.layout.recycleview);
        List<Texttt> texttts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            texttts.add(new Texttt(i+""));
        }
        mAdapter = new MyAdapter(texttts);
        mBinding.recycleview.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recycleview.setAdapter(mAdapter);*/
    }



    public class MyClickHandlers {

    Context context;

    public MyClickHandlers(Context context) {
        this.context = context;
    }

    public void onFabClicked(View view) {
        Toast.makeText(getApplicationContext(), "FAB clicked!", Toast.LENGTH_SHORT).show();
    }

    public void onButtonClick(View view) {
        Toast.makeText(getApplicationContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
    }

    public void onButtonClickWithParam(View view, Account account) {
        Toast.makeText(getApplicationContext(), "Button clicked! Name: " + account.getUsername(), Toast.LENGTH_SHORT).show();
    }

    public boolean onButtonLongPressed(View view) {
        Toast.makeText(getApplicationContext(), "Button long pressed!", Toast.LENGTH_SHORT).show();
        return false;
    }
}

}
