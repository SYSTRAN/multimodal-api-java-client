package net.systran.platform.multimodal.client;


import net.systran.platform.multimodal.client.api.FileApi;
import net.systran.platform.multimodal.client.auth.ApiKeyAuth;
import net.systran.platform.multimodal.client.model.FileExtractTextResponse;
import net.systran.platform.multimodal.client.model.FileSupportedFormatsResponse;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static FileApi getFileApi() throws IOException {
        ApiClient apc = new ApiClient();
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) apc.getAuthentication("apiKey");
        String apiKey = ApiClient.LoadAPIKey(".//apiKey.txt");
        apiKeyAuth.setApiKey(apiKey);
        return new FileApi(apc);
    }

    @Test
    public void testMultimodalFileSupportedFormatsGet() throws ApiException, IOException {
        FileApi api = getFileApi();
        FileSupportedFormatsResponse fileSupportedFormatsResponse = api.multimodalFileSupportedFormatsGet(null, null);
        System.out.println(fileSupportedFormatsResponse.toString());
    }

    @Test
    public void testMultimodalFileExtractTextGet() throws ApiException, IOException {
        FileApi api = getFileApi();
        File inputFile = new File(".//src//test//java//net//systran//platform//multimodal//client//extract_test.html");
        FileExtractTextResponse fileExtractTextResponse = api.multimodalFileExtractTextGet(inputFile, null, null, null, null);
        System.out.println(fileExtractTextResponse.toString());
    }

    @Test
    public void testMultimodalFileExtractTextGetWithFormat() throws ApiException, IOException {
        FileApi api = getFileApi();
        File inputFile = new File(".//src//test//java//net//systran//platform//multimodal//client//extract_test.html");
        String format = "text/html";
        FileExtractTextResponse fileExtractTextResponse = api.multimodalFileExtractTextGet(inputFile, null, format, null, null);
        System.out.println(fileExtractTextResponse.toString());
    }

    @Test
    public void testMultimodalFileExtractTextGetWithFormatAndLang() throws ApiException, IOException {
        FileApi api = getFileApi();
        File inputFile = new File(".//src//test//java//net//systran//platform//multimodal//client//extract_test.html");
        String lang = "en";
        String format = "text/html";
        FileExtractTextResponse fileExtractTextResponse = api.multimodalFileExtractTextGet(inputFile, lang, format, null, null);
        System.out.println(fileExtractTextResponse.toString());
    }
}
