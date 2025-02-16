public class Song {
    private String title;
    private String artist;
    private double length;
    public Song(String title, String artist, double length) {
        this.title = title;
        this.artist = artist;
        this.length = length;
    }
    public String toString() {
        return  "name: " +title + "\n" +  "artist: " + artist +"\n" + "length: " + length;
    }
    public static void main(String[] args) {
        Song song = new Song("DtMF", "Bad Bunny", 3.57);
        System.out.println(song);
    }
}