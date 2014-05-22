package com.prototest.solanum;

import java.io.Serializable;
import java.security.KeyPair;
import java.util.HashMap;

/**
 * Created by Brian on 5/21/2014.
 */
public class EggplantResponse {
    public EggplantResponse(HashMap value) {
        try {
            this.Output = ((String) value.get("Output")).trim();
            this.Result = ((String) value.get("Result")).trim();
            this.Duration = (Double) value.get("Duration");
            this.ReturnValue = ((String) value.get("ReturnValue")).trim();
        } catch (Exception e) {
            Logger.message(e.getMessage());
        }
    }
    public String Output;
    public String Result;
    public Double Duration;
    public String ReturnValue;

}
