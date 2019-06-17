package chapter2;

/**
 *
 * 1. Encapsulating
 * Set the variable as private access modifier
 * 2. Java Bean
 */
public class DesignerPrincipals {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
