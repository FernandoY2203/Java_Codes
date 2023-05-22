
package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt03 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt04 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt05 = DateTimeFormatter.ISO_INSTANT;
        
        LocalDate dl01 = LocalDate.now();
        LocalDateTime dl02 = LocalDateTime.now();
        LocalDate dl03 = LocalDate.parse("2022-05-18");
        LocalDateTime dl04 = LocalDateTime.parse("2022-05-18T01:30:26");
        LocalDate dl05 = LocalDate.parse("20/05/2023", fmt01);
        LocalDateTime dl06 = LocalDateTime.parse("20/05/2023 15:30", fmt02);
        LocalDate dl07 = LocalDate.of(2023, 5, 20);
        LocalDateTime dl08 = LocalDateTime.of(2023, 5, 20, 15, 30);
        
        Instant dg01 = Instant.now();
        Instant dg02 = Instant.parse("2022-05-18T01:30:26Z");
        Instant dg03 = Instant.parse("2022-05-18T01:30:26-03:00");
        
        LocalDate cnv01 = LocalDate.ofInstant(dg02, ZoneId.systemDefault());
        LocalDateTime cnv02 = LocalDateTime.ofInstant(dg02, ZoneId.of("Portugal")); 
        
        Duration d01 = Duration.between(dl03.atTime(0,0), dl03.plusDays(7).atStartOfDay());
        Duration d02 = Duration.between(dl04, dl04.plusDays(7));
        
        
        System.out.println("Data Local Sem Horas: " + dl01);
        System.out.println("Data Local Com Horas: " + dl02);
        System.out.println("Data Local Instanciada Sem Horas: " + dl03);
        System.out.println("Data Local Instanciada Com Horas: " + dl04);
        System.out.println("Data Local Instanciada Sem Horas Recebendo Formato Diferente: " + dl05);
        System.out.println("Data Local Instanciada Com Horas Recebendo Formato Diferente: " + dl06);
        System.out.println("Data Local Instanciada Sem Horas Recebendo Apenas os Numeros: " + dl07);
        System.out.println("Data Local Instanciada Com Horas Recebendo Apenas os Numeros: " + dl08);
        
        System.out.println();
        
        System.out.println("Data Global: " + dg01);
        System.out.println("Data Global Instanciada: " + dg02);
        System.out.println("Data Global Instanciada Com GMT Diferente: " + dg03);
        
        System.out.println();
        
        System.out.println("Data Local Formatada: " + dl01.format(fmt01));
        System.out.println("Data Local Formatada2: " + fmt01.format(dl01));
        System.out.println("Data Local Com Hora Formatada: " + fmt02.format(dl02));
        System.out.println("Data Local Com Hora Formatação Pre-Definida: " + fmt04.format(dl04));
        
        System.out.println();
        
        System.out.println("Data Global Formatada: " + fmt03.format(dg02));
        System.out.println("Data Global Formatação Pre-Definida: " + fmt05.format(dg02));
        
        System.out.println();
        
        System.out.println("Conversão de Global para Local Usando o Fuso da Maquina: " + cnv01);
        System.out.println("Conversão de Global para Local Usando o Fuso da Determinado: " + cnv02);
        
        System.out.println();
        
        System.out.println("Data-Hora Local Dia: " + dl04.getDayOfMonth());
        System.out.println("Data-Hora Local Mês: " + dl04.getMonth());
        System.out.println("Data-Hora Local Ano: " + dl04.getYear());
        System.out.println("Data-Hora Local Horas: " + dl04.getHour());
        System.out.println("Data-Hora Local Minutos: " + dl04.getMinute());
        System.out.println("Data-Hora Local Segundos: " + dl04.getSecond());
        
        System.out.println();
        
        System.out.println("LocalDate Add 7 Dias: " + dl03.plusDays(7));
        System.out.println("LocalDate Sub 7 Dias: " + dl03.minusDays(7));
        
        System.out.println("LocalDateTime Add 7 Dias: " + dl04.plusDays(7));
        System.out.println("LocalDateTime Sub 7 Dias: " + dl04.minusDays(7));

        System.out.println("Instant Add 7 Dias: " + dg02.plus(7, ChronoUnit.DAYS));
        System.out.println("Instant Sub 7 Dias: " + dg02.minus(7, ChronoUnit.DAYS));
        
        System.out.println("Diferença de Dias(LocalDate): " + d01.toDays());
        
        System.out.println("Diferença de Dias(LocalDateTime): " + d02.toDays());
        System.out.println("Diferença de Horas((LocalDateTime)): " + d02.toHours());
    }  
}
