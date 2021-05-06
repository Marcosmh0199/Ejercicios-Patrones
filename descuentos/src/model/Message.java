package model;

public class Message {
  private String subject;
  private String from;
  private String to;
  private String body;

  public Message(String subject, String from, String to, String body){
    setSubject(subject);
    setFrom(from);
    setTo(to);
    setBody(body);
  }


  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }

  public String getTo() {
    return to;
  }
  public void setTo(String to) {
    this.to = to;
  }

  public String getFrom() {
    return from;
  }
  public void setFrom(String from) {
    this.from = from;
  }

  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  
}
