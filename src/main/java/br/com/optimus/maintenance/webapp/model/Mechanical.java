package br.com.optimus.maintenance.webapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tab_mecanico")
public class Mechanical {

    private Integer id;
    private String name;
    private List<Maintenance> maintenance;

    public Mechanical() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_matricula", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nom_mecanico")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy="mechanical")
    public List<Maintenance> getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(List<Maintenance> maintenance) {
        this.maintenance = maintenance;
    }
}
