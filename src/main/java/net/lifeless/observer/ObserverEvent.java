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