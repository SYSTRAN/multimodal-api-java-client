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


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response for a File Extract Text request
 **/
@ApiModel(description = "Response for a File Extract Text request")
public class FileExtractTextResponse  {
  
  private String text = null;
  private String format = null;

  
  /**
   * Text extracted from the input
   **/
  @ApiModelProperty(required = true, value = "Text extracted from the input")
  @JsonProperty("text")
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  
  /**
   * Format of the input
   **/
  @ApiModelProperty(required = true, value = "Format of the input")
  @JsonProperty("format")
  public String getFormat() {
    return format;
  }
  public void setFormat(String format) {
    this.format = format;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileExtractTextResponse {\n");
    
    sb.append("  text: ").append(text).append("\n");
    sb.append("  format: ").append(format).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
