package com.prototest.solanum;

import junit.framework.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Brian on 5/12/2014.
 */
public class Verifications {
    static class Verification{
        Verification(String errorMesage,String imagePath,boolean passed)   {
            this.errorMessage = errorMesage;
            this.imagePath = imagePath;
            this.passed = passed;
        }
        Verification(String errorMesage, boolean passed)   {
            this.errorMessage = errorMesage;
            this.imagePath = "";
            this.passed = passed;
        }
        public String errorMessage;
        public String imagePath;
        public boolean passed;
    }

    private static List<Verification> verifications = new LinkedList<Verification>();

    public static List<Verification> getVerifications(){
         return verifications;
    }


    public static void assertVerifications(){
        int numFailed = 0;
        for (Verification verification : verifications) {
            if (!verification.passed) {
                numFailed++;
            }
        }
        if(numFailed>0){
            Assert.fail("The test failed due to Verification Errors");
        }
    }
    public static void addVerification(String message,boolean passed){
        if(passed){
            Logger.message(String.format("Verification Passed : %S", message));
            verifications.add(new Verification(message,true));
        }
        else{
            String filePath = "";//EggplantTestBase.driver.getScreenshot();
            Logger.error(String.format("Verification Failed : %S", message));
            verifications.add(new Verification(message,filePath,false));
        }
    }

    public static void addVerification(String message, String filePath, boolean passed){
        if(passed){
            Logger.message(String.format("Verification Passed : %S", message));
        }
        else{
            Logger.error(String.format("Verification Failed : %S", message));

        }
        verifications.add(new Verification(message,filePath,false));
    }


}

