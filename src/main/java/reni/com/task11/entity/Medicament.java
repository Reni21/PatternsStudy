package reni.com.task11.entity;

public class Medicament {
    private Integer medicamentId;
    private String medicamentName;
    private String medicamentCode;

    public Medicament(Integer medicamentId, String medicamentName, String medicamentCode) {
        this.medicamentId = medicamentId;
        this.medicamentName = medicamentName;
        this.medicamentCode = medicamentCode;
    }

    public Integer getMedicamentId() {
        return medicamentId;
    }

    public String getMedicamentName() {
        return medicamentName;
    }

    public String getMedicamentCode() {
        return medicamentCode;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "medicamentId=" + medicamentId +
                ", medicamentName='" + medicamentName + '\'' +
                ", medicamentCode='" + medicamentCode + '\'' +
                '}';
    }
}
