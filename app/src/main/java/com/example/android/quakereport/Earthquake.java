package com.example.android.quakereport;


import java.text.*;
import java.util.*;

public class Earthquake {
    
    private Double magnitude;
    private String location;
    private String url;
    private Date date;
    
    public Earthquake () {
        
    }
    
    public Earthquake ( Double magnitude, String location, Date date ) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }
    
    public String getMagnitudeAsString () {
        DecimalFormat df = new DecimalFormat( "#.#" );
        return df.format( magnitude );
    }
    
    public Double getMagnitudeAsDouble () {
        return magnitude;
    }
    
    public void setMagnitude ( Double magnitude ) {
        this.magnitude = magnitude;
    }
    
    public String getUrl () {
        return url;
    }
    
    public void setUrl ( String url ) {
        this.url = url;
    }
    
    public String getFullLocation () {
        return location;
    }
    
    public String getLocationReference () {
        if ( location.contains( "of" ) ) {
            return location.split( "of" )[ 0 ];
        }
        
        return "Near the";
    }
    
    public String getShortLocation () {
        int index = 0;
        
        if ( location.contains( "of" ) ) {
            index = 1;
        }
        
        return location.split( "of" )[ index ];
    }
    
    public void setLocation ( String location ) {
        this.location = location;
    }
    
    public Date getDate () {
        return date;
    }
    
    public String getStringDate () {
        DateFormat df = DateFormat.getDateInstance( DateFormat.MEDIUM );
        return df.format( date );
    }
    
    public String getStringTime () {
        DateFormat df = DateFormat.getTimeInstance( DateFormat.SHORT );
        return df.format( date );
    }
    
    public void setDate ( Date date ) {
        this.date = date;
    }
}
