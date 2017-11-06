package ar.uba.fi.tdd.rulogic.model;

import com.sun.istack.internal.NotNull;

public interface QueryImplicator {
    boolean implyQuery( @NotNull final String query );
}
