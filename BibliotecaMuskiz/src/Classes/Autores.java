package Classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Autores {

    private int idAutor;
    private String nombre;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    private boolean defuncion;
    private LocalDate fechaFallecimiento;
    private int edad;
    private String biografia;
    private String foto;
    private String generoLiterario;
    private String premios;
    private String obrasDestacadas;
    private List<Integer> librosEscritos;

    public Autores(
            int idAutor,
            String nombre,
            String nacionalidad,
            LocalDate fechaNacimiento,
            boolean defuncion,
            LocalDate fechaFallecimiento,
            String biografia,
            String foto,
            String generoLiterario,
            String premios,
            String obrasDestacadas
    ) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.defuncion = defuncion;
        this.fechaFallecimiento = fechaFallecimiento;
        this.biografia = biografia;
        this.foto = foto;
        this.generoLiterario = generoLiterario;
        this.premios = premios;
        this.obrasDestacadas = obrasDestacadas;

        this.librosEscritos = new ArrayList<>();

        calcularEdad();
    }

    private void calcularEdad() {
        LocalDate referencia = defuncion && fechaFallecimiento != null
                ? fechaFallecimiento
                : LocalDate.now();

        this.edad = Period.between(fechaNacimiento, referencia).getYears();
    }

    //getter para librosEscritos
    public List<Integer> getLibrosEscritos() {
        return librosEscritos;
    }

    //setter para añadir un libro
    public void addLibro(int idLibro) {
        librosEscritos.add(idLibro);
    }

    //getter para obtener el numero de libros de un autor
    public int getNumeroLibros() {
        return librosEscritos.size();
    }


    public int getIdAutor() { 
        return idAutor; 
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() { 
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean getDefuncion(){
        return defuncion;
    }

    public void setDefuncion(boolean defuncion){
        this.defuncion = defuncion;
    }

    public LocalDate getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(LocalDate fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public String getObrasDestacadas() {
        return obrasDestacadas;
    }

    public void setObrasDestacadas(String obrasDestacadas) {
        this.obrasDestacadas = obrasDestacadas;
    }

    /*public Libros getIdLibros() {
        return idLibro;
    }

    public void setIdLibros(Libros idLibro) {
        this.idLibro = idLibro;
    }*/

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
