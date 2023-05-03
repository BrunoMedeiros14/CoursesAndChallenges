package exercises.oop;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Optional;

public class Dev {
  String name;

  /*
   * Demonstração do uso de um upcast - é possível fazer a inserção tanto de um
   * conteúdo da classe Course quanto de um conteúdo da classe Mentoring, pois os
   * dois foram abstraídos da classe Content que foi declarada abaixo.
   */
  private Set<Content> startedActivities = new LinkedHashSet<>();
  private Set<Content> completedActivities = new LinkedHashSet<>();

  public void singUpBootcamp(Bootcamp bootcamp) {
    this.startedActivities.addAll(bootcamp.getContents());
    bootcamp.registerDev(this);
  }

  public Dev(String name) {
    this.name = name;
  }

  public void progress() {
    Optional<Content> content = this.startedActivities.stream().findFirst();
    if (content.isPresent()) {
      this.completedActivities.add(content.get());
      this.startedActivities.remove(content.get());
    } else
      System.out.println("Você não está matriculado em nenhum conteúdo.");
  }

  public Set<Content> getStartedActivities() {
    return this.startedActivities;
  }

  public Set<Content> getCompletedActivities() {
    return this.completedActivities;
  }

  public double getTotalXp() {
    return completedActivities.stream()
        .mapToDouble(Content::getXp)
        .sum();
  }

  String getCourses() {
    return "";
  }

}
