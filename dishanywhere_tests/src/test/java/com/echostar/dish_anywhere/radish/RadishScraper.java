package com.echostar.dish_anywhere.radish;


import com.jayway.jsonpath.JsonPath;
import com.prototest.solanum.Config;
import com.prototest.solanum.RestClient;

import java.util.List;
import java.util.Map;

/** The RadishScraper contains methods to easily get data out of the radish api */
public class RadishScraper {
    private RestClient client;
    private static String radishUuid = Config.getPropertyValue("radishUuid","CE4B6EB3F8DF5D75E044D8D385F6C006");
    private static String radishSid = Config.getPropertyValue("radishSid","--e9ad919d527732c4bbf385ee3f5092f79d79a3cc");
    private static String radishUid = Config.getPropertyValue("radishUid","Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY=--31f0f7155946fec2c9c52955302180b5b52d3110");
    private static String radishDeviceId = Config.getPropertyValue("radishDeviceId","prm.Android.465a282c01567d79b2c9b7f9a854ebc9ff92236a1b21926152c2778a9d5c0c4f");
    private static String radishDomain= Config.getPropertyValue("radishDomain","http://radish.dishanywhere.com");

    public enum Device {
        android_phone,android_tablet
    }

    public static String getShortName(String name, int max){
        if(name.length()>max)
            name = name.substring(0,max);
        return name;
    }

    public List<String> getMovies() {
        client = new RestClient("http://www.dishanywhere.com");
        String json = client.Get("/radish/v20/dol/movies/carousels/most_popular.json?totalItems=100");
        return client.parseAll("$.[*].name");
    }

    public List<Map<String, String>> getOnDemandFeatured(Device device, int nMovies) {
        client = new RestClient(radishDomain);
        String json = client.Get("/v20/main.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=" + radishUid + "&sid=" + radishSid + "&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getMoviesCategory(Device device, int nMovies) {
        client = new RestClient(radishDomain);
        String json = client.Get("/v20/movies.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=" + radishUid + "&sid=" + radishSid + "&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }
    public List<Map<String, String>> getFamilyCategory(Device device, int nMovies) {
        client = new RestClient(radishDomain);
        String json = client.Get("/v20/family.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=" + radishUid + "&sid=" + radishSid + "&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }
    public List<Map<String, String>> getShowsCategory(Device device, int nMovies) {
        client = new RestClient(radishDomain);
        String json = client.Get("/v20/shows.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=" + radishUid + "&sid=" + radishSid + "&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getBlockbusterMoviesCategory(Device device, int nMovies) {
        client = new RestClient(radishDomain);
        String json = client.Get("/v20/blockbuster/movies.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=" + radishUid + "&sid=" + radishSid + "&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getBlockbusterShowsCategory(Device device, int nMovies) {
        client = new RestClient(radishDomain);
        String json = client.Get("/v20/blockbuster/shows.json?&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=" + radishUid + "&sid=" + radishSid + "&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getBlockbusterKidsMoviesCategory(Device device, int nMovies) {
        client = new RestClient(radishDomain);
        String json = client.Get("/v20/blockbuster/movies.json?&genre=kids_and_family&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=" + radishUid + "&sid=" + radishSid + "&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getBlockbusterKidsShowsCategory(Device device, int nMovies) {
        client = new RestClient(radishDomain);
        String json = client.Get("/v20/blockbuster/shows.json?&genre=kids_and_family&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=" + radishUid + "&sid=" + radishSid + "&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public List<Map<String, String>> getFilteredMovies(String genreFilter, Device device, int nMovies) {
            client = new RestClient(radishDomain);
        String json = client.Get("/v20/movies.json?&genre="+genreFilter+"&totalItems="+nMovies+"&device="+device.name()+"&itemStart=1&sort=name&uid=Q0U0QjZFQjNGOERGNUQ3NUUwNDREOEQzODVGNkMwMDY%3D--31f0f7155946fec2c9c52955302180b5b52d3110&sid=--e9ad919d527732c4bbf385ee3f5092f79d79a3cc&player_types=widevine,nagra");
        List<Map<String, String>> movies = JsonPath.read(json, "$.onlinenow.content[*]");
        return movies;
    }

    public String findMovieWithDrm(String type) {
        List<String> types = client.parseAll("$.[*].player_type");
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals(type)) {
                String name =client.parse("$.[" + i + "].name");
                //if(!name.contains("Frozen"))
                    return name;
            }
        }

        return null;
    }

}
