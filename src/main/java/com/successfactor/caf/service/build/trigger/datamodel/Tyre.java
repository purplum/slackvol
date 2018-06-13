package com.successfactor.caf.service.build.trigger.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tyre {

    private String frontLeftTyrePressure;
    private String frontRightTyrePressure;
    private String rearLeftTyrePressure;
    private String rearRightTyrePressure;
    private String timestamp;
    private boolean wholeTyrePressure;

    public String getFrontLeftTyrePressure() {
        return frontLeftTyrePressure;
    }

    public void setFrontLeftTyrePressure(String frontLeftTyrePressure) {
        this.frontLeftTyrePressure = frontLeftTyrePressure;
    }

    public String getFrontRightTyrePressure() {
        return frontRightTyrePressure;
    }

    public void setFrontRightTyrePressure(String frontRightTyrePressure) {
        this.frontRightTyrePressure = frontRightTyrePressure;
    }

    public String getRearLeftTyrePressure() {
        return rearLeftTyrePressure;
    }

    public void setRearLeftTyrePressure(String rearLeftTyrePressure) {
        this.rearLeftTyrePressure = rearLeftTyrePressure;
    }

    public String getRearRightTyrePressure() {
        return rearRightTyrePressure;
    }

    public void setRearRightTyrePressure(String rearRightTyrePressure) {
        this.rearRightTyrePressure = rearRightTyrePressure;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isWholeTyrePressure() {
        return frontLeftTyrePressure.equalsIgnoreCase("Normal");
    }

    public void setWholeTyrePressure(boolean wholeTyrePressure) {
        this.wholeTyrePressure = wholeTyrePressure;
    }
}
