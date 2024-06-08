package br.cesul.ex04.exception;

public class UnfinishedRentalException extends Exception {
    public UnfinishedRentalException() {
        super("Can't calculate total for rentals still in progress");
    }
}
