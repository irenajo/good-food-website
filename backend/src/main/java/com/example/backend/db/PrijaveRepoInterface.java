package com.example.backend.db;

public interface PrijaveRepoInterface {

    public boolean postojiPrijava(String username, int idAkt);

    public boolean prijaviAktivnost(String username, int idAkt, int brSale);

}