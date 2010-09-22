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

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Support object to allow developers to easily add observation to objects
 * without requiring them to subclass a special class.
 * 
 * Developers may add observation support by implementing the {@link Observable}
 * interface and simply delegating to an instance of this class.
 * {@link ObserverEvent}s can be dispatched to registered {@link Observer}s by
 * calling {@link #dispatchEvent(ObserverEvent)}.
 */
public class ObserverSupport {

  private static final Logger logger = LoggerFactory
      .getLogger(ObserverSupport.class);

  private List<Observer> observers;

  /**
   * Create a new instance of {@link ObserverSupport}.
   */
  public ObserverSupport() {
    observers = new LinkedList<Observer>();
  }

  /**
   * Register an {@code observer}.
   * 
   * @param observer
   *          Observer instance that should receive events.
   */
  public void addObserver(Observer observer) {
    observers.add(observer);

    logger.info("Added observer:" + observer);
  }

  /**
   * Unregister an {@code observer}.
   * 
   * @param observer
   *          Observer instance that should no longer receive events.
   */
  public void removeObserver(Observer observer) {
    boolean removed;

    removed = observers.remove(observer);

    if (removed) {
      logger.info("Removed observer:" + observer);
    } else {
      logger.warn("Attempt to remove an unknown observer:" + observer);
    }
  }

  /**
   * Synchronously dispatch an {@link ObserverEvent} to all currently registered
   * {@link Observer}s.
   * 
   * @param event
   *          Event to dispatch.
   * @throws ObserverException
   *           Indicates an {@link Observer} failed to handle an event.
   */
  public void dispatchEvent(ObserverEvent<?> event) throws ObserverException {
    for (Observer observer : observers) {
      observer.onEvent(event);
    }
  }

  public List<Observer> getObservers() {
    return observers;
  }

  public void setObservers(List<Observer> observers) {
    this.observers = observers;
  }

}
