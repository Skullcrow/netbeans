package acceso;

public interface ICatalogoPeliculas {
    String NOMBRE_RECURSO = "Peliculas.txt";
    void agregarPelicula(String nombre);
    void listarPeliculas();
    void buscarPeliculas(String nombre);
    void iniciarCatalogoPeliculas();
    
}
