package reni.com.task11.entity;

import java.time.LocalDate;

public interface Recipe {
    String getDoctorName();

    Integer getMedicineId();

    LocalDate expiredAt();
}
