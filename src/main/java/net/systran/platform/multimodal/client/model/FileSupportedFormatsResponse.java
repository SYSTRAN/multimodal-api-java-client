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

package net.systran.platform.multimodal.client.model;

import net.systran.platform.multimodal.client.model.FileFormat;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response for a File Supported Formats request
 **/
@ApiModel(description = "Response for a File Supported Formats request")
public class FileSupportedFormatsResponse  {
  
  private List<FileFormat> formats = new ArrayList<FileFormat>() ;

  
  /**
   * List of supported formats
   **/
  @ApiModelProperty(required = true, value = "List of supported formats")
  @JsonProperty("formats")
  public List<FileFormat> getFormats() {
    return formats;
  }
  public void setFormats(List<FileFormat> formats) {
    this.formats = formats;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileSupportedFormatsResponse {\n");
    
    sb.append("  formats: ").append(formats).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
