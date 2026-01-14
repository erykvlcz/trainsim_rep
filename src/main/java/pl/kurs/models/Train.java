package pl.kurs.models;

import pl.kurs.exceptionspack.TrainConfigProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class Train {
    private String name;
    private List<Seat> seatList = new ArrayList<>();



    private Train(String name, List<Seat> seatList) {
        this.name = name;
        this.seatList = seatList;
    }

    public static Train createTrain(String name, int passengerSeatsNumber) throws TrainConfigProblem {
        if(passengerSeatsNumber < 1) throw new TrainConfigProblem("Ilość miejsc pasażerów nie może być mniejsza od 1");
        return new Train(
                name,
                IntStream.rangeClosed(0, passengerSeatsNumber - 1).mapToObj(Seat::new).toList()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(name, train.name) && Objects.equals(seatList, train.seatList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, seatList);
    }

    @Override
    public String toString() {
        return "Train{" +
                "name='" + name + '\'' +
                ", seatList=" + seatList +
                '}';
    }
}
