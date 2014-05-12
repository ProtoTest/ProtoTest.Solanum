


package com.prototest.solanum;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcRequest;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcClientRequestImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import org.apache.xmlrpc.parser.XmlRpcResponseParser;

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

    public void Execute(String command){
        Object[] params = new Object[]{command};
        try {
            Logger.Message(String.format("Executing : %s",command));
            Object result = client.execute("Execute",params);
        } catch (XmlRpcException e) {
            Logger.Warning(e.getMessage());
        }
    }
    public void EndSuite() {
        Object[] params = new Object[]{};
        try {
            Logger.Message(String.format("Ending Session"));
            Object result = client.execute("EndSession",params);
            Logger.Message("Got a result");
        } catch (XmlRpcException e) {
            Logger.Warning(e.getMessage());
        }
    }

    public void StartSuite(){
        Config.suitePath = "C:\\Users\\Brian\\Documents\\GitHub\\Nightshade.MotorolaTests\\Suites\\MotorolaMaster.suite";
        Object[] params = new Object[]{Config.suitePath};
        try {
            Logger.Message(String.format("Starting Session : %s",Config.suitePath));
            Object result = client.execute("StartSession",params);
            Logger.Message("Got a result");
        } catch (XmlRpcException e) {
            Logger.Warning(e.getMessage());
        }
    }
}
