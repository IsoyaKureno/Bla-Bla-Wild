package fr.wcs.blablawild;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity{
    EditText editTextSearchDepa,editTextSearchDest,editTextSearchDate;
    Context context=SearchItineraryActivity.this;
    CharSequence text;
    int duration=Toast.LENGTH_SHORT;
    final Calendar myCalendar=Calendar.getInstance();
    private void updateLabel(){
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editTextSearchDate.setText(sdf.format(myCalendar.getTime()));
    }
    DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
        @Override public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth){
            myCalendar.set(Calendar.YEAR,year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);
        editTextSearchDepa=(EditText)findViewById(R.id.editTextSearchDepature);
        editTextSearchDest=(EditText)findViewById(R.id.editTextSearchDestination);
        editTextSearchDate=(EditText)findViewById(R.id.editTextSearchDate);

        editTextSearchDate.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                new DatePickerDialog(SearchItineraryActivity.this,date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        Button buttonSearch=(Button)findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                if(editTextSearchDepa.getText().toString().equals("")||editTextSearchDest.getText().toString().equals("")){
                    text="Vous devez remplir le départ et la destination !";
                    Toast.makeText(context,text,duration).show();
                }else{
                    SearchRequestModel request=new SearchRequestModel(
                            editTextSearchDepa.getText().toString(),
                            editTextSearchDest.getText().toString(),
                            editTextSearchDate.getText().toString());
                    Intent toPage3=new Intent(SearchItineraryActivity.this,ViewSearchItineraryResultsListActivity.class);
                    toPage3.putExtra("REQUEST",request);
                    startActivity(toPage3);
                }
            }
        });
    }
}
