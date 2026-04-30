import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criando conteúdos
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        // Criando bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // Dev Camila
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila: " + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila: " + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila: " + devCamila.getConteudosConcluidos());
        System.out.println("XP: " + devCamila.calcularTotalXp());
        System.out.println("-------");

        // Dev João
        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João: " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João: " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos João: " + devJoao.getConteudosConcluidos());
        System.out.println("XP: " + devJoao.calcularTotalXp());
        System.out.println("-------");

        // Dev Ana (novo)
        Dev devAna = new Dev();
        devAna.setNome("Ana");
        devAna.inscreverBootcamp(bootcamp);
        devAna.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Ana: " + devAna.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Ana: " + devAna.getConteudosConcluidos());
        System.out.println("XP: " + devAna.calcularTotalXp());
        System.out.println("-------");

        // Ranking de XP
        System.out.println("🏆 RANKING DE XP 🏆");
        List<Dev> devs = Arrays.asList(devCamila, devJoao, devAna);
        devs.stream()
                .sorted(Comparator.comparingDouble(Dev::calcularTotalXp).reversed())
                .forEach(dev -> System.out.println(dev.getNome() + " → " + dev.calcularTotalXp() + " XP"));
    }
}