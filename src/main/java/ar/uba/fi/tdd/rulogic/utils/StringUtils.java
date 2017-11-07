package ar.uba.fi.tdd.rulogic.utils;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtils {

    static public boolean isFact( final String line ) {
        return !line.contains( ":-" );
    }

    static public boolean isRule( final String line ) {
        return line.contains( ":-" );
    }

    static public String getRuleName( final String rule ) {
        return rule.split( "\\(" )[0];
    }

    static public HashMap<String, String> zipmap(final List<String> keys, final List<String> values ) {
        final HashMap<String, String> map = new HashMap();
        for ( int i = 0; i < keys.size(); i++)
            map.put( keys.get( i ), values.get( i ) );
        return map;
    }

    static public String getQueryName( final String query ) {
        return query.split( "\\(" )[0];
    }

    static public String getParams( final String query ) {
        final int indexStart = query.indexOf( "(" );
        final int indexEnd = query.indexOf( ")" );
        return query.substring( indexStart + 1, indexEnd );
    }

    static public String replaceAll( String str, String find, String replace ) {
        return str.replace( Pattern.compile( find, 'g').pattern(), replace );
    }
}
