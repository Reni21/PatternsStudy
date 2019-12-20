package reni.com.decorator.entity;

import java.time.LocalDate;

public interface Recipe {
    String getDoctorName();

    Integer getMedicineId();

    LocalDate expiredAt();
}
