package com.successfactor.caf.service.build.trigger.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarStatus {

    private int averageFuelConsumption;
    private int averageSpeed;
    private String averageFuelConsumptionTimestamp;
    private String averageSpeedTimestamp;
    private String brakeFluid;
    private String brakeFluidTimestamp;
    private String bulbFailuresTimestamp;
    private boolean carLocked;
    private String carLockedTimestamp;
    private int distanceToEmpty;
    private String distanceToEmptyTimestamp;
    private Door doors;
    private boolean engineRunning;
    private String engineRunningTimestamp;
    private int fuelAmount;
    private int fuelAmountLevel;
    private String fuelAmountLevelTimestamp;
    private String fuelAmountTimestamp;
    private int odometer;
    private String odometerTimestamp;
    private String serviceWarningStatus;
    private String serviceWarningStatusTimestamp;
    private String timeFullyAccessibleUntil;
    private String timePartiallyAccessibleUntil;
    private int tripMeter1;
    private String tripMeter1Timestamp;
    private int tripMeter2;
    private String tripMeter2Timestamp;
    private Tyre tyrePressure;
    private String washerFluidLevel;
    private String washerFluidLevelTimestamp;
    private Window windows;

    private boolean wholeStatus;

    public int getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public void setAverageFuelConsumption(int averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String getAverageFuelConsumptionTimestamp() {
        return averageFuelConsumptionTimestamp;
    }

    public void setAverageFuelConsumptionTimestamp(String averageFuelConsumptionTimestamp) {
        this.averageFuelConsumptionTimestamp = averageFuelConsumptionTimestamp;
    }

    public String getAverageSpeedTimestamp() {
        return averageSpeedTimestamp;
    }

    public void setAverageSpeedTimestamp(String averageSpeedTimestamp) {
        this.averageSpeedTimestamp = averageSpeedTimestamp;
    }

    public String getBrakeFluid() {
        return brakeFluid;
    }

    public void setBrakeFluid(String brakeFluid) {
        this.brakeFluid = brakeFluid;
    }

    public String getBrakeFluidTimestamp() {
        return brakeFluidTimestamp;
    }

    public void setBrakeFluidTimestamp(String brakeFluidTimestamp) {
        this.brakeFluidTimestamp = brakeFluidTimestamp;
    }

    public String getBulbFailuresTimestamp() {
        return bulbFailuresTimestamp;
    }

    public void setBulbFailuresTimestamp(String bulbFailuresTimestamp) {
        this.bulbFailuresTimestamp = bulbFailuresTimestamp;
    }

    public boolean isCarLocked() {
        return carLocked;
    }

    public void setCarLocked(boolean carLocked) {
        this.carLocked = carLocked;
    }

    public String getCarLockedTimestamp() {
        return carLockedTimestamp;
    }

    public void setCarLockedTimestamp(String carLockedTimestamp) {
        this.carLockedTimestamp = carLockedTimestamp;
    }

    public int getDistanceToEmpty() {
        return distanceToEmpty;
    }

    public void setDistanceToEmpty(int distanceToEmpty) {
        this.distanceToEmpty = distanceToEmpty;
    }

    public String getDistanceToEmptyTimestamp() {
        return distanceToEmptyTimestamp;
    }

    public void setDistanceToEmptyTimestamp(String distanceToEmptyTimestamp) {
        this.distanceToEmptyTimestamp = distanceToEmptyTimestamp;
    }

    public Door getDoors() {
        return doors;
    }

    public void setDoors(Door doors) {
        this.doors = doors;
    }

    public boolean isEngineRunning() {
        return engineRunning;
    }

    public void setEngineRunning(boolean engineRunning) {
        this.engineRunning = engineRunning;
    }

    public String getEngineRunningTimestamp() {
        return engineRunningTimestamp;
    }

    public void setEngineRunningTimestamp(String engineRunningTimestamp) {
        this.engineRunningTimestamp = engineRunningTimestamp;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public int getFuelAmountLevel() {
        return fuelAmountLevel;
    }

    public void setFuelAmountLevel(int fuelAmountLevel) {
        this.fuelAmountLevel = fuelAmountLevel;
    }

    public String getFuelAmountLevelTimestamp() {
        return fuelAmountLevelTimestamp;
    }

    public void setFuelAmountLevelTimestamp(String fuelAmountLevelTimestamp) {
        this.fuelAmountLevelTimestamp = fuelAmountLevelTimestamp;
    }

    public String getFuelAmountTimestamp() {
        return fuelAmountTimestamp;
    }

    public void setFuelAmountTimestamp(String fuelAmountTimestamp) {
        this.fuelAmountTimestamp = fuelAmountTimestamp;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getOdometerTimestamp() {
        return odometerTimestamp;
    }

    public void setOdometerTimestamp(String odometerTimestamp) {
        this.odometerTimestamp = odometerTimestamp;
    }

    public String getServiceWarningStatus() {
        return serviceWarningStatus;
    }

    public void setServiceWarningStatus(String serviceWarningStatus) {
        this.serviceWarningStatus = serviceWarningStatus;
    }

    public String getServiceWarningStatusTimestamp() {
        return serviceWarningStatusTimestamp;
    }

    public void setServiceWarningStatusTimestamp(String serviceWarningStatusTimestamp) {
        this.serviceWarningStatusTimestamp = serviceWarningStatusTimestamp;
    }

    public String getTimeFullyAccessibleUntil() {
        return timeFullyAccessibleUntil;
    }

    public void setTimeFullyAccessibleUntil(String timeFullyAccessibleUntil) {
        this.timeFullyAccessibleUntil = timeFullyAccessibleUntil;
    }

    public String getTimePartiallyAccessibleUntil() {
        return timePartiallyAccessibleUntil;
    }

    public void setTimePartiallyAccessibleUntil(String timePartiallyAccessibleUntil) {
        this.timePartiallyAccessibleUntil = timePartiallyAccessibleUntil;
    }

    public int getTripMeter1() {
        return tripMeter1;
    }

    public void setTripMeter1(int tripMeter1) {
        this.tripMeter1 = tripMeter1;
    }

    public String getTripMeter1Timestamp() {
        return tripMeter1Timestamp;
    }

    public void setTripMeter1Timestamp(String tripMeter1Timestamp) {
        this.tripMeter1Timestamp = tripMeter1Timestamp;
    }

    public int getTripMeter2() {
        return tripMeter2;
    }

    public void setTripMeter2(int tripMeter2) {
        this.tripMeter2 = tripMeter2;
    }

    public String getTripMeter2Timestamp() {
        return tripMeter2Timestamp;
    }

    public void setTripMeter2Timestamp(String tripMeter2Timestamp) {
        this.tripMeter2Timestamp = tripMeter2Timestamp;
    }

    public Tyre getTyrePressure() {
        return tyrePressure;
    }

    public void setTyrePressure(Tyre tyrePressure) {
        this.tyrePressure = tyrePressure;
    }

    public String getWasherFluidLevel() {
        return washerFluidLevel;
    }

    public void setWasherFluidLevel(String washerFluidLevel) {
        this.washerFluidLevel = washerFluidLevel;
    }

    public String getWasherFluidLevelTimestamp() {
        return washerFluidLevelTimestamp;
    }

    public void setWasherFluidLevelTimestamp(String washerFluidLevelTimestamp) {
        this.washerFluidLevelTimestamp = washerFluidLevelTimestamp;
    }

    public Window getWindows() {
        return windows;
    }

    public void setWindows(Window windows) {
        this.windows = windows;
    }


    public boolean isWholeStatus() {
        return wholeStatus;
    }

    public void setWholeStatus(boolean wholeStatus) {
        this.wholeStatus = wholeStatus;
    }
}
