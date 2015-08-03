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
public class SpeechWord  {
  
  private Double start = null;
  private Double duration = null;
  private Double confidence = null;
  private String text = null;

  
  /**
   * Start time (in seconds)
   **/
  @ApiModelProperty(required = true, value = "Start time (in seconds)")
  @JsonProperty("start")
  public Double getStart() {
    return start;
  }
  public void setStart(Double start) {
    this.start = start;
  }

  
  /**
   * Duration (in seconds)
   **/
  @ApiModelProperty(required = true, value = "Duration (in seconds)")
  @JsonProperty("duration")
  public Double getDuration() {
    return duration;
  }
  public void setDuration(Double duration) {
    this.duration = duration;
  }

  
  /**
   * Confidence
   **/
  @ApiModelProperty(required = true, value = "Confidence")
  @JsonProperty("confidence")
  public Double getConfidence() {
    return confidence;
  }
  public void setConfidence(Double confidence) {
    this.confidence = confidence;
  }

  
  /**
   * Word text
   **/
  @ApiModelProperty(required = true, value = "Word text")
  @JsonProperty("text")
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpeechWord {\n");
    
    sb.append("  start: ").append(start).append("\n");
    sb.append("  duration: ").append(duration).append("\n");
    sb.append("  confidence: ").append(confidence).append("\n");
    sb.append("  text: ").append(text).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
