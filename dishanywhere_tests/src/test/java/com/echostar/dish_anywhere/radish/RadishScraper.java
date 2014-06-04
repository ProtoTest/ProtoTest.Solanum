package com.echostar.dish_anywhere.radish;


import com.prototest.solanum.RestClient;

import java.util.List;


/**
 */
public class RadishScraper {
    private RestClient client;

    public List<String> getMovies() {
        client = new RestClient("http://www.dishanywhere.com");
        String json = client.Get("/radish/v20/dol/movies/carousels/most_popular.json?totalItems=100");
        return client.parseAll("$.[*].name");
    }

    public String findMovieWithDrm(String type) {
        List<String> types = client.parseAll("$.[*].player_type");
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals(type)) {
                return client.parse("$.[" + i + "].name");
            }
        }

        return null;
    }

}
