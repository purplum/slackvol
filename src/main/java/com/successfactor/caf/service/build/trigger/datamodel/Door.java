package com.successfactor.caf.service.build.trigger.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Door {

    private boolean tailgateOpen;
    private boolean rearRightDoorOpen;
    private boolean rearLeftDoorOpen;
    private boolean frontRightDoorOpen;
    private boolean frontLeftDoorOpen;
    private boolean hoodOpen;
    private String timestamp;

    private boolean wholeDoor;

    public boolean isTailgateOpen() {
        return tailgateOpen;
    }

    public void setTailgateOpen(boolean tailgateOpen) {
        this.tailgateOpen = tailgateOpen;
    }

    public boolean isRearRightDoorOpen() {
        return rearRightDoorOpen;
    }

    public void setRearRightDoorOpen(boolean rearRightDoorOpen) {
        this.rearRightDoorOpen = rearRightDoorOpen;
    }

    public boolean isRearLeftDoorOpen() {
        return rearLeftDoorOpen;
    }

    public void setRearLeftDoorOpen(boolean rearLeftDoorOpen) {
        this.rearLeftDoorOpen = rearLeftDoorOpen;
    }

    public boolean isFrontRightDoorOpen() {
        return frontRightDoorOpen;
    }

    public void setFrontRightDoorOpen(boolean frontRightDoorOpen) {
        this.frontRightDoorOpen = frontRightDoorOpen;
    }

    public boolean isFrontLeftDoorOpen() {
        return frontLeftDoorOpen;
    }

    public void setFrontLeftDoorOpen(boolean frontLeftDoorOpen) {
        this.frontLeftDoorOpen = frontLeftDoorOpen;
    }

    public boolean isHoodOpen() {
        return hoodOpen;
    }

    public void setHoodOpen(boolean hoodOpen) {
        this.hoodOpen = hoodOpen;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isWholeDoor() {
        return tailgateOpen || rearRightDoorOpen || rearLeftDoorOpen || frontRightDoorOpen || frontLeftDoorOpen || hoodOpen ;
    }

    public void setWholeDoor(boolean wholeDoor) {
        this.wholeDoor = wholeDoor;
    }
}
