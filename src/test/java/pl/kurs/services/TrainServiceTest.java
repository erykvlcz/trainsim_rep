package pl.kurs.services;

import org.junit.jupiter.api.Test;
import pl.kurs.exceptionspack.TrainConfigProblem;
import pl.kurs.models.Train;
import pl.kurs.models.TrainService;
import static org.junit.jupiter.api.Assertions.*;

public class TrainServiceTest {

    @Test
    public void shouldBookChosenSeat(){
        //given
        int seatNumber;
        Train train = null;
        try {
            train = Train.createTrain("Jan Bach", 10);
        } catch (TrainConfigProblem e) {
            e.printStackTrace();
        }

        TrainService trainService = new TrainService();
        trainService.setTrain(train);

        //when
        try {
            trainService.bookSeats(4);
        } catch (TrainConfigProblem e) {
            e.printStackTrace();
        }
        try {
            trainService.bookSeats(1);
        } catch (TrainConfigProblem e) {
            e.printStackTrace();
        }


        assertEquals(true, train.getSeatList().get(4).isOccupied());

    }

}
