package ar.uba.fi.tdd.rulogic.model;

import com.sun.istack.internal.NotNull;

import java.util.List;

public class Facts {

    @NotNull private List<String> factsList;

    public Facts( @NotNull final List<String> factsList ) {
        this.factsList = factsList;
    }
}
