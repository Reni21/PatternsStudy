package reni.com.decorator.entity;

import java.time.LocalDate;

public class SimpleRecipe implements Recipe {
    private String doctorName;
    private Integer medicineId;
    private LocalDate expiredAt;

    public SimpleRecipe(String doctorName, Integer medicineId, LocalDate expiredAt) {
        this.doctorName = doctorName;
        this.medicineId = medicineId;
        this.expiredAt = expiredAt;
    }

    @Override
    public String getDoctorName() {
        return doctorName;
    }

    @Override
    public Integer getMedicineId() {
        return medicineId;
    }

    @Override
    public LocalDate expiredAt() {
        return expiredAt;
    }

    @Override
    public String toString() {
        return "SimpleRecipe{" +
                "doctorName='" + doctorName + '\'' +
                ", medicineId=" + medicineId +
                ", expiredAt=" + expiredAt +
                '}';
    }
}
