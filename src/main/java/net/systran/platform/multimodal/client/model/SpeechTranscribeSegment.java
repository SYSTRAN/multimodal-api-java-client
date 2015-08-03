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

import java.util.*;
import net.systran.platform.multimodal.client.model.SpeechWord;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SpeechTranscribeSegment  {
  
  private Integer channel = null;
  private String speaker = null;
  private Double speakerConfidence = null;
  private Double start = null;
  private Double end = null;
  private String lang = null;
  private Double langConfidence = null;
  private List<SpeechWord> words = new ArrayList<SpeechWord>() ;

  
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
   * Speaker id
   **/
  @ApiModelProperty(required = true, value = "Speaker id")
  @JsonProperty("speaker")
  public String getSpeaker() {
    return speaker;
  }
  public void setSpeaker(String speaker) {
    this.speaker = speaker;
  }

  
  /**
   * Confidence for the detected speaker
   **/
  @ApiModelProperty(required = true, value = "Confidence for the detected speaker")
  @JsonProperty("speakerConfidence")
  public Double getSpeakerConfidence() {
    return speakerConfidence;
  }
  public void setSpeakerConfidence(Double speakerConfidence) {
    this.speakerConfidence = speakerConfidence;
  }

  
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
   * End time (in seconds)
   **/
  @ApiModelProperty(required = true, value = "End time (in seconds)")
  @JsonProperty("end")
  public Double getEnd() {
    return end;
  }
  public void setEnd(Double end) {
    this.end = end;
  }

  
  /**
   * Detected language ([details](#description_langage_code_values))
   **/
  @ApiModelProperty(required = true, value = "Detected language ([details](#description_langage_code_values))")
  @JsonProperty("lang")
  public String getLang() {
    return lang;
  }
  public void setLang(String lang) {
    this.lang = lang;
  }

  
  /**
   * Confidence for the detected language
   **/
  @ApiModelProperty(required = true, value = "Confidence for the detected language")
  @JsonProperty("langConfidence")
  public Double getLangConfidence() {
    return langConfidence;
  }
  public void setLangConfidence(Double langConfidence) {
    this.langConfidence = langConfidence;
  }

  
  /**
   * Array of words
   **/
  @ApiModelProperty(required = true, value = "Array of words")
  @JsonProperty("words")
  public List<SpeechWord> getWords() {
    return words;
  }
  public void setWords(List<SpeechWord> words) {
    this.words = words;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpeechTranscribeSegment {\n");
    
    sb.append("  channel: ").append(channel).append("\n");
    sb.append("  speaker: ").append(speaker).append("\n");
    sb.append("  speakerConfidence: ").append(speakerConfidence).append("\n");
    sb.append("  start: ").append(start).append("\n");
    sb.append("  end: ").append(end).append("\n");
    sb.append("  lang: ").append(lang).append("\n");
    sb.append("  langConfidence: ").append(langConfidence).append("\n");
    sb.append("  words: ").append(words).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
