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

public class ObserverException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ObserverException() {
    super();
  }

  public ObserverException(String message) {
    super(message);
  }

  public ObserverException(Throwable t) {
    super(t);
  }

  public ObserverException(String message, Throwable t) {
    super(message, t);
  }

}
