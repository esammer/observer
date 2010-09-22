/*
 * Copyright 2010 E. Sammer
 * 
 * I (Eric Sammer) hereby license this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package net.lifeless.observer;

import java.util.HashMap;

public class ObserverEvent<T> {

  private String eventType;
  private T subject;
  private HashMap<String, Object> parameters;

  public static <T> ObserverEvent<T> withTypeAndSubject(String eventType,
      T subject) {
    ObserverEvent<T> event;

    event = new ObserverEvent<T>();

    event.setEventType(eventType);
    event.setSubject(subject);

    return event;
  }

  public ObserverEvent<T> withParameter(String key, Object value) {
    getParameters().put(key, value);

    return this;
  }

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public T getSubject() {
    return subject;
  }

  public void setSubject(T subject) {
    this.subject = subject;
  }

  public HashMap<String, Object> getParameters() {
    return parameters;
  }

  public void setParameters(HashMap<String, Object> parameters) {
    this.parameters = parameters;
  }

}
