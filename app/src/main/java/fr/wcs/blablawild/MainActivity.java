package fr.wcs.blablawild;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    Button buttonToPage2;
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonToPage2=(Button)findViewById(R.id.buttonMain);
        buttonToPage2.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Intent SearchItineraryActivity=new Intent(MainActivity.this,SearchItineraryActivity.class);
                startActivity(SearchItineraryActivity);
            }
        });
    }
}