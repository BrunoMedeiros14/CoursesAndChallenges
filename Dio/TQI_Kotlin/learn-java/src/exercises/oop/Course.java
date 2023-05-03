package exercises.oop;

public class Course extends Content {

  private int workload;

  public Course(String title, String description, int workload) {
    this.title = title;
    this.description = description;
    this.workload = workload;
  }

  public double getXp() {
    return DEFAULT_XP * this.workload;
  }

  @Override
  public String toString() {
    return "Courses={" +
        "title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", workload=" + workload + "}";
  }

}