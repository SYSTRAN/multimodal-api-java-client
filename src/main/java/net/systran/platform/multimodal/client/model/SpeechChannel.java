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


@ApiModel(description = "")
public class SpeechChannel  {
  
  private Integer id = null;
  private Double signalDuration = null;
  private Double speechDuration = null;

  
  /**
   * Channel id
   **/
  @ApiModelProperty(required = true, value = "Channel id")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   * Signal duration (in seconds)
   **/
  @ApiModelProperty(required = true, value = "Signal duration (in seconds)")
  @JsonProperty("signalDuration")
  public Double getSignalDuration() {
    return signalDuration;
  }
  public void setSignalDuration(Double signalDuration) {
    this.signalDuration = signalDuration;
  }

  
  /**
   * Speech duration (in seconds)
   **/
  @ApiModelProperty(required = true, value = "Speech duration (in seconds)")
  @JsonProperty("speechDuration")
  public Double getSpeechDuration() {
    return speechDuration;
  }
  public void setSpeechDuration(Double speechDuration) {
    this.speechDuration = speechDuration;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpeechChannel {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  signalDuration: ").append(signalDuration).append("\n");
    sb.append("  speechDuration: ").append(speechDuration).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
