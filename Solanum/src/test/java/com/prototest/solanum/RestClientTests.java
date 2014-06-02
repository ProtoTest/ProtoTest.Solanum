package com.prototest.solanum;

import org.testng.annotations.Test;

import java.util.List;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

/**
 * Created by Brian on 6/2/2014.
 */
public class RestClientTests {
    @Test
    public void GetAllNames(){
        RestClient client = new RestClient("http://www.dishanywhere.com");
        client.Get("/radish/v20/dol/movies/carousels/most_popular.json?totalItems=12");
        List<String> names = client.parseAll( "$.[*].name");
        for(String name : names){
            Logger.info(name);
        }
    }

    @Test
    public void GetAllByGenre(){
        RestClient client = new RestClient("http://www.dishanywhere.com");
        client.Get("/radish/v20/dol/movies/carousels/most_popular.json?totalItems=12");
        List<String> names = client.parseAll( "$.[?].genres[*].name",filter(where("name").is("Captain Phillips")));
        for(String name : names){
            Logger.info(name);
        }
    }
}
