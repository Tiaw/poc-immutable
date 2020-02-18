package poc.cyclops.dto;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, id, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmployeeDto other = (EmployeeDto) obj;
        return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
                && Objects.equals(lastName, other.lastName);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EmployeeDto [id=")
               .append(id)
               .append(", firstName=")
               .append(firstName)
               .append(", lastName=")
               .append(lastName)
               .append("]");
        return builder.toString();
    }

}
