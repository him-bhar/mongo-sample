package com.himanshu.sample.mongodb.domain;

import com.google.gson.annotations.SerializedName;

public class Message {

  private static class ObjectId {
    private String $oid;

    public String get$Oid() {
      return $oid;
    }

    public void set$Oid(String oid) {
      this.$oid = oid;
    }

    @Override
    public String toString() {
      return "ObjectId{" +
              "oid='" + $oid + '\'' +
              '}';
    }
  }

  @SerializedName("_id")
  private ObjectId id;
  private String message;
  private String from;
  private String to;

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  @Override
  public String toString() {
    return "Message{" +
            "id=" + id +
            ", message='" + message + '\'' +
            ", from='" + from + '\'' +
            ", to='" + to + '\'' +
            '}';
  }
}
