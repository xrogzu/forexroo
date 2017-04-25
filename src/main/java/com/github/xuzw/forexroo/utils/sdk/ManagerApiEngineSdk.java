package com.github.xuzw.forexroo.utils.sdk;

import java.io.IOException;

import com.github.xuzw.api_engine_sdk.model.EngineDefinition;
import com.github.xuzw.api_engine_sdk.utils.ApiDocumentUtils;
import com.github.xuzw.api_engine_sdk.utils.ApiEngineGeneratorUtils;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年4月25日 上午11:49:45
 */
public class ManagerApiEngineSdk {
    public static void main(String[] args) throws IOException {
        String srcFolder = "src/main/java";
        EngineDefinition engineDefinition = ApiEngineGeneratorUtils.buildEngineDefinition("design/manager.api.json");
        ApiEngineGeneratorUtils.updateApiJavaFiles(srcFolder, engineDefinition);
        System.out.println("ApiEngineGeneratorUtils updateApiJavaFiles done.");
        ApiEngineGeneratorUtils.deleteUnusedApiJavaFiles(srcFolder, engineDefinition);
        System.out.println("ApiEngineGeneratorUtils deleteUnusedApiJavaFiles done.");
        ApiDocumentUtils.writeApiHtmlDocumentFile("doc", engineDefinition);
        System.out.println("ApiDocumentUtils writeApiHtmlDocumentFile done.");
    }
}
