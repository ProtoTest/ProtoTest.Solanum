package com.prototest;

import com.sun.codemodel.internal.JClassAlreadyExistsException;
import com.sun.codemodel.internal.JCodeModel;
import com.sun.codemodel.internal.JDefinedClass;
import com.sun.codemodel.internal.JExpr;
import com.sun.codemodel.internal.JFieldRef;
import com.sun.codemodel.internal.JFormatter;
import com.sun.codemodel.internal.JMod;
import com.sun.codemodel.internal.JType;
import com.sun.codemodel.internal.writer.SingleStreamCodeWriter;

import java.util.List;
import java.util.Map;

/**
 */
public class JavaAssetsClass {
    private final EggplantSuite suite;

    public JavaAssetsClass(EggplantSuite suite) {
        this.suite = suite;
    }

    public String generateClass() throws Exception {
        JCodeModel codeModel = new JCodeModel();
        JDefinedClass mainClazz = codeModel._class("com.prototest.EggplantSuite");
        for (Map.Entry<String, List<EggplantSuite.AssetEntry>> deviceAssets : suite.getAssets().entrySet()) {
            JDefinedClass deviceResources = mainClazz._class(JMod.PUBLIC + JMod.STATIC, deviceAssets.getKey());
            for (EggplantSuite.AssetEntry asset : deviceAssets.getValue()) {
                if (deviceResources.fields().containsKey(asset.getAssetName())) {
                    System.out.println("Duplicate asset: " + deviceAssets.getKey() + " " + asset.getAssetName() + " " + asset.getAssetPath());
                    continue;
                }
                deviceResources.field(JMod.PUBLIC + JMod.STATIC + JMod.FINAL, String.class, asset.getAssetName(), JExpr.lit(asset.getAssetPath()));
            }
        }
        codeModel.build(new SingleStreamCodeWriter(System.out));
        return null;
    }
}
