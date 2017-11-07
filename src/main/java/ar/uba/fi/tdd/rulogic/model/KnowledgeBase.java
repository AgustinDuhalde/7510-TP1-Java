package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.utils.DatabaseProcessor;
import ar.uba.fi.tdd.rulogic.utils.StringUtils;
import com.sun.istack.internal.NotNull;

public class KnowledgeBase {

    @NotNull private final DatabaseProcessor databaseProcessor;
    @NotNull private final Facts facts;
    @NotNull private final Rules rules;

    public KnowledgeBase( @NotNull final String databaseName ) {

        databaseProcessor = new DatabaseProcessor( databaseName );

        facts = new Facts( databaseProcessor.getFacts() );
        rules = new Rules( facts, databaseProcessor.getRules() );
    }

	public boolean answer( @NotNull final String query ) {
        final String processedQuery = databaseProcessor.processQuery( query );

		if ( rules.hasRule( StringUtils.getQueryName( processedQuery ) ) )
		    return rules.implyQuery( processedQuery );
		else
		    return facts.implyQuery( processedQuery );
	}
}
