package fr.wcs.blablawild;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity{
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);
        Intent recu=getIntent();
        String textSearchDepa=recu.getStringExtra("DEPARTURE");
        String textSearchDest=recu.getStringExtra("DESTINATION");
        String textSearchDate=recu.getStringExtra("DATE");
        setTitle(textSearchDepa+" >> "+textSearchDest);
        ListView mListViewResults;
        TripResultAdapter mResultsAdapter;
        mListViewResults = (ListView) findViewById(R.id.listViewSearchResults);
        ArrayList<TripResultModel> results = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        try {
            results.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {}
        mResultsAdapter = new TripResultAdapter(this, results);
        mListViewResults.setAdapter(mResultsAdapter);
    }
}