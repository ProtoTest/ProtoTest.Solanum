package com.prototest.solanum;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


/**
 *
 */
class EggplantDriveClient {
    private XmlRpcClientConfigImpl config;
    private XmlRpcClient client;
    EggplantDriveClient(){
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
    HashMap<String, String> execute(String command) {
        Object[] params = new Object[]{command};
        try {
           HashMap result = (HashMap) client.execute("execute",params);
            return result;
        } catch (XmlRpcException e) {
            throw new RuntimeException(String.format("ERROR Executing '%s' : %s", command, e.getMessage()));
        }catch (Exception f) {
            Logger.error(String.format("ERROR Executing '%s' : %s", command, f.getMessage()));
        }
        return null;
    }
    void endSession() {
        Object[] params = new Object[]{};
        try {
            Object result = client.execute("EndSession",params);
        } catch (XmlRpcException e) {
            Logger.error("Error Ending Session : " + e.getMessage());
           throw new RuntimeException("Error Ending Session : " + e.getMessage());
        }
    }

    void startSession(String suite){
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
