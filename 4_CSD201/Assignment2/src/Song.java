
/**
 *
 * @author tourist
 */
public class Song {

    String id, name;
    double rating;
    Song right;
    Song left;

    public Song(String id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", rating: " + rating + "\n";
    }
}
