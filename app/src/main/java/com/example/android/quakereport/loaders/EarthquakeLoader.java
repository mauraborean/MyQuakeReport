package com.example.android.quakereport.loaders;

import android.content.*;
import android.util.*;

import com.example.android.quakereport.*;
import com.example.android.quakereport.utils.*;

import java.util.*;

import static com.example.android.quakereport.EarthquakeActivity.*;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    
    private static final String USGS_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    
    public EarthquakeLoader ( Context context ) {
        super( context );
    }
    
    @Override
    public List<Earthquake> loadInBackground () {
        Log.i( LOG_TAG, "looking for the earthquakes now!" );
        return QueryUtils.extractEarthquakes( USGS_URL );
    }
    
    @Override
    protected void onStartLoading () {
        forceLoad();
    }
}
