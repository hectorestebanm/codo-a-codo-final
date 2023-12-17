package modelo;

import java.sql.Date;

/**
 *
 * @author hector
 */
public class Orador
{
    // Atributos de la clase Orador
    private int idOrador;
    private String nombre;
    private String apellido;
    private String tema;
    private Date fechaAlta;

    // Constructor
    public Orador()
    {
        
    }

    // Métodos getters y setters
    
    public int getIdOrador()
    {
        return idOrador;
    }

    public void setIdOrador(int idOrador)
    {
        this.idOrador = idOrador;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public String getTema()
    {
        return tema;
    }

    public void setTema(String tema)
    {
        this.tema = tema;
    }

    public Date getFechaAlta()
    {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta)
    {
        this.fechaAlta = fechaAlta;
    }

}
