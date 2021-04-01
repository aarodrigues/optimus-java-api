package br.com.optimus.maintenance.webapp.dto;

public class MechanicalPieceDTO {
    private String name;
    private Integer equipmentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }
//    public Equipment getEquipment() {
//        return equipment;
//    }
//
//    public void setEquipment(Equipment equipment) {
//        this.equipment = equipment;
//    }
}
