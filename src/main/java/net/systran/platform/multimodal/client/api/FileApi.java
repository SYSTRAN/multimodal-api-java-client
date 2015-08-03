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
import net.systran.platform.multimodal.client.model.FileExtractTextResponse;
import net.systran.platform.multimodal.client.model.FileSupportedFormatsResponse;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import javax.ws.rs.core.MediaType;

import java.io.InputStream;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class FileApi {
  private ApiClient apiClient;

  public FileApi() {
    this(Configuration.getDefaultApiClient());
  }

  public FileApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Extract text from a file
   * Extract text from a file.\n
   * @param inputFile Input File
   * @param lang Language code of the input ([details](#description_langage_code_values)) or `auto` for automatic detection
   * @param format Format of the input file.\n\nValid values are the mimetypes returned by the supportedFormats service.\n
   * @param profile Profile id\n
   * @param callback Javascript callback function name for JSONP Support\n
   * @return FileExtractTextResponse
   */
  public FileExtractTextResponse multimodalFileExtractTextGet (File inputFile, String lang, String format, Integer profile, String callback) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'inputFile' is set
    if (inputFile == null) {
       throw new ApiException(400, "Missing the required parameter 'inputFile' when calling multimodalFileExtractTextGet");
    }
    

    // create path and map variables
    String path = "/multimodal/file/extract/text".replaceAll("\\{format\\}","json");

    // query params
    Map<String, Object> queryParams = new HashMap<String, Object>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (lang != null)
      queryParams.put("lang", apiClient.parameterToString(lang));
    if (format != null)
      queryParams.put("format", apiClient.parameterToString(format));
    if (profile != null)
      queryParams.put("profile", apiClient.parameterToString(profile));
    if (callback != null)
      queryParams.put("callback", apiClient.parameterToString(callback));
    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "multipart/form-data", "application/x-www-form-urlencoded", "*/*"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if (inputFile != null) {
        hasFields = true;
        mp.field("inputFile", inputFile.getName());
        mp.bodyPart(new FileDataBodyPart("inputFile", inputFile, MediaType.MULTIPART_FORM_DATA_TYPE));
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
        return (FileExtractTextResponse) apiClient.deserialize(response, "", FileExtractTextResponse.class); 
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Supported file formats
   * Get a list of supported file formats.\n
   * @param profile Profile id\n
   * @param callback Javascript callback function name for JSONP Support\n
   * @return FileSupportedFormatsResponse
   */
  public FileSupportedFormatsResponse multimodalFileSupportedFormatsGet (Integer profile, String callback) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/multimodal/file/supportedFormats".replaceAll("\\{format\\}","json");

    // query params
    Map<String, Object> queryParams = new HashMap<String, Object>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (profile != null)
      queryParams.put("profile", apiClient.parameterToString(profile));
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
        return (FileSupportedFormatsResponse) apiClient.deserialize(response, "", FileSupportedFormatsResponse.class); 
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
}
