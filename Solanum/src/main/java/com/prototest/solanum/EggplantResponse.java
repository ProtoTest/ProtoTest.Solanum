package com.prototest.solanum;

import java.io.Serializable;
import java.security.KeyPair;
import java.util.HashMap;

/**
 * Created by Brian on 5/21/2014.
 */
public class EggplantResponse {
    public EggplantResponse(HashMap<String, String> value){
        this.Output = value.get("Output;");
        this.Result = value.get("Result");
        this.Duration = value.get("Duration");
        this.ReturnValue = value.get("ReturnValue");
    }
    public final String Output;
    public final String Result;
    public final String Duration;
    public final String ReturnValue;

}
