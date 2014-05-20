package com.prototest.solanum;

import java.util.HashMap;

/**
 * Created by Brian on 5/20/2014.
 */
///The MockDriver does not execute against eggplant, but instead stores the response to a variable that can be validated.
/// This is used to validate the format and structure of the eggplant commands
public class MockDriver extends EggplantDriver{
    public HashMap<String, String> lastResponse;
    public HashMap<String, String> getLastResponse(){ return lastResponse;}
    @Override
    public HashMap<String, String> execute(String command) {
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("Output",command);
        response.put("Result","FAKE COMMAND");
        response.put("Duration","0");
        response.put("ReturnValue","");
        lastResponse = response;
        return response;
    }
    @Override
    public void startSuite(String path){
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("Output","StartSuite : " + path);
        response.put("Result","FAKE COMMAND");
        response.put("Duration","0");
        response.put("ReturnValue","");
        lastResponse = response;

    }
    @Override
    public void endSuite(){
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("Output","EndSuite");
        response.put("Result","FAKE COMMAND");
        response.put("Duration","0");
        response.put("ReturnValue","");
        lastResponse = response;

    }

}