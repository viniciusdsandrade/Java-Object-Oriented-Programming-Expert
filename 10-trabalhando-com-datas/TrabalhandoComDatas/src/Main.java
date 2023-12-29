import java.sql.SQLOutput;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.ZoneId.systemDefault;

public class Main {


    public static void main(String[] args) {

        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/format/DateTimeFormatter.html

        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();
        Instant instant = Instant.now(); //

        LocalDate date2 = LocalDate.of(2001, 12, 6);
        LocalDateTime dateTime2 = LocalDateTime.of(2001, 12, 6, 12, 30, 30);
        Instant instant2 = Instant.parse("2007-12-03T10:15:30Z");
        Instant instant3 = Instant.parse("2007-12-03T10:15:30-03:00");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date3 = LocalDate.parse("06/12/2001", formatter);
        LocalDate date4 = LocalDate.parse("06/12/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("LocalDate.now():     " + date);
        System.out.println("LocalDateTime.now(): " + dateTime);
        System.out.println("Instant.now():       " + instant);
        System.out.println("LocalDate.of(2001, 12, 6): " + date2);
        System.out.println("LocalDateTime.of(2001, 12, 6, 12, 30, 30): " + dateTime2);
        System.out.println("Instant.parse(\"2007-12-03T10:15:30.00Z\"):      " + instant2);
        System.out.println("Instant.parse(\"2007-12-03T10:15:30.00-05:00\"): " + instant3);
        System.out.println("LocalDate.parse(\"06/12/2001\", formatter): " + date3.format(formatter));
        System.out.println("LocalDate.parse(\"06/12/2001\", DateTimeFormatter.ofPattern(\"dd/MM/yyyy\")): " + date4.format(formatter));

        /*************************************************************************************************************************************/

        System.out.println();
        LocalDate date5 = LocalDate.parse("06/12/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDateTime dateTime6 = LocalDateTime.parse("06/12/2001 12:30:30", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime dateTime7 = LocalDateTime.parse("06/12/2001 12:30:30.613", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS"));
        Instant instant4 = Instant.parse("2007-12-03T10:15:30-03:00");

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSSSSS").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_DATE_TIME;

        System.out.println("LocalDate.parse(\"06/12/2001\", DateTimeFormatter.ofPattern(\"dd/MM/yyyy\")): " + date5.format(fmt1));
        System.out.println("LocalDateTime.parse(\"06/12/2001 12:30:30\", DateTimeFormatter.ofPattern(\"dd/MM/yyyy HH:mm:ss\")): " + dateTime6.format(fmt2));
        System.out.println("LocalDateTime.parse(\"06/12/2001 12:30:30.000\", DateTimeFormatter.ofPattern(\"dd/MM/yyyy HH:mm:ss.SSS\")): " + dateTime7.format(fmt3));
        System.out.println("Instant.parse(\"2007-12-03T10:15:30-03:00\"): " + instant4);
        System.out.println("Instant.parse(\"2007-12-03T10:15:30-03:00\"): " + instant4.atZone(systemDefault()).format(fmt4));
        System.out.println("Instant.parse(\"2007-12-03T10:15:30-03:00\"): " + instant4.atZone(systemDefault()).format(fmt5));
        System.out.println();

        /*************************************************************************************************************************************/

        LocalDate date8 = LocalDate.parse("06/12/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Instant instant10 = Instant.now();

        LocalDateTime r1 = LocalDateTime.ofInstant(instant10, systemDefault());
        LocalDateTime r2 = LocalDateTime.ofInstant(instant10, ZoneId.of("Portugal"));

        System.out.println("LocalDate.ofInstant(instant10, systemDefault()):            " + r1);
        System.out.println("LocalDateTime.ofInstant(instant10, ZoneId.systemDefault()): " + r2);

        System.out.println("Nascimento dia da semana: " + date8.getDayOfWeek());
        System.out.println("Nascimento dia do mês:    " + date8.getDayOfMonth());
        System.out.println("Nascimento dia do ano:    " + date8.getDayOfYear());
        System.out.println("Nascimento mês:           " + date8.getMonth());
        System.out.println("Nascimento mês:           " + date8.getMonthValue());
        System.out.println("Nascimento ano:           " + date8.getYear());

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nascimento = LocalDateTime.of(2001, 12, 6, 12, 30, 30);

        long horasDeVida = nascimento.until(now, ChronoUnit.HOURS);
        Duration duration = Duration.between(nascimento, now);

        System.out.println("Horas de vida: " + horasDeVida);
        System.out.println("Horas de vida: " + duration.toHours());
        System.out.printf("Anos de vida:  %.3f \n", calcularIdadeEmAnosComDecimais(now, nascimento));
        System.out.println("Dias de vida: " + duration.toDays());

        System.out.println("Minutos de vida: " + duration.toMinutes());
        System.out.println();
        /*************************************************************************************************************************************/
    

        LocalDate now2 = LocalDate.now();
        LocalDate nascimento2 = now2.plusWeeks(1).plusDays(1);
        
        System.out.println("Data de Hoje Mais uma semana, mais um dia: " + nascimento2);


    }

    // Método para calcular a idade com três casas decimais
    private static double calcularIdadeEmAnosComDecimais(LocalDateTime agora, LocalDateTime nascimento) {
        Duration duracao = Duration.between(nascimento, agora);
        double horas = duracao.toHours();
        return horas / (365.25 * 24);
    }
}