package ogloszenia.repository;

import ogloszenia.model.CATEGORY;
import ogloszenia.model.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-08-02.
 */
public class CategoryRepository {

    public static List<CategoryDTO> findAll() {

        List<CategoryDTO> categories = new ArrayList<>();
        categories.add(new CategoryDTO("Elektronika", "fa-gamepad", CATEGORY.ELEKTRONIKA));
        categories.add(new CategoryDTO("Motoryzacja", "fa-car", CATEGORY.MOTORYZACJA));
        categories.add(new CategoryDTO("Nieruchomości", "fa-home", CATEGORY.NIERUCHOMOSCI));

        return categories;
    }

    //pobrac nazwe kategorii na podstawie enuma
    //pobierzemy i utworzymy obiekt CategoryDTO
    public static CategoryDTO findByCategory(CATEGORY category) {
        return findAll().stream()
                .filter(e -> e.getCategory().equals(category))
                .findFirst()
                .get(); //bo optional
    }
}
