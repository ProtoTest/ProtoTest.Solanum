


package com.prototest.solanum;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Brian on 5/12/2014.
 */
public class EggplantDriveClient {
    private XmlRpcClientConfigImpl config;
    private XmlRpcClient client;
    public EggplantDriveClient(){
        config = new XmlRpcClientConfigImpl();
        try {
            config.setServerURL(new URL("http://127.0.0.1:5400"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        client  = new XmlRpcClient();
        client.setConfig(config);
    }

    public void execute(String command){
        Object[] params = new Object[]{command};
        try {
            Logger.message(String.format("Executing : %s", command));
            Object result = client.execute("execute",params);
        } catch (XmlRpcException e) {
            Logger.Warning(e.getMessage());
        }
    }
    public void endSuite() {
        Object[] params = new Object[]{};
        try {
            Logger.message(String.format("Ending Suite"));
            Object result = client.execute("EndSession",params);
            Logger.message("Got a result");
        } catch (XmlRpcException e) {
            Logger.Warning(e.getMessage());
        }
    }

    public void startSuite(){
        Object[] params = new Object[]{Config.suitePath};
        try {
            Logger.message(String.format("Starting Suite : %s", Config.suitePath));
            Object result = client.execute("StartSession",params);
            Logger.message("Got a result");
        } catch (XmlRpcException e) {
            Logger.Warning(e.getMessage());
        }
    }
}
