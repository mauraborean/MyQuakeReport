/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.app.*;
import android.content.*;
import android.os.*;

import android.support.v7.app.*;
import android.util.*;
import android.widget.*;

import com.example.android.quakereport.adapter.*;
import com.example.android.quakereport.loaders.*;

import java.util.*;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Earthquake>> {
    
    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    private EarthquakeAdapter earthquakeAdapter;
    
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.earthquake_activity );
        
        ListView earthquakeListView = ( ListView ) findViewById( R.id.list );
        earthquakeAdapter = new EarthquakeAdapter( this, new ArrayList<Earthquake>() );
        earthquakeListView.setAdapter( earthquakeAdapter );
        
        getLoaderManager().initLoader( 1, null, this ).forceLoad();
    }
    
    //    private void updateUI ( List earthquakeList ) {
    //        ListView earthquakeListView = ( ListView ) findViewById( R.id.list );
    //        earthquakeAdapter = new EarthquakeAdapter( this, earthquakeList );
    //        earthquakeListView.setAdapter( earthquakeAdapter );
    //    }
    
    @Override
    public Loader onCreateLoader ( int id, Bundle args ) {
        Log.i( LOG_TAG, "onCreateLoader!" );
        return new EarthquakeLoader( EarthquakeActivity.this );
    }
    
    @Override
    public void onLoadFinished ( Loader<List<Earthquake>> loader, List<Earthquake> data ) {
        Log.i( LOG_TAG, "updating the ui!" );
        //        updateUI( data );
        earthquakeAdapter.setData( data );
    }
    
    @Override
    public void onLoaderReset ( Loader loader ) {
        Log.i( LOG_TAG, "onLoaderReset!" );
        //        updateUI( new ArrayList() );
//        earthquakeAdapter.setData( new ArrayList() );
        earthquakeAdapter.clear();
    }
    
}
