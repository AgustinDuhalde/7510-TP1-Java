package ar.uba.fi.tdd.rulogic.model;

import ar.uba.fi.tdd.rulogic.utils.StringUtils;
import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static ar.uba.fi.tdd.rulogic.utils.StringUtils.replaceAll;
import static ar.uba.fi.tdd.rulogic.utils.StringUtils.zipmap;

public class Rules implements QueryImplicator {

    @NotNull private List<String> rulesNames;
    @NotNull private Facts facts;
    @NotNull private HashMap<String, String> rulesMap = new HashMap<>();

    public Rules( @NotNull final Facts facts, @NotNull final List<String> rulesList ) {
        this.facts = facts;

        this.rulesNames = rulesList.stream()
                .map( StringUtils::getRuleName )
                .collect( Collectors.toList() );

        this.rulesMap = zipmap( rulesNames, rulesList );
    }

    @Override
    public boolean implyQuery( @NotNull final String query ) {
        final String queryName = StringUtils.getQueryName( query );
        final String queryParams = StringUtils.getParams( query );

        final String rule = rulesMap.get( queryName );
        final String ruleParams = StringUtils.getParams( rule );
        final String ruleFacts = rule.split( ":-" )[1];

        final HashMap<String, String> paramsMap = createParamsMap( ruleParams, queryParams );
        final String replacedFacts = replaceParams( ruleFacts, paramsMap );

        final List<String> replacedFactsList = Arrays.asList( replacedFacts.split( "\\)," ) );

        return implyQueries( replacedFactsList );
    }

    private HashMap<String, String> createParamsMap( @NotNull final String ruleParams, @NotNull final String queryParams) {
        final List<String> ruleParamsList = Arrays.asList( ruleParams.split( "," ) );
        final List<String> queryParamsList = Arrays.asList( queryParams.split( "," ) );
        return zipmap( ruleParamsList, queryParamsList );
    }

    private String replaceParams( @NotNull final String ruleFacts, @NotNull final HashMap<String, String> paramsMap ) {
        final String[] replacedFacts = {ruleFacts};
        paramsMap.forEach(
                ( key, value) -> replacedFacts[0] = replaceAll(replacedFacts[0], key, value )
        );
        return replacedFacts[0];
    }

    private boolean implyQueries( @NotNull final List<String> queries ) {
        return 0 == queries.stream()
                .filter( query -> !facts.implyQuery(query) )
                .count();
    }
}
