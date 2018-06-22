package com.chori.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Access(AccessType.FIELD)
public class Sawon {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "sawon_hobby",
            joinColumns = @JoinColumn(name = "sawon_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id", referencedColumnName = "id")
    )
    @OrderColumn(name = "hobby_order")
    private List<Hobby> hobbies;

    protected Sawon() {}

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String result = String.format("Sawon [id=%d, name='%s']%n", id, name);
        if (hobbies != null) {
            for (Hobby hobby : hobbies) {
                result += String.format("Hobby[id=%d, name='%s']%n",
                        hobby.getId(), hobby.getName());
            }
        }
        return result;
    }
}
