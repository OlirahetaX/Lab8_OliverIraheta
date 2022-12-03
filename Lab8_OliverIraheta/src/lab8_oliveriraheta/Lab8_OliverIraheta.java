package lab8_oliveriraheta;

import java.util.*;

public class Lab8_OliverIraheta {

    public static Scanner vini = new Scanner(System.in);
    public static Scanner rm = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            boolean x = true;
            while (x) {
                System.out.println("--------------------------------------------------");
                System.out.println("Bienvenid@ a Laboratorio 8");
                System.out.println("1. Pocket Monsters      2.  DC vrs Marvel ");
                System.out.println("¿Que juego quieres jugar?(3. Salir)");
                int opc = vini.nextInt();
                switch (opc) {
                    case 1 ->
                        _pokemon();
                    case 2 ->
                        superheroes();
                    case 3 -> {
                        System.out.println("Adios!");
                        x = false;
                    }
                    default ->
                        System.out.println("Ingrese opcion valida");
                }

            }
        } catch (Exception e) {
        }
    }
    public static ArrayList<Pokemon> pokemones = new ArrayList<>();
    public static ArrayList<Pokemon> pokemones2 = new ArrayList<>();

    public static void _pokemon() {
        int pokej1 = 0;
        System.out.println("----BIENVENIDO A POCKET MONSTERS---");
        boolean r = true;
        while (r) {
            System.out.println("- JUGADOR 1 -");
            System.out.print("Ingrese cantidad(1-3) de pokemones: ");
            pokej1 = vini.nextInt();
            if (pokej1 > 3 || pokej1 <= 0) {
                System.out.println("Cantidad afuera del rango");
            } else {
                r = false;
            }
        }
        int pokevida = 0;

        for (int i = 0; i < pokej1; i++) {
            System.out.print("Ingrese Nombre del pokemon " + (i + 1) + ": ");
            String pokenombre = rm.nextLine();
            boolean x = true;
            while (x) {

                System.out.print("Ingrese Vida(1-300) del pokemon " + (i + 1) + ": ");
                pokevida = vini.nextInt();
                if (pokevida > 300 || pokevida <= 0) {
                    System.out.println("Vida afuera del rango");
                } else {
                    x = false;
                }
            }
            boolean y = true;
            while (y) {
                System.out.print("Ingrese Ataque(1-300) del pokemon " + (i + 1) + ": ");
                int pokedmg = vini.nextInt();
                if (pokedmg > 300 || pokedmg <= 0) {
                    System.out.println("Ataque afuera del rango");
                } else {
                    y = false;
                }
                int luck = new Random().nextInt((5 - 1) + 1) + 1;
                Pokemon pokemon = new Pokemon(pokenombre, pokevida, pokedmg, luck);
                pokemones.add(pokemon);
            }
        }
        int pokej2 = 0;
        boolean v = true;
        while (v) {
            System.out.println("- JUGADOR 2 -");
            System.out.print("Ingrese cantidad(1-3) de pokemones: ");
            pokej2 = vini.nextInt();
            if (pokej2 > 3 || pokej2 <= 0) {
                System.out.println("Cantidad afuera del rango");
            } else {
                v = false;
            }
        }

        for (int i = 0; i < pokej2; i++) {
            System.out.print("Ingrese Nombre del pokemon " + (i + 1) + ": ");
            String pokenombre2 = rm.nextLine();
            boolean q = true;
            while (q) {
                System.out.print("Ingrese Vida(1-300) del pokemon " + (i + 1) + ": ");
                pokevida = vini.nextInt();
                if (pokevida > 300 || pokevida <= 0) {
                    System.out.println("Vida afuera del rango");
                } else {
                    q = false;
                }
            }
            boolean s = true;
            while (s) {
                System.out.print("Ingrese Ataque(1-300) del pokemon " + (i + 1) + ": ");
                int pokedmg = vini.nextInt();
                if (pokedmg > 300 || pokedmg <= 0) {
                    System.out.print("Ataque afuera del rango");
                } else {
                    s = false;
                }
                int luck = new Random().nextInt((5 - 1) + 1) + 1;
                Pokemon pokemon = new Pokemon(pokenombre2, pokevida, pokedmg, luck);
                pokemones2.add(pokemon);
            }
        }
        batalla(pokej1, pokej2);
    }

    public static void batalla(int pokej1, int pokej2) {

        int i = 0;//numero de ronda
        int poke1 = 0;//numero de pokemon del jugador 1
        int poke2 = 0;//numero de pokemon del jugador 2
        //vr1 = vidarestantejugador1
        int vr1 = pokemones.get(poke1).getVida();
        //vr2 = vidarestantejugador2
        int vr2 = pokemones2.get(poke2).getVida();
        //boolean flag = true;
        do {

            System.out.println("----------------------- RONDA " + (i += 1) + " -----------------------");
            int luck1 = pokemones.get(poke1).getLuck();
            int luck2 = pokemones2.get(poke2).getLuck();
            if (luck1 >= luck2) {
                System.out.println(pokemones.get(poke1).getNombre() + " Ataca Primero Tiene: " + vr1 + " Puntos de Vida");
                System.out.println(pokemones2.get(poke2).getNombre() + " Ataca Segundo Tiene: " + vr2 + " Puntos de Vida");
                vr2 -= pokemones.get(poke1).getAtaque();
                vr1 -= pokemones2.get(poke2).getAtaque();
                System.out.println("** Puntos Restantes **");
                System.out.println(pokemones.get(poke1).getNombre() + " Tiene " + vr1 + " restantes");
                System.out.println(pokemones2.get(poke2).getNombre() + " Tiene " + vr2 + " restantes");

                /*if(vr2==0 && vr1==0){
                    System.out.println("--- RESULTADOS ---");
                    System.out.println("EMPATE");
                    pokej1--;
                    pokej2--;
                     poke1++;
                      poke2++;
                    vr2= pokemones2.get(poke2).getVida();
                    vr1= pokemones.get(poke1).getVida(); 
                }else*/ if (vr2 < 0) {
                    poke2++;
                    System.out.println("--- RESULTADOS ---");
                    System.out.println(pokemones.get(poke1).getNombre() + " ES EL GANADOR");
                    pokej2 -= 1;
                    vr2 = pokemones2.get(poke2).getVida();
                } else if (vr1 <= 0) {
                    poke1++;
                    System.out.println("--- RESULTADOS ---");
                    System.out.println(pokemones2.get(poke2).getNombre() + " ES EL GANADOR");
                    pokej1 -= 1;
                    vr1 = pokemones.get(poke1).getVida();
                }
//                 System.out.println(pokej1+"-----");
//                 System.out.println(pokej2+"-----");
//                if (pokej1+1 == 0) {
//                    System.out.println("Jugador 1 YA NO PUEDE CONTINUAR");
//                    flag = false;
//                }
//                if (pokej2+1 == 0) {
//                    System.out.println("JUGADOR 2 YA NO PUEDE CONTINUAR");
//                    flag = false;
                //}
            } else {
                System.out.println(pokemones2.get(poke1).getNombre() + " Ataca Primero Tiene: " + vr2 + " Puntos de Vida");
                System.out.println(pokemones.get(poke2).getNombre() + " Ataca Segundo Tiene: " + vr1 + " Puntos de Vida");
                vr2 -= pokemones.get(poke1).getAtaque();
                vr1 -= pokemones2.get(poke2).getAtaque();
                System.out.println("** Puntos Restantes **");
                System.out.println(pokemones.get(poke1).getNombre() + " Tiene " + vr1 + " restantes");
                System.out.println(pokemones2.get(poke2).getNombre() + " Tiene " + vr2 + " restantes");

                /*if(vr2==0 && vr1==0){
                    System.out.println("--- RESULTADOS ---");
                    System.out.println("EMPATE");
                    pokej2--;
                    pokej1--;
                     poke1++;
                      poke2++;
                    vr2= pokemones2.get(poke2).getVida();
                    vr1= pokemones.get(poke1).getVida();
                }else*/ if (vr2 <= 0) {
                    poke2++;
                    System.out.println("--- RESULTADOS ---");
                    System.out.println(pokemones.get(poke1).getNombre() + " ES EL GANADOR");
                    pokej2 -= 1;
                    vr2 = pokemones2.get(poke2).getVida();
                } else if (vr1 <= 0) {

                    System.out.println("--- RESULTADOS ---");
                    System.out.println(pokemones2.get(poke2).getNombre() + " ES EL GANADOR");
                    pokej1 -= 1;
                    vr1 = pokemones.get(poke1).getVida();
                }
//                System.out.println(pokej1+"----f-");
//                 System.out.println(pokej2+"---f--");
//                if (pokej1+1 <= 0) {
//                    System.out.println("Jugador 1 YA NO PUEDE CONTINUAR");
//                    flag = false;
//
//                }
//                if (pokej2+1 <= 0) {
//                    System.out.println("JUGADOR 2 YA NO PUEDE CONTINUAR");
//                    flag = false;
//                }
            }

        } while (pokej1 > 0 || pokej2 > 0);

    }
    public static ArrayList<Heroe> heroe = new ArrayList<>();
    //public static ArrayList<Heroe> marvel = new ArrayList<>();

    public static void superheroes() {

        //heroes de DC
        Heroe robin = new Heroe("Robin", "Damian Wayne", "DC", "Ciudad gotica");
        heroe.add(robin);
        Heroe shazam = new Heroe("Shazam", "Billy Batson", "DC", "Nueva York");
        heroe.add(shazam);
        Heroe flash = new Heroe("Flash ", "Barry Allen", "DC", "Central City");
        heroe.add(flash);
        Heroe aquaman = new Heroe("Aquaman", "Jason Momoa", "DC", "Atlantis");
        heroe.add(aquaman);
        Heroe linternaverde = new Heroe("Linterna Verde", "Linterna Verde", "DC", "Detroit");
        heroe.add(linternaverde);
        Heroe catwoman = new Heroe("Catwoman", "Selina Kyle", "DC", "Gotham");
        heroe.add(catwoman);
        Heroe superboy = new Heroe("Superboy", "Conner Kent", "DC", "Smallville");
        heroe.add(superboy);
        Heroe superman = new Heroe("Superman ", "Clark Joseph Kent", "DC", "Krypton");
        heroe.add(superman);
        Heroe batman = new Heroe("Batman ", "Bruce Wayne", "DC", "Gotham City");
        heroe.add(batman);
        Heroe lobo = new Heroe("Lobo ", "Desconocido", "DC", "Czarnia");
        heroe.add(lobo);
        //Heroes de marvel
        Heroe namor = new Heroe("Namor", "Namor McKenzie", "Marvel", "Atlantis");
        heroe.add(namor);
        Heroe thor = new Heroe("Thor ", "Chris Hemsworth", "Marvel", "Asgard");
        heroe.add(thor);
        Heroe quicksilver = new Heroe("Quicksilver ", "Pietro Maximoff", "Marvel", "Attilan");
        heroe.add(quicksilver);
        Heroe jubilo = new Heroe("Jubilo ", "Jubilation Lee", "Marvel", "Beverly Hills");
        heroe.add(jubilo);
        Heroe elektra = new Heroe("Elektra ", "Elektra Natchios", "Marvel", "Grecia");
        heroe.add(elektra);
        Heroe wolverine = new Heroe("Wolverine ", "James Howlett", "Marvel", "Alberta, Canada");
        heroe.add(wolverine);
        Heroe tormenta = new Heroe("Tormenta ", "Ororo Iqadi Munroe", "Marvel", "Wakanda");
        heroe.add(tormenta);
        Heroe spiderman = new Heroe("Spider-Man", "Tom Holland", "Marvel", "Nueva York");
        heroe.add(spiderman);
        Heroe hulk = new Heroe("Hulk ", "Bruce Banner", "Marvel", "Dayton");
        heroe.add(hulk);
        Heroe capitanamerica = new Heroe("Capitan America", "Steven Grant Rogers", "Marvel", "Nueva York");
        heroe.add(capitanamerica);

        boolean x = true;
        while (x) {
            System.out.println("--- BIENVENIDO A DC vrs MARVEL ---");
            System.out.print("1. Buscar   2. Agregar  3. Salir: ");
            int opc = vini.nextInt();
            switch (opc) {
                case 1 ->
                    buscar();
                case 2 ->
                    agregar();
                case 3 -> {
                    System.out.println("Adios!");
                    x = false;
                }
                default ->
                    System.out.println("Opcion no valida");
            }
        }

    }

    public static void buscar() {
        System.out.print("Ingrese nombre: ");
        String nombre = rm.nextLine().toLowerCase().replace(" ", "");
        int x = heroe.indexOf(nombre);
        if (heroe.contains(nombre)) {
            System.out.println("Nombre de super héroe: " + heroe.get(x).getNombreheroe());
            System.out.println("Nombre real :" + heroe.get(x).getNombrereal());
            System.out.println("Ciudad de origen: " + heroe.get(x).getCiudad());
            System.out.println("Franquicia: " + heroe.get(x).getFranquicia());
        } else {
            System.out.println("Heroe no encontrado");
        }
    }

    public static void agregar() {
        System.out.println("Ingrese el nombre de heroe:");
        String nombre = rm.nextLine();
        System.out.println("Ingrese el nombre verdadero:");
        String nombrereal = rm.nextLine();
        System.out.println("Ingrese la franquicia:");
        String franquicia = rm.nextLine().toLowerCase();
        System.out.println("Ingrese la ciudad de Origen:");
        String ciudad = rm.nextLine();
        Heroe heroes = new Heroe(nombre, nombrereal, franquicia, ciudad);
        heroe.add(heroes);

    }
}
