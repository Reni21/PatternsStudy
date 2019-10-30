package reni.com.task11.service;

import reni.com.task11.entity.Medicament;
import reni.com.task11.entity.Recipe;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PharmacyService {

    private static final Map<Integer, Medicament> MEDICAMENT_CATALOG = new HashMap<>();

    static {
        MEDICAMENT_CATALOG.put(1, new Medicament(1, "Aspirin", "AP"));
        MEDICAMENT_CATALOG.put(2, new Medicament(2, "Glucose", "PN"));
    }

    public Medicament buyMedicament(Recipe recipe, Integer medicamentId) {
        if (!MEDICAMENT_CATALOG.containsKey(medicamentId)) {
            throw new IllegalArgumentException(String.format("Medicament of id %s doesn't exist", medicamentId));
        }

        if (recipe.expiredAt().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Recipe is expired");
        }
        return MEDICAMENT_CATALOG.get(medicamentId);
    }

}
