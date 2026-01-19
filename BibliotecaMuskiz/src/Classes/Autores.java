package Classes;
public class Autores {
    private int idAutor;
    private String nombre;
    private String nacionalidad;
    private String fechaNacimiento;
    private boolean defuncion;
    private String fechaFallecimiento;
    private String biografia;
    private String foto;
    private String generoLiterario;
    private String premios;
    private String obrasDestacadas;

    public Autores(int idAutor, String nombre, String nacionalidad, String fechaNacimiento, boolean defuncion, String fechaFallecimiento, String biografia, String foto, String generoLiterario, String premios, String obrasDestacadas) {
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

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
}
