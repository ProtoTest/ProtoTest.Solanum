package com.prototest.solanum;

import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.List;

import static com.jayway.jsonpath.Filter.filter;

/**
 * Created by Brian on 6/2/2014.
 */
public class RestClient {
    Client client;
    WebResource webResource;
    ClientResponse response;
    String domain;
    String output;

    public RestClient(String domain){
        this.domain = domain;
    }

    public String getOutput(){
        return output;
    }

    public String Get(String resource){
    client = Client.create();

    webResource = client.resource(domain += resource);
    response = webResource.accept("application/json")
            .get(ClientResponse.class);

    if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
                + response.getStatus());
    }

    output = response.getEntity(String.class);
        return output;
    }

    public String parse(String jpath){
        return JsonPath.read(output, jpath);
    }

    public List<String> parseAll(String jpath){
        return JsonPath.read(output, jpath);
    }

    public List<String> parseAll(String jpath,Filter filter){
        return JsonPath.read(output, jpath,filter);
    }
}
