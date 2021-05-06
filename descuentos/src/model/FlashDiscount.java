package model;
import java.time.LocalDateTime;

public class FlashDiscount {
  private LocalDateTime begDate;
  private LocalDateTime endDate;
  private int duration;

  public FlashDiscount(int duration){
    setDuration(duration);
    setBegDate();
    setEndDate();
  }

  public LocalDateTime getBegDate() {
    return begDate;
  }

  private void setBegDate() {
    this.begDate = LocalDateTime.now();
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }
  private void setEndDate() {
    this.endDate = begDate.plusMinutes(duration);
  }

  public int getDuration() {
    return duration;
  }
  private void setDuration(int duration) {
    this.duration = duration;
  }
   
}
