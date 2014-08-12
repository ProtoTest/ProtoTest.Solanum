package com.prototest.solanum;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


/**
 *  EggplantDriveClient communicates with the XMLRPC service launched by EggplantDrive (normally at 127.0.0.1:5400).
 *
 *  <b>For internal Solanum use only. Use {@link EggplantElement} to interact with EggPlant.</b>
 */
class EggplantDriveClient {
    private XmlRpcClientConfigImpl config;
    private XmlRpcClient client;
    PrintWriter writer;

    private void createLogFile(){
        try {
            this.writer = new PrintWriter("output.script", "UTF-8");
        } catch (FileNotFoundException e) {
            File file = new File("output.script");
            try {
                file.createNewFile();
                createLogFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /** Instantiates a new client to communicate with the xmlrpc service at the location specified in the config file.   */
    EggplantDriveClient(){
        createLogFile();
        config = new XmlRpcClientConfigImpl();
        try {
            config.setServerURL(new URL(Config.driveUrl));
            config.setConnectionTimeout(10000);
            config.setReplyTimeout(30000);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to start XmlRpc client", e);
        }
        client  = new XmlRpcClient();
        client.setConfig(config);
    }

    /** Instantiates a new client to communicate with the xmlrpc service at the url passed in.     */
    EggplantDriveClient(String url){
        config = new XmlRpcClientConfigImpl();
        try {
            config.setServerURL(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        client  = new XmlRpcClient();
        client.setConfig(config);
    }

    /** Executes a SenseTalk commmand, and returns the response */
    EggplantResponse execute(String command) {
        if (Config.logDriveCommands) {
            Logger.debug(String.format(":: Execute : '%s'", command));
            writer.println(command);
        }
        Object[] params = new Object[]{command};
        try {
           Object result = client.execute("execute",params);
            EggplantResponse response = new EggplantResponse((HashMap<String,String>)result);
            return response;
        } catch (XmlRpcException e) {
            throw new RuntimeException(String.format("ERROR Executing '%s' : %s", command, e.getMessage()));
        }catch (Exception f) {
            Logger.error(String.format("ERROR Executing '%s' : %s", command, f.getMessage()));
        }
        return null;
    }

    /** Ends the current session (suite) */
    void endSession() {
        if (Config.logDriveCommands) {
            Logger.debug(":: Ending the Suite");
            writer.println("EndSession");
        }
        Object[] params = new Object[]{};
        try {
            Object result = client.execute("EndSession",params);
        } catch (XmlRpcException e) {
            Logger.error("Error Ending Session : " + e.getMessage());
           throw new RuntimeException("Error Ending Session : " + e.getMessage());
        }
    }

    /** Starts a new session (eggplant suite).  Pass in the location of the .suite file on the local hard drive. */
    void startSession(String suite){
        if (Config.logDriveCommands) {
            Logger.debug(":: Starting the Suite: " + suite);
            writer.println("StartSession" + suite);
        }
        File suiteFile = new File(suite);
        if (! suiteFile.isAbsolute()) {
            suite = new File(System.getProperty("user.dir"), suite).toString();
        }
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            suite = suite.replace('/', '\\');
        }
        Object[] params = new Object[]{suite};
        try {
           Object result = client.execute("StartSession",params);
        } catch (XmlRpcException e) {
            if(e.getMessage().contains("Session in progress")){
                endSession();
                try {
                    Object result = client.execute("StartSession",params);
                } catch (XmlRpcException e1) {
                    Logger.error("ERROR starting session : " + suite + " " + e.getMessage());
                    throw new RuntimeException("ERROR starting session : " + suite + " " + e.getMessage());
                }
            }


        }
    }
}
