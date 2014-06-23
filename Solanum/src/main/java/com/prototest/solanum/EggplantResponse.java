package com.prototest.solanum;

import java.util.HashMap;

/**
 * Data class used to store the XMLRPC response data.
 */
public class EggplantResponse {
    public EggplantResponse(HashMap value) {
        try {
            this.Output = ((String) value.get("Output")).trim();
            this.Result = ((String) value.get("Result")).trim();
            this.Duration = (Double) value.get("Duration");
            this.ReturnValue = ((String) value.get("ReturnValue")).trim();
        } catch (Exception e) {
            Logger.debug(e.getMessage());
        }
    }
    public String Output;
    public String Result;
    public Double Duration;
    public String ReturnValue;

}
