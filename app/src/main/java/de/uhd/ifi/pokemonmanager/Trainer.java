package de.uhd.ifi.pokemonmanager;
import java.util.ArrayList;

public class Trainer {
    private String firstName;

    private String lastName;

    //attribute pokemons of type ArrayList
    private ArrayList<Pokemon> pokemons;

    //constructor
    public Trainer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pokemons = new ArrayList<Pokemon>();
    }

    //getter
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //toString
    @Override
    public String toString() {
        return "Trainer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Pokemons=" + pokemons +
                '}';
    }

    //method to link Pokemon to trainer
    public void linkPokemon(Pokemon p) {
        if (p.getTrainer() != null) {
            System.out.println("Pokemon " + p + " is taken by " + p.getTrainer());
        }
        else {
            this.pokemons.add(p);
            p.setTrainer(this);
        }
    }

    //method list pokemons for trainer
    public void listPokemons() {
        System.out.println("List of Pokemons for Trainer " + this.getFirstName() + " " + this.getLastName() + ":");
        for (int i = 0; i < this.pokemons.size(); i++) {
            System.out.println(i + ": " + this.pokemons.get(i));
        }
    }

    //List Pokemons for Trainer by Type
    public void listPokemonsOfType(Type type) {
        System.out.println("List of Pokemons of Type '" + type + "' for Trainer " + this.getFirstName() + " " + this.getLastName() + ":");
        for (int i = 0; i < this.pokemons.size(); i++) {
            Pokemon currentP = this.pokemons.get(i);
            if ( currentP.getType() == type ) {
                System.out.println(i + ": " + currentP);
            }
        }
    }

    //Show i-th Pokemon for Trainer
    public void showIthPokemon(int i) {
        System.out.println("Pokemon Nr. " + i + " for Trainer " + this.getFirstName() + " " + this.getLastName() + ": " + this.pokemons.get(i));
    }

    public static void main(String[] args) {
        Trainer t1;
        t1 = new Trainer("Tim", "Schneider");
        Pokemon p1 = new Pokemon("Bulbasar", Type.WATER);
        t1.linkPokemon(p1);
        Pokemon p2 = new Pokemon("Pikachu", Type.FIRE);
        t1.linkPokemon(p2);
        System.out.println(t1);
        Trainer t2 = new Trainer("Anna", "Schwegmann");
        t2.linkPokemon(p1);
        System.out.println(t2);
        t1.listPokemons();
        //System.out.println(p2.getTrainer());
        t1.listPokemonsOfType(Type.WATER);
        t1.showIthPokemon(1);
    }
}
