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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestObserverSupport {

  private static final Logger logger = LoggerFactory
      .getLogger(TestObserverSupport.class);

  private ObserverSupport observerSupport;

  @Before
  public void setup() {
    observerSupport = new ObserverSupport();
  }

  @Test
  public void testObserverSupport() {
    Assert.assertNotNull(observerSupport);
    Assert.assertEquals(0, observerSupport.getObservers().size());
  }

  @Test
  public void testDispatchEvent() {
    ObserverEvent<String> event;
    DebuggingObserver observer;

    event = ObserverEvent.withTypeAndSubject("test", "Test event");

    Assert.assertNotNull(event);

    try {
      observerSupport.dispatchEvent(event);
    } catch (ObserverException e) {
      Assert.fail("Caught exception during event dispatching - "
          + e.getMessage());

      logger.error("Exception follows.", e);
    }

    observer = new DebuggingObserver();

    observerSupport.addObserver(observer);

    Assert.assertEquals(1, observerSupport.getObservers().size());

    try {
      for (int i = 0; i < 10; i++) {
        observerSupport.dispatchEvent(event);
      }
    } catch (ObserverException e) {
      Assert.fail("Caught exception while dispatching events - "
          + e.getMessage());

      logger.error("Exception follows.", e);
    }

    Assert.assertEquals(10, observer.getCount());
  }

  private static class DebuggingObserver implements Observer {

    private static final Logger logger = LoggerFactory
        .getLogger(DebuggingObserver.class);

    private long count;

    @Override
    public void onEvent(ObserverEvent<?> event) throws ObserverException {
      count++;

      logger.debug("Received event #" + count + " event:" + event);
    }

    public long getCount() {
      return count;
    }

  }

}
