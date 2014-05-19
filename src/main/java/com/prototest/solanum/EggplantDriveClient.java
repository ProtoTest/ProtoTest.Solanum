package com.prototest.solanum;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 */
class EggplantDriveClient {
    private XmlRpcClientConfigImpl config;
    private XmlRpcClient client;
    EggplantDriveClient(){
        config = new XmlRpcClientConfigImpl();
        try {
            config.setServerURL(new URL("http://127.0.0.1:5400"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
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
    Object execute(String command) {
        Object[] params = new Object[]{command};
        try {
           Object result = client.execute("execute",params);
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
        Object[] params = new Object[]{suite};
        try {
           Object result = client.execute("StartSession",params);
        } catch (XmlRpcException e) {
            Logger.error("ERROR starting session : " + suite + " " + e.getMessage());
            throw new RuntimeException("ERROR starting session : " + suite + " " + e.getMessage());

        }
    }
}
