package model;

public class Mariage {
    protected String dateMar;
    protected Homme epoux;
    protected Femme epouse;

    public Mariage(String dateM, Homme epx, Femme eps) {
        dateMar = dateM;
        epoux = epx;
        epouse = eps;
        epx.epouse = eps;
        eps.epoux = epx;
    }
}
