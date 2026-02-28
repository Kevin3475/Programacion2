package co.edu.uniquindio.poo.taller.model;

/**
 * clase abstracta persona
 */
public abstract class Persona {
    private String nombre;
    private String id;

    /**
     * Metodo constructor de la clase persona
     * @param nombre
     * @param id
     */
    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Metodo para llamar a nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para actualizar nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para para llamar el ID
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo para actualizar el ID
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo para mostra la info de persona
     * @return
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}