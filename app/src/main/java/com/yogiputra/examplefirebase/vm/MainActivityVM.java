package com.yogiputra.examplefirebase.vm;

import android.databinding.ObservableField;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.yogiputra.examplefirebase.AddDataActivity;
import com.yogiputra.examplefirebase.ItemAdapter;
import com.yogiputra.examplefirebase.controller.MainController;
import com.yogiputra.examplefirebase.dao.Berita;
import com.yogiputra.examplefirebase.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;


/**
 * Created by yogi on 27/04/16.
 */
public class MainActivityVM extends GitsVM<MainController,ActivityMainBinding> {

    public ObservableField<String> pesan= new ObservableField<>();
    private List<Berita> mList=new ArrayList<>();
    public ItemAdapter bAdapter;
    public LinearLayoutManager bLayoutManager;

    ProgressBar progressBar;
    FloatingActionButton fab;


    public MainActivityVM(AppCompatActivity activity, MainController controller, ActivityMainBinding binding) {
        super(activity, controller, binding);

            initView(binding);

        initFireBase(binding);




    }

    private void initView(ActivityMainBinding binding) {
        binding.progressbar.setVisibility(View.VISIBLE);
            binding.fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  AddDataActivity.startActivity(mActivity);
                }
            });
    }

    private void initFireBase(final ActivityMainBinding binding) {
        Firebase myFirebaseRef = new Firebase("https://yogiutrra.firebaseio.com/android/data");
        bAdapter= new ItemAdapter(mList);
        bLayoutManager=new LinearLayoutManager(mActivity);

        //Show Data from FireBase
        myFirebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Berita post=snapshot.getValue(Berita.class);
                    mList.add(post);
                    Log.e("title", post.getTitle());
                    Log.e("Content", post.getContent());

                    binding.progressbar.setVisibility(View.GONE);
                }

                bAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
