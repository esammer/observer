# Observer #

## Overview ##

Observer is a very simple library that allows one to create observable objects
and connect observers to them to receive interesting events (the observer
pattern).

## Basic Usage ##

Assuming we have a class called PluginRegistry and we want to send events to
observers when new plugins are loaded:

    public class PluginRegistry implements Observable {

      private ObserverSupport observerSupport = new ObserverSupport();

      public void loadPlugin(Class<?> cls) {
        // ...

        // Tell all observers currently registered that we've loaded a plugin.
        observerSupport.dispatchEvent(
          ObserverEvent.withTypeAndSubject("plugin.loaded", this)
            .withParameter("time", System.currentTimeInMillis())
            .withParameter("plugin.class.name", cls.getClassName())
        );
      }

      @Override
      public void addObserver(Observer o) {
        // Delegate to ObserverSupport for reg / unreg of observers.
        observerSupport.addObserver(o);
      }

      @Override
      public void removeObserver(Observer o) {
        observerSupport.removeObserver(o);
      }

    }

    public class MyClass implements Observer {

      private PluginRegistry pluginReg = new PluginRegistry();

      public MyClass() {
        // Ask PluginRegistry to let us know if anything interesting happens.
        pluginReg.addObserver(this);
      }

      @Override
      public void onEvent(ObserverEvent<?> event) throws ObserverException {
        // We can figure out what type of event we see by the eventType
        // property.
        if (event.getEventType().equals("plugin.loaded")) {
          // event.getSubject(), event.getParameters(), ...
        }
      }

    }

None of the observer classes are thread safe.

## Project Hosting ##

This project lives on Github @ http://github.com/esammer/observer

## Author ##

E. Sammer <eric@lifeless.net>

## License ##

This software is distributed under the Apache Software License version 2.0.

See http://www.apache.org/licenses/LICENSE-2.0 for a copy of the license.

