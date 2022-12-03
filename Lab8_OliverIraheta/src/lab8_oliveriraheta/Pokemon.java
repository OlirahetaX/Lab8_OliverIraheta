package lab8_oliveriraheta;


public class Pokemon {
    
   public String nombre;
   public int vida;
   public int ataque;
   public int luck;

    public Pokemon(String nombre, int vida, int ataque, int luck) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.luck = luck;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
   
}
