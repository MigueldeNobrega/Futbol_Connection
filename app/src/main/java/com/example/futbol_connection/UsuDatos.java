package com.example.futbol_connection;

public class UsuDatos {

    private String nombreUsu;
    private String correoUsu;
    private String passUsu;
    private String equipoUsu;
    private String fotoUsu;

    public UsuDatos(String nombreUsu, String correoUsu, String passUsu, String equipoUsu, String fotoUsu) {
        this.nombreUsu = nombreUsu;
        this.correoUsu = correoUsu;
        this.passUsu = passUsu;
        this.equipoUsu = equipoUsu;
        this.fotoUsu = fotoUsu;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public String getCorreoUsu() {
        return correoUsu;
    }

    public String getPassUsu() {
        return passUsu;
    }

    public String getEquipoUsu() {
        return equipoUsu;
    }

    public String getFotoUsu() {
        return fotoUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public void setCorreoUsu(String correoUsu) {
        this.correoUsu = correoUsu;
    }

    public void setPassUsu(String passUsu) {
        this.passUsu = passUsu;
    }

    public void setEquipoUsu(String equipoUsu) {
        this.equipoUsu = equipoUsu;
    }

    public void setFotoUsu(String fotoUsu) {
        this.fotoUsu = fotoUsu;
    }
}
