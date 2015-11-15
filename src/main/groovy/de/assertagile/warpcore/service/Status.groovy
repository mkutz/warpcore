package de.assertagile.warpcore.service

enum Status {

    RUNNING("+"), STOPPED("-"), UNKNOWN("?")

    private final String symbol

    Status(String symbol) {
        this.symbol = symbol
    }

    public static Status forSymbol(String symbol) {
        values().find { it.symbol == symbol }
    }
}