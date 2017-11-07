package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.utils.DatabaseProcessor;
import ar.uba.fi.tdd.rulogic.utils.StringUtils;

public class KnowledgeBase {

    private final DatabaseProcessor databaseProcessor;
    private final Facts facts;
    private final Rules rules;

    public KnowledgeBase( final String databaseName ) {

        databaseProcessor = new DatabaseProcessor( databaseName );

        facts = new Facts( databaseProcessor.getFacts() );
        rules = new Rules( facts, databaseProcessor.getRules() );
    }

	public boolean answer( final String query ) {
        final String processedQuery = databaseProcessor.processQuery( query );

		if ( rules.hasRule( StringUtils.getQueryName( processedQuery ) ) )
		    return rules.implyQuery( processedQuery );
		else
		    return facts.implyQuery( processedQuery );
	}
}
