package com.prototest.solanum;

import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.List;

import static com.jayway.jsonpath.Filter.filter;

/**
 * RestClient used to execute HTTP requests and parse the results using jsonpath.
 * http://goessner.net/articles/JsonPath/
 */
public class RestClient {
    Client client;
    WebResource webResource;
    ClientResponse response;
    String domain;
    String output;

    /**
     * Create a new RestClient for a specified domain.  All further requests will append on this domain.
     */
    public RestClient(String domain) {
        this.domain = domain;
    }

    /**
     * Gets the output of the last response.
     */
    public String getOutput() {
        return output;
    }

    /**
     * Execute a GET request against a specified endpoint, and return the response body as a string.
     */
    public String Get(String resource) {
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

    /**
     * Parse the last response using the specified JSONPath.
     */
    public String parse(String jpath) {
        return JsonPath.read(output, jpath);
    }

    /**
     * Returns all nodes that match the given jsonpath
     * */
    public List<String> parseAll(String jpath) {
        return JsonPath.read(output, jpath);
    }

    /**
     * Returns all nodes that match the given jsonpath, using the specified filter.
     * */

    public List<String> parseAll(String jpath, Filter filter) {
        return JsonPath.read(output, jpath, filter);
    }
}
