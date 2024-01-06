package ex2;

import core.FuzzyPetriLogic.Executor.AsyncronRunnableExecutor;
import core.FuzzyPetriLogic.FuzzyDriver;
import core.FuzzyPetriLogic.FuzzyToken;
import core.FuzzyPetriLogic.PetriNet.FuzzyPetriNet;
import core.FuzzyPetriLogic.PetriNet.Recorders.FullRecorder;
import core.FuzzyPetriLogic.Tables.OneXOneTable;
import core.TableParser;

import java.util.function.Consumer;

public class HeaterTank {
    private static final double pipeWaterTemerature = 7;
    private static final double maxWaterTemeprature = 75;
    private static final double startTemperature = 23;
    private static final double theoraticalRoomTemp = 23;

    double curentWaterTemepartaure;

    public HeaterTank() {
        curentWaterTemepartaure = startTemperature;  }
    public void updateSystem(boolean heaterOn, double  gasCmd){
        gasCmd = (gasCmd < 0.0) ? 0.0 : ((gasCmd > 1.0) ? 1.0 : gasCmd);
        curentWaterTemepartaure += -(curentWaterTemepartaure - pipeWaterTemerature) * 0.1 * ((heaterOn) ? 1.0 : 0.0) +
                (maxWaterTemeprature - curentWaterTemepartaure) * 0.4 * gasCmd
                - (curentWaterTemepartaure - theoraticalRoomTemp) * 0.005;  }

    public double getHotWaterTemeprature() {
        return curentWaterTemepartaure;  }
}


