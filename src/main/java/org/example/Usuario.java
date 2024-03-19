package org.example;

public class Usuario {
    private int id;
    private String nombre;
    private AlfiWallet wallet;

    //Constructor con parametros
    public Usuario(int id, String nombre, AlfiWallet wallet) {
        this.id = id;
        this.nombre = nombre;
        this.wallet = new AlfiWallet();
    }

    //Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AlfiWallet getWallet() {
        return wallet;
    }

    public void setWallet(AlfiWallet wallet) {
        this.wallet = wallet;
    }

    //Método to String
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
