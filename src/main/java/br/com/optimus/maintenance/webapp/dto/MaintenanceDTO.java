package br.com.optimus.maintenance.webapp.dto;

import br.com.optimus.maintenance.webapp.model.Equipment;
import br.com.optimus.maintenance.webapp.model.Mechanical;

public class MaintenanceDTO {
    private Integer mechanicalId;
    private Integer equipmentId;
    private Integer workHours;

    public Integer getMechanicalId() {
        return mechanicalId;
    }

    public void setMechanicalId(Integer mechanicalId) {
        this.mechanicalId = mechanicalId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Integer workHours) {
        this.workHours = workHours;
    }
}
