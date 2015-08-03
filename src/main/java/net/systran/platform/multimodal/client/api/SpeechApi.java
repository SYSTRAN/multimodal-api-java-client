/*
 * Copyright © 2015 SYSTRAN Software, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.systran.platform.multimodal.client.api;

import net.systran.platform.multimodal.client.ApiException;
import net.systran.platform.multimodal.client.ApiClient;
import net.systran.platform.multimodal.client.Configuration;

import net.systran.platform.multimodal.client.model.*;

import java.util.*;

import java.io.File;
import net.systran.platform.multimodal.client.model.SpeechAlignResponse;
import net.systran.platform.multimodal.client.model.SpeechDetectLanguageResponse;
import net.systran.platform.multimodal.client.model.SpeechSegmentResponse;
import net.systran.platform.multimodal.client.model.SpeechSupportedLanguagesResponse;
import net.systran.platform.multimodal.client.model.SpeechTranscribeResponse;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import javax.ws.rs.core.MediaType;

import java.io.InputStream;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class SpeechApi {
  private ApiClient apiClient;

  public SpeechApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SpeechApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Align speech
   * Align text and audio files.\n
   * @param audioFile Audio file ([details](#description_audio_files)).\n
   * @param textFile Plain text file, ASCII, ISO-8859 or UTF8 encoded.\n\nThe text should include one sentence or clause per line ending with a punctuation mark.\n
   * @param lang Language code of the input ([details](#description_langage_code_values))
   * @param model Model name\n
   * @param sampling Sampling quality of the audio file.\n * high: wide band audio such as radio and TV broadcast (sampling higher or equal to 16KHz)\n * low: telephone data with sampling rates higher or equal to 8KHz. It is highly recommended to not use a bit rate lower than 32Kbps.\n
   * @param callback Javascript callback function name for JSONP Support\n
   * @return SpeechAlignResponse
   */
  public SpeechAlignResponse multimodalSpeechAlignGet (File audioFile, File textFile, String lang, String model, String sampling, String callback) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'audioFile' is set
    if (audioFile == null) {
       throw new ApiException(400, "Missing the required parameter 'audioFile' when calling multimodalSpeechAlignGet");
    }
    
    // verify the required parameter 'textFile' is set
    if (textFile == null) {
       throw new ApiException(400, "Missing the required parameter 'textFile' when calling multimodalSpeechAlignGet");
    }
    
    // verify the required parameter 'lang' is set
    if (lang == null) {
       throw new ApiException(400, "Missing the required parameter 'lang' when calling multimodalSpeechAlignGet");
    }
    

    // create path and map variables
    String path = "/multimodal/speech/align".replaceAll("\\{format\\}","json");

    // query params
    Map<String, Object> queryParams = new HashMap<String, Object>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (lang != null)
      queryParams.put("lang", apiClient.parameterToString(lang));
    if (model != null)
      queryParams.put("model", apiClient.parameterToString(model));
    if (sampling != null)
      queryParams.put("sampling", apiClient.parameterToString(sampling));
    if (callback != null)
      queryParams.put("callback", apiClient.parameterToString(callback));
    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "multipart/form-data", "application/x-www-form-urlencoded"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if (audioFile != null) {
        hasFields = true;
        mp.field("audioFile", audioFile.getName());
        mp.bodyPart(new FileDataBodyPart("audioFile", audioFile, MediaType.MULTIPART_FORM_DATA_TYPE));
      }
      
      if (textFile != null) {
        hasFields = true;
        mp.field("textFile", textFile.getName());
        mp.bodyPart(new FileDataBodyPart("textFile", textFile, MediaType.MULTIPART_FORM_DATA_TYPE));
      }
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
      
      
    }

    try {
      String[] authNames = new String[] { "accessToken", "apiKey" };
      ClientResponse response = apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){ 
        return (SpeechAlignResponse) apiClient.deserialize(response, "", SpeechAlignResponse.class); 
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Speech language detection
   * Detect languages from an audio file.\n
   * @param audioFile Audio file ([details](#description_audio_files)).\n
   * @param sampling Sampling quality of the audio file.\n * high: wide band audio such as radio and TV broadcast (sampling higher or equal to 16KHz)\n * low: telephone data with sampling rates higher or equal to 8KHz. It is highly recommended to not use a bit rate lower than 32Kbps.\n
   * @param maxSpeaker Maximum number of speakers. Default 1 for low sampling and infinity for high sampling
   * @param callback Javascript callback function name for JSONP Support\n
   * @return SpeechDetectLanguageResponse
   */
  public SpeechDetectLanguageResponse multimodalSpeechDetectLanguageGet (File audioFile, String sampling, Integer maxSpeaker, String callback) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'audioFile' is set
    if (audioFile == null) {
       throw new ApiException(400, "Missing the required parameter 'audioFile' when calling multimodalSpeechDetectLanguageGet");
    }
    

    // create path and map variables
    String path = "/multimodal/speech/detectLanguage".replaceAll("\\{format\\}","json");

    // query params
    Map<String, Object> queryParams = new HashMap<String, Object>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (sampling != null)
      queryParams.put("sampling", apiClient.parameterToString(sampling));
    if (maxSpeaker != null)
      queryParams.put("maxSpeaker", apiClient.parameterToString(maxSpeaker));
    if (callback != null)
      queryParams.put("callback", apiClient.parameterToString(callback));
    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "multipart/form-data", "application/x-www-form-urlencoded"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if (audioFile != null) {
        hasFields = true;
        mp.field("audioFile", audioFile.getName());
        mp.bodyPart(new FileDataBodyPart("audioFile", audioFile, MediaType.MULTIPART_FORM_DATA_TYPE));
      }
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
      
    }

    try {
      String[] authNames = new String[] { "accessToken", "apiKey" };
      ClientResponse response = apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){ 
        return (SpeechDetectLanguageResponse) apiClient.deserialize(response, "", SpeechDetectLanguageResponse.class); 
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Segment speech
   * Segment an audio file.\n
   * @param audioFile Audio file ([details](#description_audio_files)).\n
   * @param sampling Sampling quality of the audio file.\n * high: wide band audio such as radio and TV broadcast (sampling higher or equal to 16KHz)\n * low: telephone data with sampling rates higher or equal to 8KHz. It is highly recommended to not use a bit rate lower than 32Kbps.\n
   * @param maxSpeaker Maximum number of speakers. Default 1 for low sampling and infinity for high sampling
   * @param callback Javascript callback function name for JSONP Support\n
   * @return SpeechSegmentResponse
   */
  public SpeechSegmentResponse multimodalSpeechSegmentGet (File audioFile, String sampling, Integer maxSpeaker, String callback) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'audioFile' is set
    if (audioFile == null) {
       throw new ApiException(400, "Missing the required parameter 'audioFile' when calling multimodalSpeechSegmentGet");
    }
    

    // create path and map variables
    String path = "/multimodal/speech/segment".replaceAll("\\{format\\}","json");

    // query params
    Map<String, Object> queryParams = new HashMap<String, Object>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (sampling != null)
      queryParams.put("sampling", apiClient.parameterToString(sampling));
    if (maxSpeaker != null)
      queryParams.put("maxSpeaker", apiClient.parameterToString(maxSpeaker));
    if (callback != null)
      queryParams.put("callback", apiClient.parameterToString(callback));
    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "multipart/form-data", "application/x-www-form-urlencoded"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if (audioFile != null) {
        hasFields = true;
        mp.field("audioFile", audioFile.getName());
        mp.bodyPart(new FileDataBodyPart("audioFile", audioFile, MediaType.MULTIPART_FORM_DATA_TYPE));
      }
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
      
    }

    try {
      String[] authNames = new String[] { "accessToken", "apiKey" };
      ClientResponse response = apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){ 
        return (SpeechSegmentResponse) apiClient.deserialize(response, "", SpeechSegmentResponse.class); 
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Supported Languages
   * List of languages in which Speech is supported.\n
   * @param callback Javascript callback function name for JSONP Support\n
   * @return SpeechSupportedLanguagesResponse
   */
  public SpeechSupportedLanguagesResponse multimodalSpeechSupportedLanguagesGet (String callback) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/multimodal/speech/supportedLanguages".replaceAll("\\{format\\}","json");

    // query params
    Map<String, Object> queryParams = new HashMap<String, Object>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (callback != null)
      queryParams.put("callback", apiClient.parameterToString(callback));
    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String[] authNames = new String[] { "accessToken", "apiKey" };
      ClientResponse response = apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){ 
        return (SpeechSupportedLanguagesResponse) apiClient.deserialize(response, "", SpeechSupportedLanguagesResponse.class); 
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Transcribe speech
   * Get text from an audio file.\n
   * @param audioFile Audio file ([details](#description_audio_files)).\n
   * @param lang Language code of the input ([details](#description_langage_code_values))
   * @param model Model name\n
   * @param sampling Sampling quality of the audio file.\n * high: wide band audio such as radio and TV broadcast (sampling higher or equal to 16KHz)\n * low: telephone data with sampling rates higher or equal to 8KHz. It is highly recommended to not use a bit rate lower than 32Kbps.\n
   * @param maxSpeaker Maximum number of speakers. Default 1 for low sampling and infinity for high sampling
   * @param callback Javascript callback function name for JSONP Support\n
   * @return SpeechTranscribeResponse
   */
  public SpeechTranscribeResponse multimodalSpeechTranscribeGet (File audioFile, String lang, String model, String sampling, Integer maxSpeaker, String callback) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'audioFile' is set
    if (audioFile == null) {
       throw new ApiException(400, "Missing the required parameter 'audioFile' when calling multimodalSpeechTranscribeGet");
    }
    
    // verify the required parameter 'lang' is set
    if (lang == null) {
       throw new ApiException(400, "Missing the required parameter 'lang' when calling multimodalSpeechTranscribeGet");
    }
    

    // create path and map variables
    String path = "/multimodal/speech/transcribe".replaceAll("\\{format\\}","json");

    // query params
    Map<String, Object> queryParams = new HashMap<String, Object>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (lang != null)
      queryParams.put("lang", apiClient.parameterToString(lang));
    if (model != null)
      queryParams.put("model", apiClient.parameterToString(model));
    if (sampling != null)
      queryParams.put("sampling", apiClient.parameterToString(sampling));
    if (maxSpeaker != null)
      queryParams.put("maxSpeaker", apiClient.parameterToString(maxSpeaker));
    if (callback != null)
      queryParams.put("callback", apiClient.parameterToString(callback));
    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "multipart/form-data", "application/x-www-form-urlencoded"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if (audioFile != null) {
        hasFields = true;
        mp.field("audioFile", audioFile.getName());
        mp.bodyPart(new FileDataBodyPart("audioFile", audioFile, MediaType.MULTIPART_FORM_DATA_TYPE));
      }
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
      
    }

    try {
      String[] authNames = new String[] { "accessToken", "apiKey" };
      ClientResponse response = apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){ 
        return (SpeechTranscribeResponse) apiClient.deserialize(response, "", SpeechTranscribeResponse.class); 
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
}
