package ar.uba.fi.tdd.rulogic.model;

import java.util.List;

public class Facts implements QueryImplicator {

    private List<String> factsList;

    public Facts( final List<String> factsList ) {
        this.factsList = factsList;
    }

    @Override
    public boolean implyQuery( final String query ) {
        return 0 != ( factsList.stream().filter( fact -> fact.contains( query ) ).count() );
    }
}
