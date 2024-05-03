package be.intecbrussel.appointment.jpa;

import be.intecbrussel.appointment.jpa.model.Appointment;
import be.intecbrussel.appointment.jpa.service.AppointmentService;

public class App {

    public static void main(String[] args) {

        AppointmentService appointmentService = new AppointmentService();

        Appointment appointment1 = new Appointment("Doctor", "Tooth pain", 25, 9, 2024, 15, 30);
        Appointment appointment2 = new Appointment("Birthday", "eliza birthday party", 25, 9, 2024, 18, 10);
        Appointment appointment3 = new Appointment("Job interview", "Microsoft java dev", 26, 9, 2024, 15, 30);
        Appointment appointment4 = new Appointment("Sale", "Playstation craig list", 26, 9, 2024, 20, 20);
        Appointment appointment5 = new Appointment("Mother", "Cordial visit", 25, 9, 2024, 19, 20);

        System.out.println("\n➕ ADD \n"+appointmentService.add(appointment1));
        System.out.println(appointmentService.add(appointment2));
        System.out.println(appointmentService.add(appointment3));
        System.out.println(appointmentService.add(appointment4));
        System.out.println(appointmentService.add(appointment5));

        System.out.println("\n\uD83D\uDD0D SEARCH ALL APPOINTMENTS BY DAY");
        appointmentService.findByDay(25).forEach(
                appointment -> {
                    System.out.println(appointment+" ✅");
                }
        );

        System.out.println("\n\uD83D\uDD01 CHANGE HOUR APPOINTMENT ");
        System.out.println(appointmentService.changeHour(appointment1, 23));

        System.out.println("\n\uD83D\uDDD1\uFE0F DELETE APPOINTMENT ");
        System.out.println(appointmentService.remove(appointment4));

        System.out.println("\n\uD83D\uDED1 CLOSE DB");
        System.out.println(appointmentService.close());

    }

}