import exercises.oop.*;

public class ObjectProgramming {
    public static void main(String[] args) {

        Course course1 = new Course(
                "Java Ninja",
                "Aprenda o java orienal.",
                8);
        Course course2 = new Course(
                "Mestre python",
                "Seja tão bom em Pyhton como o mestre Miyagi no karatê.",
                15);

        Mentoring mentoring = new Mentoring(
                "Aperfeiçoe suas técnicas",
                "Aqui você vai aprender a fazer as coisas com mais eficácia.");

        System.out.println("Checando cursos:");
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(mentoring);
        System.out.println();

        Bootcamp bootcamp = new Bootcamp(
                "Bootcamp Java Developer",
                "Descrição Bootcamp Java Developer");
        bootcamp.includeContent(course1);
        bootcamp.includeContent(course2);
        bootcamp.includeContent(mentoring);

        Dev goku = new Dev("Goku");
        goku.singUpBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos do Goku:" +
                goku.getStartedActivities());
        goku.progress();
        goku.progress();

        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" +
                goku.getStartedActivities());
        System.out.println("Conteúdos Concluídos Camila:" +
                goku.getCompletedActivities());
        System.out.println("XP:" + goku.getTotalXp());

        System.out.println("--------------------------");

        Dev dev2 = new Dev("Alfredo");
        dev2.singUpBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos do alfredo:" +
                dev2.getStartedActivities());
        dev2.progress();
        dev2.progress();
        dev2.progress();
        System.out.println("Conteúdos Inscritos João:" +
                dev2.getStartedActivities());
        System.out.println("Conteúdos Concluidos João:");
        dev2.getCompletedActivities()
                .stream().forEach(course -> System.out.println(course));
        System.out.println("XP:" + dev2.getTotalXp());

    }

}
