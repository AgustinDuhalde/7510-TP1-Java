package ar.uba.fi.tdd.rulogic.model;

import com.sun.istack.internal.NotNull;

import java.util.List;

public class Rules {

    @NotNull
    private List<String> rulesList;

    public Rules( @NotNull final List<String> rulesList ) {
        this.rulesList = rulesList;
    }
}
