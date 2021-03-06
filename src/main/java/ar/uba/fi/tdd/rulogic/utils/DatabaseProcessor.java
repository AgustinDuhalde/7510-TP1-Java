package ar.uba.fi.tdd.rulogic.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatabaseProcessor {

    private List<String> databaseList = new ArrayList<>();

    public DatabaseProcessor( final String databaseName ) {

        try (Stream<String> stream = Files.lines(
                Paths.get( ClassLoader.getSystemResource( databaseName ).toURI() ) )
        ) {

            databaseList = stream
                    .filter( line -> !line.isEmpty() )
                    .map( String::trim )
                    .map( line -> line.replaceAll("\\s+",""))
                    .collect( Collectors.toList() );

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public List<String> getFacts() {
        return databaseList.stream()
                .filter( StringUtils::isFact )
                .collect( Collectors.toList() );
    }

    public List<String> getRules() {
        return databaseList.stream()
                .filter( StringUtils::isRule )
                .collect( Collectors.toList() );
    }

    public String processQuery( final String query ) {
        String processedQuery = query;
        processedQuery = processedQuery.trim();
        processedQuery = processedQuery.replaceAll("\\s+","");
        return processedQuery;
    }
}
