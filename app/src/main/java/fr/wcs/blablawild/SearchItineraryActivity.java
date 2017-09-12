package fr.wcs.blablawild;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchItineraryActivity extends AppCompatActivity{
    EditText editTextSearchDepa,editTextSearchDest,editTextSearchDate;
    Button buttonSearch;
    Context context=SearchItineraryActivity.this;
    CharSequence text;
    int duration=Toast.LENGTH_SHORT;
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);
        editTextSearchDepa=(EditText)findViewById(R.id.editTextSearchDepature);
        editTextSearchDest=(EditText)findViewById(R.id.editTextSearchDestination);
        editTextSearchDate=(EditText)findViewById(R.id.editTextSearchDate);
        buttonSearch=(Button)findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                if(editTextSearchDepa.getText().toString().equals("")||editTextSearchDest.getText().toString().equals("")){
                    text="Vous devez remplir le départ et la destination !";
                    Toast.makeText(context,text,duration).show();
                }else{
                    Intent toPage3=new Intent(SearchItineraryActivity.this,ViewSearchItineraryResultsListActivity.class);
                    toPage3.putExtra("DEPARTURE",editTextSearchDepa.getText().toString());
                    toPage3.putExtra("DESTINATION",editTextSearchDest.getText().toString());
                    toPage3.putExtra("DATE",editTextSearchDate.getText().toString());
                    startActivity(toPage3);
                }
            }
        });
    }
}