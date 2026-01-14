package pl.kurs.app;

import pl.kurs.exceptionspack.TrainConfigProblem;
import pl.kurs.models.Train;
import pl.kurs.models.TrainService;

public class TSRunner {
    public static void main(String[] args) throws TrainConfigProblem {
        Train train = null;
        try {
            train = Train.createTrain("Jan Bach", 10);
        } catch (TrainConfigProblem e) {
            e.printStackTrace();
        }

        TrainService trainService = new TrainService();
        trainService.setTrain(train);

        try {
            trainService.bookSeats(10);
        } catch (TrainConfigProblem e) {
            e.printStackTrace();
        }


    }
}
