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

import net.systran.platform.multimodal.client.model.SpeechChannel;
import net.systran.platform.multimodal.client.model.SpeechTranscribeSpeaker;
import java.util.*;
import net.systran.platform.multimodal.client.model.SpeechTranscribeSegment;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response of a Speech Transcribe request
 **/
@ApiModel(description = "Response of a Speech Transcribe request")
public class SpeechTranscribeResponse  {
  
  private List<SpeechChannel> channels = new ArrayList<SpeechChannel>() ;
  private List<SpeechTranscribeSpeaker> speakers = new ArrayList<SpeechTranscribeSpeaker>() ;
  private List<SpeechTranscribeSegment> segments = new ArrayList<SpeechTranscribeSegment>() ;

  
  /**
   * Array of channels
   **/
  @ApiModelProperty(required = true, value = "Array of channels")
  @JsonProperty("channels")
  public List<SpeechChannel> getChannels() {
    return channels;
  }
  public void setChannels(List<SpeechChannel> channels) {
    this.channels = channels;
  }

  
  /**
   * Array of speakers
   **/
  @ApiModelProperty(required = true, value = "Array of speakers")
  @JsonProperty("speakers")
  public List<SpeechTranscribeSpeaker> getSpeakers() {
    return speakers;
  }
  public void setSpeakers(List<SpeechTranscribeSpeaker> speakers) {
    this.speakers = speakers;
  }

  
  /**
   * Array of segments
   **/
  @ApiModelProperty(required = true, value = "Array of segments")
  @JsonProperty("segments")
  public List<SpeechTranscribeSegment> getSegments() {
    return segments;
  }
  public void setSegments(List<SpeechTranscribeSegment> segments) {
    this.segments = segments;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpeechTranscribeResponse {\n");
    
    sb.append("  channels: ").append(channels).append("\n");
    sb.append("  speakers: ").append(speakers).append("\n");
    sb.append("  segments: ").append(segments).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
