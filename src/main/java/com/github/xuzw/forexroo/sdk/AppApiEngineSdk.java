package com.github.xuzw.forexroo.sdk;

import java.io.IOException;

import com.github.xuzw.api_engine_sdk.model.EngineDefinition;
import com.github.xuzw.api_engine_sdk.utils.ApiDocumentUtils;
import com.github.xuzw.api_engine_sdk.utils.ApiEngineGeneratorUtils;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月25日 上午11:49:45
 */
public class AppApiEngineSdk {
    public static void main(String[] args) throws IOException {
        String srcFolder = "src/main/java";
        EngineDefinition engineDefinition = ApiEngineGeneratorUtils.buildEngineDefinition("design/app.api.json");
        ApiEngineGeneratorUtils.updateApiJavaFiles(srcFolder, engineDefinition);
        System.out.println("updateApiJavaFiles done.");
        ApiEngineGeneratorUtils.deleteUnusedApiJavaFiles(srcFolder, engineDefinition);
        System.out.println("deleteUnusedApiJavaFiles done.");
        ApiEngineGeneratorUtils.updateErrorCodeJavaFile(srcFolder, engineDefinition);
        System.out.println("updateErrorCodeJavaFile done.");
        ApiDocumentUtils.writeApiHtmlDocumentFile("doc", engineDefinition);
        System.out.println("writeApiHtmlDocumentFile done.");
    }
}
