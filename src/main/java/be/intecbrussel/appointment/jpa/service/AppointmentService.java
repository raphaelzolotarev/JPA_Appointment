package be.intecbrussel.appointment.jpa.service;
import be.intecbrussel.appointment.jpa.App;
import be.intecbrussel.appointment.jpa.model.Appointment;
import be.intecbrussel.appointment.jpa.repository.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private AppointmentRepository appointmentRepository = new AppointmentRepository();


    public String add(Appointment appointment){
        if (appointmentRepository.create(appointment)){
            return "Appointment "+appointment.getTitle()+" added! ✅";
        }
        return "Appointment "+appointment.getTitle()+" not added. ❌";
    }

    public List<Appointment> findByDay(int day){
        List<Appointment> list = appointmentRepository.read(day);
        if (!list.isEmpty()){
            return list;
        }
        System.out.println("No appointment for the day: "+day+" ❌");
        return new ArrayList<>();
    }

    public String changeHour(Appointment appointment, int newHour){
        if (appointmentRepository.update(appointment, newHour)){
            return "Appointment "+appointment+" updated! ✅";
        }
        return appointment.getTitle()+" not updated. ❌";
    }

    public String remove(Appointment appointment){
        if (appointmentRepository.delete(appointment)){
            return "Appointment "+appointment.getTitle()+" deleted! ✅";
        }
        return "Appointment "+appointment.getTitle()+" not deleted. ❌";
    }

    public String close(){
        if (appointmentRepository.closeConnection()){
            return "Connection closed ✅";
        }
        return "Connection not closed ❌";
    }

}
