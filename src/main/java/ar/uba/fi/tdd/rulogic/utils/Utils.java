package ar.uba.fi.tdd.rulogic.utils;

import com.sun.istack.internal.NotNull;

public class Utils {

    static public boolean isFact( @NotNull final String line ) {
        return !line.contains( ":-" );
    }

    static public boolean isRule( @NotNull final String line ) {
        return line.contains( ":-" );
    }
}
