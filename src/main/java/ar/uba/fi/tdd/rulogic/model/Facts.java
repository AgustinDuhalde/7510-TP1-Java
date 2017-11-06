package ar.uba.fi.tdd.rulogic.model;

import com.sun.istack.internal.NotNull;

import java.util.List;

public class Facts implements QueryImplicator {

    @NotNull private List<String> factsList;

    public Facts( @NotNull final List<String> factsList ) {
        this.factsList = factsList;
    }

    @Override
    public boolean implyQuery( @NotNull final String query ) {
        return 0 != ( factsList.stream().filter( fact -> fact.contains( query ) ).count() );
    }
}
