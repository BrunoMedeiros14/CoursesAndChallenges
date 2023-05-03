package exercises.oop;

/*
 * Classe mãe a classe Courses e da classe Mentoring.
 */
public abstract class Content {
  protected static final double DEFAULT_XP = 10;

  protected String title;
  protected String description;

  public abstract double getXp();

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
