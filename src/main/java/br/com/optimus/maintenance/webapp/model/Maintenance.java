package br.com.optimus.maintenance.webapp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tab_manutencao")
public class Maintenance {
    private Integer id;
    private Mechanical mechanical;
    private Equipment equipment;
    private int work_hours;
    private List<MechanicalPiece> pieces;

    public Maintenance() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_manutencao", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "tab_manutencao_peca", joinColumns = { @JoinColumn(name = "cod_manutencao") },
            inverseJoinColumns = { @JoinColumn(name = "cod_peca") }
    )
    public List<MechanicalPiece> getPieces() {
        return pieces;
    }

    public void setPieces(List<MechanicalPiece> pieces) {
        this.pieces = pieces;
    }

    @ManyToOne
    @JoinColumn(name = "cod_matricula")
    public Mechanical getMechanical() {
        return mechanical;
    }

    public void setMechanical(Mechanical mechanical) {
        this.mechanical = mechanical;
    }

    @ManyToOne
    @JoinColumn(name = "cod_equipamento")
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Column(name = "qtd_horas_trabalho")
    public int getWork_hours() {
        return work_hours;
    }

    public void setWork_hours(int work_hours) {
        this.work_hours = work_hours;
    }
}
