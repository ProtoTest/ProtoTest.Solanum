package com.prototest.solanum;

/**
 * Created by Brian on 8/18/2014.
 */
public class EggplantThreadWrapper {
    Integer port;
    EggplantProcess process;
    EggplantDriver driver;
    public EggplantThreadWrapper(Integer port){
        this.port = port;
        this.process = new EggplantProcess(port);
        this.driver = new EggplantDriver("http://localhost:" + port);

    }
}
