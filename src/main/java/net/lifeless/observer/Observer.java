package net.lifeless.observer;


public interface Observer {

  public void onEvent(ObserverEvent<?> event) throws ObserverException;

}
