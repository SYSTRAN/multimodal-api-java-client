package net.systran.platform.multimodal.client;

import net.systran.platform.multimodal.client.api.SpeechApi;
import net.systran.platform.multimodal.client.auth.ApiKeyAuth;
import net.systran.platform.multimodal.client.model.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestSpeech {
    public static SpeechApi getSpeechApi() throws IOException {
        ApiClient apc = new ApiClient();
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) apc.getAuthentication("apiKey");
        String apiKey = ApiClient.LoadAPIKey(".//apiKey.txt");
        apiKeyAuth.setApiKey(apiKey);
        return new SpeechApi(apc);
    }

    @Test
    public void testMultimodalSpeechSupportedLanguagesGet() throws ApiException, IOException {
        SpeechApi api = getSpeechApi();
        SpeechSupportedLanguagesResponse speechSupportedLanguagesResponse = api.multimodalSpeechSupportedLanguagesGet(null);
        System.out.println(speechSupportedLanguagesResponse.toString());
    }

    @Test
    public void testMultimodalSpeechTranscribeGet() throws ApiException, IOException {
        SpeechApi api = getSpeechApi();
        File inputFile = new File(".//src//test//java//net//systran//platform//multimodal//client//test.mp3");
        String lang = "en";
        SpeechTranscribeResponse speechTranscribeResponse = api.multimodalSpeechTranscribeGet(inputFile, lang, null, null, null, null);
        System.out.println(speechTranscribeResponse.toString());
    }

    @Test
    public void testMultimodalSpeechTranscribeGetWithModel() throws ApiException, IOException {
        SpeechApi api = getSpeechApi();
        File inputFile = new File(".//src//test//java//net//systran//platform//multimodal//client//test.mp3");
        String lang = "en";
        String model = "eng";
        SpeechTranscribeResponse speechTranscribeResponse = api.multimodalSpeechTranscribeGet(inputFile, lang, model, null, null, null);
        System.out.println(speechTranscribeResponse.toString());
    }

    @Test
    public void testMultimodalSpeechDetectLanguageGet() throws ApiException, IOException {
        SpeechApi api = getSpeechApi();
        File inputFile = new File(".//src//test//java//net//systran//platform//multimodal//client//test.mp3");
        SpeechDetectLanguageResponse speechDetectLanguageResponse = api.multimodalSpeechDetectLanguageGet(inputFile, null, null, null);
        System.out.println(speechDetectLanguageResponse.toString());
    }

    @Test
    public void testMultimodalSpeechSegmentGet() throws ApiException, IOException {
        SpeechApi api = getSpeechApi();
        File inputFile = new File(".//src//test//java//net//systran//platform//multimodal//client//test.mp3");
        SpeechSegmentResponse speechSegmentResponse = api.multimodalSpeechSegmentGet(inputFile, null, null, null);
        System.out.println(speechSegmentResponse.toString());
    }

    @Test
    public void testMultimodalSpeechAlignGet() throws ApiException, IOException {
        SpeechApi api = getSpeechApi();
        File inputFile = new File(".//src//test//java//net//systran//platform//multimodal//client//test.mp3");
        File inputTextFile = new File(".//src//test//java//net//systran//platform//multimodal//client//test_mp3.txt");
        String lang = "en";
        SpeechAlignResponse speechAlignResponse = api.multimodalSpeechAlignGet(inputFile, inputTextFile, lang, null, null, null);
        System.out.println(speechAlignResponse.toString());
    }
}
