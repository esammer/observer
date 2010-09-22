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

/**
 * An object capable of receiving events from {@link Observable} instances.
 * 
 * An observer is an object that can be registered to receive events from
 * {@link Observable} objects. When an {@code Observable} instance performs an
 * action for which it is instrumented, all registered observers will have their
 * {@link #onEvent(ObserverEvent)} method invoked.
 * 
 */
public interface Observer {

  /**
   * Handler method invoked when an {@link Observable} object does something of
   * interest.
   * 
   * @param event
   *          Details of the event that has occurred.
   * @throws ObserverException
   *           If the observer has failed to process the event.
   */
  public void onEvent(ObserverEvent<?> event) throws ObserverException;

}
