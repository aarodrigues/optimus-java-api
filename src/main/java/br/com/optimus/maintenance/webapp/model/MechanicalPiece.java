package br.com.optimus.maintenance.webapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="tab_peca")
public class MechanicalPiece {

    private Integer id;
    private Equipment equipment;
    private String name;

    public MechanicalPiece() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_peca", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn(name = "cod_equipamento", referencedColumnName = "cod_equipamento")
    @ManyToOne
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Column(name = "nom_peca")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
