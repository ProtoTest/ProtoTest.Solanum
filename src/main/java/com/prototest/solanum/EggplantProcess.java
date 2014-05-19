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
    private ProcessBuilder command;
    private Thread processLogger;

    EggplantProcess() {
        String runScriptPath = Config.runScriptPath;

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            runScriptPath = "\"" + runScriptPath + "\"";
        } else {
            runScriptPath = runScriptPath.replace(" ", "\\ ");
        }
        this.command = new ProcessBuilder(runScriptPath, "-driveport", Config.drivePort, "-drivelogging", Config.driveLoggingLevel);
        this.command.redirectErrorStream(true);
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

            Logger.message("Executing command : " + String.join(" ", command.command()));
            eggplantDrive = command.start();

            BufferedReader input = new BufferedReader
                    (new InputStreamReader(eggplantDrive.getInputStream()));
            while ((line = input.readLine()) != null) {
                Logger.message(line);
                if (line.contains("No valid License")) {
                    Assert.fail("No valid eggplant license was found.  Please launch the eggplant GUI, add a license, and try again.");
                }
                if (line.contains("Starting eggPlant Drive")) {
                    input.close();
                    Logger.message("eggPlant Drive started on port " + Config.drivePort);
                    processLogger = new Thread(new ProcessLogger(eggplantDrive));
                    processLogger.start();
                    return;
                }
            }
            Logger.error("eggPlant Drive did not start.");
            input.close();
        } catch (IOException e) {
            Logger.error("Exception caught starting eggplant : " + e.getMessage());
        }
        throw new RuntimeException("Failed to start eggPlant Drive.");
    }

    private class ProcessLogger implements Runnable {

        private final BufferedReader input;

        public ProcessLogger(Process process) {
            this.input = new BufferedReader
                    (new InputStreamReader(eggplantDrive.getInputStream()));
        }

        @Override
        public void run() {
            String line;
            try {
                while ((line = input.readLine()) != null) {
                    Logger.message(line);
                }
            } catch (IOException e) {
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }
    }

}
