package com.prototest.solanum;

import junit.framework.Assert;
import org.testng.Reporter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Brian on 5/12/2014.
 */
public class EggplantProcess {
    private static Process eggplantDrive = null;
    private static String command = String.format("\"%s\" -driveport %s -drivelogging %s",Config.runScriptPath,Config.drivePort,Config.driveLoggingLevel);

    public static void Stop(){
        try {
            if(eggplantDrive!=null){
                eggplantDrive.destroy();
                eggplantDrive.waitFor();
                eggplantDrive = null;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Kill();
        }
    }

    public static void Kill(){

        Runtime rt = Runtime.getRuntime();
        try {
            if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)
                rt.exec("taskkill  /F /IM eggPlant.exe");
            else
            {
                //ToDO  Unix implementation needs to be built and tested
                throw new NotImplementedException();
            }
                rt.exec("kill -9 ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        eggplantDrive = null;

    }

    public static void Start(){
        if(eggplantDrive!=null)
            return;
        String line = "";
        try {
            System.out.println("Executing command : " + command);
            eggplantDrive = Runtime.getRuntime().exec(command);

            BufferedReader input =  new BufferedReader
                    (new InputStreamReader(eggplantDrive.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
                if(line.contains("No valid License")){
                    Assert.fail("No valid eggplant license was found.  Please launch the eggplant GUI, add a license, and try again.");
                }
                if(line.contains("Starting eggPlant Drive")){
                    break;
                }
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
