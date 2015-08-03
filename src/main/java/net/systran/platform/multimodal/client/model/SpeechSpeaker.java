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

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;

@ApiModel(description = "")
public class SpeechSpeaker  {
  
  private String id = null;
  private Integer channel = null;
  private Double duration = null;
  public enum GenderEnum {
    female("female"), male("male"); 

    private final String text;
    private static Map<String, GenderEnum> namesMap = new HashMap<String, GenderEnum>();
    
    static { 
      namesMap.put("female", female);
      namesMap.put("male", male);
    }
    
    private GenderEnum(final String text) {
      this.text = text;
    }

    @JsonCreator
    public static GenderEnum forValue(String value) throws Exception {
      if (namesMap.get(value) == null) {
        throw new Exception("Invalid enum value");
      }

      return namesMap.get(value);
    }

    @Override
    public String toString() {
      return text;
    }
  };
  private GenderEnum gender = null;

  
  /**
   * Speaker id
   **/
  @ApiModelProperty(required = true, value = "Speaker id")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Channel id
   **/
  @ApiModelProperty(required = true, value = "Channel id")
  @JsonProperty("channel")
  public Integer getChannel() {
    return channel;
  }
  public void setChannel(Integer channel) {
    this.channel = channel;
  }

  
  /**
   * Speech duration (in seconds)
   **/
  @ApiModelProperty(required = true, value = "Speech duration (in seconds)")
  @JsonProperty("duration")
  public Double getDuration() {
    return duration;
  }
  public void setDuration(Double duration) {
    this.duration = duration;
  }

  
  /**
   * Gender
   **/
  @ApiModelProperty(required = true, value = "Gender")
  @JsonProperty("gender")
  public GenderEnum getGender() {
    return gender;
  }
  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpeechSpeaker {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  channel: ").append(channel).append("\n");
    sb.append("  duration: ").append(duration).append("\n");
    sb.append("  gender: ").append(gender).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
