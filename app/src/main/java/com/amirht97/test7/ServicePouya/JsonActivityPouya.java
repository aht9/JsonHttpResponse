
package com.amirht97.test7.ServicePouya;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonActivityPouya {

    @SerializedName("vehicles")
    @Expose
    private List<Vehicle> vehicles = null;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
