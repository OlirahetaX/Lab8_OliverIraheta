
package lab8_oliveriraheta;


public class Heroe {
    public String nombreheroe;
    public String nombrereal;
    public String franquicia;
    public String ciudad;

    public Heroe(String nombreheroe, String nombrereal, String franquicia, String ciudad) {
        this.nombreheroe = nombreheroe;
        this.nombrereal = nombrereal;
        this.franquicia = franquicia;
        this.ciudad = ciudad;
    }

    public String getNombreheroe() {
        return nombreheroe;
    }

    public void setNombreheroe(String nombreheroe) {
        this.nombreheroe = nombreheroe;
    }

    public String getNombrereal() {
        return nombrereal;
    }

    public void setNombrereal(String nombrereal) {
        this.nombrereal = nombrereal;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
