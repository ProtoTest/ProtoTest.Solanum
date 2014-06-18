package com.echostar.dish_anywhere.radish;


import com.jayway.jsonpath.JsonPath;
import com.prototest.solanum.RestClient;

import java.util.List;
import java.util.Map;


/**
 */
public class RadishScraper {
    private RestClient client;

    public enum Device {
        android_phone,android_tablet
    }

    public List<String> getMovies() {
        client = new RestClient("http://www.dishanywhere.com");
        String json = client.Get("/radish/v20/dol/movies/carousels/most_popular.json?totalItems=100");
        return client.parseAll("$.[*].name");
    }

    public List<Map<String, String>> getOnDemandFeatured(Device device, int nMovies) {
        client = new RestClient("http://radish.dishanywhere.com");
        String json = client.Get("/v20/main.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY%3D--31f0f7155946fec2c9c52955302180b5b52d3110&sid=--e9ad919d527732c4bbf385ee3f5092f79d79a3cc&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getMoviesCategory(Device device, int nMovies) {
        client = new RestClient("http://radish.dishanywhere.com");
        String json = client.Get("/v20/movies.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY%3D--31f0f7155946fec2c9c52955302180b5b52d3110&sid=--e9ad919d527732c4bbf385ee3f5092f79d79a3cc&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }
    public List<Map<String, String>> getFamilyCategory(Device device, int nMovies) {
        client = new RestClient("http://radish.dishanywhere.com");
        String json = client.Get("/v20/family.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY%3D--31f0f7155946fec2c9c52955302180b5b52d3110&sid=--e9ad919d527732c4bbf385ee3f5092f79d79a3cc&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }
    public List<Map<String, String>> getShowsCategory(Device device, int nMovies) {
        client = new RestClient("http://radish.dishanywhere.com");
        String json = client.Get("/v20/shows.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY%3D--31f0f7155946fec2c9c52955302180b5b52d3110&sid=--e9ad919d527732c4bbf385ee3f5092f79d79a3cc&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getBlockbusterMoviesCategory(Device device, int nMovies) {
        client = new RestClient("http://radish.dishanywhere.com");
        String json = client.Get("/v20/blockbuster/movies.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY%3D--31f0f7155946fec2c9c52955302180b5b52d3110&sid=--e9ad919d527732c4bbf385ee3f5092f79d79a3cc&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getBlockbusterShowsCategory(Device device, int nMovies) {
        client = new RestClient("http://radish.dishanywhere.com");
        String json = client.Get("/v20/blockbuster/shows.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY%3D--31f0f7155946fec2c9c52955302180b5b52d3110&sid=--e9ad919d527732c4bbf385ee3f5092f79d79a3cc&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getBlockbusterKidsMoviesCategory(Device device, int nMovies) {
        client = new RestClient("http://radish.dishanywhere.com");
        String json = client.Get("/v20/blockbuster/movies.json?&genre=kids_and_family&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY%3D--31f0f7155946fec2c9c52955302180b5b52d3110&sid=--e9ad919d527732c4bbf385ee3f5092f79d79a3cc&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getBlockbusterKidsShowsCategory(Device device, int nMovies) {
        client = new RestClient("http://radish.dishanywhere.com");
        String json = client.Get("/v20/blockbuster/shows.json?&genre=kids_and_family&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY%3D--31f0f7155946fec2c9c52955302180b5b52d3110&sid=--e9ad919d527732c4bbf385ee3f5092f79d79a3cc&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getComedyMovies(Device device, int nMovies) {
        client = new RestClient("http://radish.dishanywhere.com");
        String json = client.Get("/v20/movies.json?&genre=comedy&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY%3D--31f0f7155946fec2c9c52955302180b5b52d3110&sid=--e9ad919d527732c4bbf385ee3f5092f79d79a3cc&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
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
