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
    } //getter que devuelve el idAutor
    
    public String getNombre() { 
        return nombre;
    } //getter que devuelve el nombre del autor

}
