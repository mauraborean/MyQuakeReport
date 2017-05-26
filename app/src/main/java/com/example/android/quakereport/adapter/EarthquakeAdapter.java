package com.example.android.quakereport.adapter;

import android.content.*;
import android.graphics.drawable.*;
import android.net.*;
import android.support.annotation.*;
import android.support.v4.content.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

import com.example.android.quakereport.*;

import java.util.*;

public class EarthquakeAdapter extends ArrayAdapter {
    
    private List<Earthquake> earthquakeList;
    
    public EarthquakeAdapter ( @NonNull Context context, @NonNull List<Earthquake> objects ) {
        super( context, 0, objects );
        earthquakeList = objects;
    }
    
    @NonNull
    @Override
    public View getView ( int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
        
        if ( convertView == null ) {
            convertView = LayoutInflater.from( getContext() ).inflate( R.layout.earthquake_list_item, parent, false );
        }
        
        Earthquake earthquake = ( Earthquake ) getItem( position );
        
        TextView magnitudeTextView = ( TextView ) convertView.findViewById( R.id.magnitude_text_view );
        
        assert earthquake != null;
        magnitudeTextView.setText( earthquake.getMagnitudeAsString() );
        
        GradientDrawable magnitudeCircle = ( GradientDrawable ) magnitudeTextView.getBackground();
        magnitudeCircle.setColor( getMagnitudeColor( earthquake.getMagnitudeAsDouble() ) );
        
        TextView locationReferenceTextView = ( TextView ) convertView.findViewById( R.id.location_reference_text_view );
        locationReferenceTextView.setText( earthquake.getLocationReference() );
        
        TextView locationTextView = ( TextView ) convertView.findViewById( R.id.location_text_view );
        locationTextView.setText( earthquake.getShortLocation() );
        
        TextView dateTextView = ( TextView ) convertView.findViewById( R.id.date_text_view );
        dateTextView.setText( earthquake.getStringDate() );
        
        TextView timeTextView = ( TextView ) convertView.findViewById( R.id.time_text_view );
        timeTextView.setText( earthquake.getStringTime() );
        
        convertView.setOnClickListener( getOnClickListener( earthquake.getUrl() ) );
        
        return convertView;
    }
    
    private OnClickListener getOnClickListener ( final String url ) {
        return new OnClickListener() {
            @Override
            public void onClick ( View view ) {
                Uri webpage = Uri.parse( url );
                Intent intent = new Intent( Intent.ACTION_VIEW, webpage );
                
                if ( intent.resolveActivity( getContext().getPackageManager() ) != null ) {
                    getContext().startActivity( intent );
                }
            }
        };
    }
    
    private int getMagnitudeColor ( Double magnitude ) {
        int magnitudeInt = ( int ) Math.floor( magnitude );
        int magnitudeColor;
        
        switch ( magnitudeInt ) {
            case 0:
            case 1:
                magnitudeColor = ContextCompat.getColor( getContext(), R.color.magnitude1 );
                break;
            case 2:
                magnitudeColor = ContextCompat.getColor( getContext(), R.color.magnitude2 );
                break;
            case 3:
                magnitudeColor = ContextCompat.getColor( getContext(), R.color.magnitude3 );
                break;
            case 4:
                magnitudeColor = ContextCompat.getColor( getContext(), R.color.magnitude4 );
                break;
            case 5:
                magnitudeColor = ContextCompat.getColor( getContext(), R.color.magnitude5 );
                break;
            case 6:
                magnitudeColor = ContextCompat.getColor( getContext(), R.color.magnitude6 );
                break;
            case 7:
                magnitudeColor = ContextCompat.getColor( getContext(), R.color.magnitude7 );
                break;
            case 8:
                magnitudeColor = ContextCompat.getColor( getContext(), R.color.magnitude8 );
                break;
            case 9:
                magnitudeColor = ContextCompat.getColor( getContext(), R.color.magnitude9 );
                break;
            default:
                magnitudeColor = ContextCompat.getColor( getContext(), R.color.magnitude10plus );
                break;
        }
        
        return magnitudeColor;
    }
    
    public void setData ( List<Earthquake> earthquakes ) {
        earthquakeList.addAll( earthquakes );
        notifyDataSetChanged();
    }
    
    public int getCount () {
        return earthquakeList.size();
    }
    
    public void reset () {
        earthquakeList.clear();
        notifyDataSetChanged();
    }
}
