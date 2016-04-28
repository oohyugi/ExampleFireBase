package com.yogiputra.examplefirebase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yogi on 27/04/16.
 */
public class AddDataActivity extends AppCompatActivity {

    @Bind(R.id.input_title)
    EditText inputTitle;
    @Bind(R.id.input_content)
    EditText inputContent;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    String sTitle,sContent;
    Firebase myFirebaseRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data);
        ButterKnife.bind(this);
        myFirebaseRef = new Firebase("https://yogiutrra.firebaseio.com/android");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);







    }
    @OnClick(R.id.btnInput)
    public void onCLickInput(){

        insertData();
    }

    private void insertData() {
        try {
            sTitle=inputTitle.getText().toString();
            sContent=inputContent.getText().toString();
            Firebase firebase=myFirebaseRef.child("data").child(sTitle);
            Map<String,String> data= new HashMap<String, String>();
            data.put("title",sTitle);
            data.put("content",sContent);
           firebase.setValue(data, new Firebase.CompletionListener() {
                @Override
                public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                    if (firebaseError != null) {
                        Log.d("Error",firebaseError.getMessage());


                    }else {
                        Toast.makeText(getApplicationContext(),"Sukses menambahkan data",Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                }
            });
        }catch (Exception e){

        }

    }


    public static void startActivity(Context context){
        Intent intent = new Intent(context,AddDataActivity.class);
        context.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
int id =item.getItemId();
        if (id==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
