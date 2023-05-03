package exercises.oop;

import java.time.LocalDate;

public class Mentoring extends Content {
  LocalDate date;

  public Mentoring(String title, String description) {
    this.title = title;
    this.description = description;
    this.date = LocalDate.now();
  }

  public double getXp() {
    return DEFAULT_XP * 20;
  }

  @Override
  public String toString() {
    return "Courses={" +
        "title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", date=" + date + "}";
  }
}
