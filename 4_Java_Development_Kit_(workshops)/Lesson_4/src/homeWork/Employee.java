package homeWork;

public class Employee {
    private final int employeeId;      // Табельный номер
    private final String phoneNumber;  // Номер телефона
    private final String name;         // Имя
    private final int experience;      // Стаж

    //  Constructor:
    public Employee(int employeeId, String phoneNumber, String name, int experience) {
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    // get set
    public int getEmployeeId() {
        return employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Табельный номер: " + employeeId + "  Имя : " + name + "  Номер телефона: " + phoneNumber + "  Стаж : " +
                experience;
    }
}