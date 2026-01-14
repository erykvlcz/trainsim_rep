package pl.kurs.models;

import java.util.Objects;

public class Seat {
    private int number;
    private boolean isOccupied;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return number == seat.number && isOccupied == seat.isOccupied;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, isOccupied);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "number=" + number +
                ", isOccupied=" + isOccupied +
                '}';
    }
}

