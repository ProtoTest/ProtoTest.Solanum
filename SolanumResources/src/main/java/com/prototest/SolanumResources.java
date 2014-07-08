package com.prototest;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 */
public class SolanumResources {
    public static void main(String[] args) throws Exception {
        EggplantSuite suite = new EggplantSuite("/Users/andrewtaggart/workspace/ProtoTest.Solanum/EggplantSuites/DishAnywhere.suite");
        suite.readAssets();
        JavaAssetsClass classGen = new JavaAssetsClass(suite);
        classGen.generateClass();
    }
}
