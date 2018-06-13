package com.successfactor.caf.service.build.trigger.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Window {

    private boolean frontLeftWindowOpen;
    private boolean frontRightWindowOpen;
    private boolean rearLeftWindowOpen;
    private boolean rearRightWindowOpen;
    private String timestamp;
    private boolean wholeWindowOpen;

    public boolean isFrontLeftWindowOpen() {
        return frontLeftWindowOpen;
    }

    public void setFrontLeftWindowOpen(boolean frontLeftWindowOpen) {
        this.frontLeftWindowOpen = frontLeftWindowOpen;
    }

    public boolean isFrontRightWindowOpen() {
        return frontRightWindowOpen;
    }

    public void setFrontRightWindowOpen(boolean frontRightWindowOpen) {
        this.frontRightWindowOpen = frontRightWindowOpen;
    }

    public boolean isRearLeftWindowOpen() {
        return rearLeftWindowOpen;
    }

    public void setRearLeftWindowOpen(boolean rearLeftWindowOpen) {
        this.rearLeftWindowOpen = rearLeftWindowOpen;
    }

    public boolean isRearRightWindowOpen() {
        return rearRightWindowOpen;
    }

    public void setRearRightWindowOpen(boolean rearRightWindowOpen) {
        this.rearRightWindowOpen = rearRightWindowOpen;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isWholeWindowOpen() {
        return frontLeftWindowOpen || frontRightWindowOpen || rearLeftWindowOpen || rearRightWindowOpen;
    }

    public void setWholeWindowOpen(boolean wholeWindowOpen) {
        this.wholeWindowOpen = wholeWindowOpen;
    }
}
