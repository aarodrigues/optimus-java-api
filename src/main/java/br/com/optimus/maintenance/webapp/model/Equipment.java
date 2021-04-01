package br.com.optimus.maintenance.webapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tab_equipamento")
public class Equipment {

    private Integer id;
    private String description;
    private List<MechanicalPiece> pieces;
    private List<Maintenance> maintenances;

    public Equipment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_equipamento", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "des_equipamento")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy="equipment")
    public List<MechanicalPiece> getPieces() {
        return pieces;
    }

    public void setPieces(List<MechanicalPiece> pieces) {
        this.pieces = pieces;
    }

    @OneToMany(mappedBy="equipment")
    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }
}
