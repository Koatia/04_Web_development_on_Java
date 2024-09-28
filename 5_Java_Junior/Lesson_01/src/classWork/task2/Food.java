package classWork.task2;

/**
 * Еда
 */
public interface Food extends Thing {
    // Наличие белка
    boolean getProteins();

    // Наличие жиров
    boolean getFats();

    // Наличие углеводов
    boolean getCarbohydrates();
}