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

/**
 * Describes an event that has occurred within an {@link Observable} object.
 * 
 * Each event has an event type which is an arbitrary string, a subject (the
 * instance of the {@link Observable} object) from which it was generated, and a
 * map of free form, optional parameters that are specific the given event.
 * 
 * To simplify event creation, developers may use the
 * {@link #withTypeAndSubject(String, Object)} factory method. This method
 * returns {@code this} to allow method chaining. There is also a
 * {@link #withParameter(String, Object)} method to allow fluent append of
 * parameters.
 * 
 * Ex.
 * 
 * <code>
 *  ObserverEvent&lt;MyObject&gt; event;
 * 
 *  event = ObserverEvent.withTypeAndSubject("important.action", this)
 *    .withParameter("timestamp", System.currentTimeInMillis())
 *    .withParameter("index", i++);
 * </code>
 * 
 * @param <T>
 *          The type of the subject (target) object.
 */
public class ObserverEvent<T> {

  private String eventType;
  private T subject;
  private HashMap<String, Object> parameters;

  /**
   * Factory method to assist in creating events. This method is strongly
   * preferred over simply using the constructor as it guarantees the event type
   * and subject are set (although the constructor is left public for special
   * cases). This method returns {@code this} to support method chaining with
   * the {@link #withParameter(String, Object)} method.
   * 
   * @param <T>
   *          The type of the subject object.
   * @param eventType
   *          The name of the event.
   * @param subject
   *          The subject object.
   * @return
   */
  public static <T> ObserverEvent<T> withTypeAndSubject(String eventType,
      T subject) {
    ObserverEvent<T> event;

    event = new ObserverEvent<T>();

    event.setEventType(eventType);
    event.setSubject(subject);

    return event;
  }

  /**
   * Convenience method that allows one to set parameters in a fluent way.
   * Returns {@code this} to facilitate chaining.
   * 
   * @param key
   *          Parameter name.
   * @param value
   *          Parameter value.
   * @return itself to allow chaining.
   */
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
