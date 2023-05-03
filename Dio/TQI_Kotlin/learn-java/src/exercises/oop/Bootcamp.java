package exercises.oop;

// import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bootcamp {
  private String name;
  private String description;

  // private final LocalDate START_DATE = LocalDate.now();
  // private final LocalDate FINAL_DATE = START_DATE.plusDays(45);

  private Set<Dev> registeredDevs = new HashSet<>();
  private Set<Content> contents = new LinkedHashSet<>();

  public Bootcamp(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Set<Dev> getRegisteredDevs() {
    return registeredDevs;
  }

  public void registerDev(Dev dev) {
    this.registeredDevs.add(dev);
  }

  public Set<Content> getContents() {
    return contents;
  }

  public void includeContent(Content content) {
    this.contents.add(content);
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

}
