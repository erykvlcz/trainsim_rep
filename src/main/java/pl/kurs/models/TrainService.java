package pl.kurs.models;

import pl.kurs.exceptionspack.TrainConfigProblem;

import java.util.ArrayList;
import java.util.List;

public class TrainService {
    private Train train;

    public void setTrain(Train train){
        if (train != null){
            this.train = train;
        }
    }

    public void bookSeats(int numberSeatsToBook) throws TrainConfigProblem {
        long freeSeats = train.getSeatList().stream()
                .filter(s -> !s.isOccupied())
                .count();

        if (freeSeats < numberSeatsToBook) {
            throw new TrainConfigProblem("Brak wystarczającej liczby wolnych miejsc");
        }

        train.getSeatList().stream().filter(s -> s.isOccupied() == false).limit(numberSeatsToBook).forEach(s -> s.setOccupied(true));
    }

    public void cancelSeatReservation(int seatId) throws TrainConfigProblem {

        if (seatId < 1) {
            throw new TrainConfigProblem("Numer siedzenia to minimum 1");
        }

        if (seatId > train.getSeatList().size()) {
            throw new TrainConfigProblem("Nie ma takiego siedzenia");
        }

        Seat seat = train.getSeatList().get(seatId - 1);

        if (!seat.isOccupied()) {
            throw new TrainConfigProblem("To siedzenie jest wolne");
        }

        seat.setOccupied(false);
    }



}
