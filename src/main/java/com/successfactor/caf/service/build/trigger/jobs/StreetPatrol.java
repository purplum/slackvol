package com.successfactor.caf.service.build.trigger.jobs;

import com.successfactor.caf.service.build.trigger.actions.HttpUtils;
import com.successfactor.caf.service.build.trigger.actions.SlackAction;
import com.successfactor.caf.service.build.trigger.datamodel.CarStatus;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class StreetPatrol {

    private static StreetPatrol instance = null;
    private static final Logger log = LoggerFactory.getLogger(StreetPatrol.class);

    private static Properties prop = null;
    private HttpUtils httpUtils = new HttpUtils();

    private boolean stateChanged = false;
    private boolean engineRunning = false;
    private boolean carLocked = true;

    private boolean debug = false;

    public static StreetPatrol getInstance() {

        if (instance == null) {
            instance = new StreetPatrol();
        }
        return instance;
    }

    public void doThem() {

        log.info("## On cleaning micro services..");


        try {
            CarStatus carStatus = httpUtils.getVolRawObject();

            operateOnCarStatus(carStatus);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void operateOnCarStatus(CarStatus carStatus) {

        if (shouldNotify(carStatus)) {

            SlackAction.getInstance().sendAttachment(carStatus);
        }
    }

    private boolean shouldNotify(CarStatus carStatus) {

        if(debug) {
            return true;
        }
        if (carStatus.isCarLocked() != isCarLocked()) {

            setCarLocked(carStatus.isCarLocked());
            return true;
        }
        if (carStatus.isEngineRunning() != isEngineRunning()) {

            setEngineRunning(carStatus.isEngineRunning());
            return true;
        }
        return false;
    }


    public boolean isStateChanged() {
        return stateChanged;
    }

    public void setStateChanged(boolean stateChanged) {
        this.stateChanged = stateChanged;
    }

    public boolean isEngineRunning() {
        return engineRunning;
    }

    public void setEngineRunning(boolean engineRunning) {
        this.engineRunning = engineRunning;
    }

    public boolean isCarLocked() {
        return carLocked;
    }

    public void setCarLocked(boolean carLocked) {
        this.carLocked = carLocked;
    }
}
