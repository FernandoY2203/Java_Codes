
package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Seller implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private Double baseSalary;
    
    private Department department;
    
    // Atributos
    //------------------------------------------------------------------------//

    public Seller(Integer id, String name, String email, LocalDate birthDate, Double baseSalary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.baseSalary = baseSalary;
        this.department = department;
    }
    
    // Construtor
    //------------------------------------------------------------------------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    // Getters e Setters
    //------------------------------------------------------------------------//

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seller other = (Seller) obj;
        return Objects.equals(this.id, other.id);
    }
    
    // hashCode e equals
    //------------------------------------------------------------------------//
    
    @Override
    public String toString() {
        return "Id: " + id + "\n" +
               "Name: " + name + "\n" +
               "Email: " + email + "\n" +
               "BirthDate: " + birthDate + "\n" +
               "BaseSalary: " + baseSalary + "\n\n" +
               "Department: \n" + department;
    }
    
    // toString
    //------------------------------------------------------------------------//
}
