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
 * File format
 **/
@ApiModel(description = "File format")
public class FileFormat  {
  
  private String mimetype = null;
  private String name = null;

  
  /**
   * Mimetype
   **/
  @ApiModelProperty(required = true, value = "Mimetype")
  @JsonProperty("mimetype")
  public String getMimetype() {
    return mimetype;
  }
  public void setMimetype(String mimetype) {
    this.mimetype = mimetype;
  }

  
  /**
   * Friendly Name
   **/
  @ApiModelProperty(required = true, value = "Friendly Name")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class FileFormat {\n");
    
    sb.append("  mimetype: ").append(mimetype).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
