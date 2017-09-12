package fr.wcs.blablawild;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity{
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);
        Intent recu=getIntent();
        String textSearchDepa=recu.getStringExtra("DEPARTURE");
        String textSearchDest=recu.getStringExtra("DESTINATION");
        String textSearchDate=recu.getStringExtra("DATE");
        setTitle(textSearchDepa+" >> "+textSearchDest);
    }
}