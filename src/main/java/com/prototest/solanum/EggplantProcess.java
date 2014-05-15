package com.prototest.solanum;

import junit.framework.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Brian on 5/12/2014.
 */
class EggplantProcess {
    private Process eggplantDrive;
    private String command;

    EggplantProcess() {
        String runScriptPath = Config.runScriptPath;

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            runScriptPath = "\"" + runScriptPath + "\"";
        } else {
            runScriptPath = runScriptPath.replace(" ", "\\ ");
        }
        this.command =
                String.format("%s -driveport %s -drivelogging %s", runScriptPath, Config.drivePort, Config.driveLoggingLevel);
    }

    void stop() {
        try {
            if (eggplantDrive != null) {
                eggplantDrive.destroy();
                eggplantDrive.waitFor();
                eggplantDrive = null;
            }
        } catch (InterruptedException e) {
            Logger.error("Exception caught stopping eggplant : " + e.getMessage());
            kill();
        }
    }

    void kill() {

        Runtime rt = Runtime.getRuntime();
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                rt.exec("taskkill  /F /IM eggPlant.exe");
            } else {
                rt.exec("pkill -9 -i eggplant");
            }
        } catch (IOException e) {
            Logger.error("Exception caught killing eggplant : " + e.getMessage());
        }
        eggplantDrive = null;

    }

    void start() {
        if (eggplantDrive != null) {
            return;
        }
        String line;
        try {
            Logger.message("Executing command : " + command);
            eggplantDrive = Runtime.getRuntime().exec(command);

            BufferedReader input = new BufferedReader
                    (new InputStreamReader(eggplantDrive.getInputStream()));
            while ((line = input.readLine()) != null) {
                Logger.message(line);
                if (line.contains("No valid License")) {
                    Assert.fail("No valid eggplant license was found.  Please launch the eggplant GUI, add a license, and try again.");
                }
                if (line.contains("Starting eggPlant Drive")) {
                    break;
                }
            }
            input.close();
        } catch (IOException e) {
            Logger.error("Exception caught starting eggplant : " + e.getMessage());
        }
    }

}
