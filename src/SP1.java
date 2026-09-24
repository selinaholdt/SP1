import java.util.ArrayList;

public class SP1 {

    void main(){
        //======== My Band Profile ========
        Band myBand = new Band("Spice Girls", 'P');
        myBand.header = "\u001B[32m=== My Band Profile ===\u001B[0m";
        myBand.fameLevel = 2;
        myBand.currentFans = 8500;
        myBand.maxFans = 15000;
        myBand.xp = 3400;
        myBand.money = 4750.50;
        myBand.isActive = true;
        //My Band songs
        myBand.addSong(new Song("Wannabe", 3.20, 9000));
        myBand.addSong(new Song("Spice Up Your Life", 2.58, 8400));
        myBand.addSong(new Song("Say You'll Be There", 3.50, 7000));
        myBand.addSong(new Song("2 Become 1", 4.00, 5500));
        String mySongHeader = "Repertoire (" + myBand.numberOfSongs + " songs)";

        myBand.printBandProfile();
        myBand.printRepertoire(mySongHeader);

        //======== Rival Band Profile ========
        Band rivalBand = new Band("All Saints", 'P');
        rivalBand.header = "\u001B[31m=== Rival Band Profile ===\u001B[0m";
        rivalBand.fameLevel = 2;
        rivalBand.currentFans = 8600;
        rivalBand.maxFans = 15000;
        rivalBand.xp = 3300;
        rivalBand.money = 3587.00;
        rivalBand.isActive = true;
        //Rival songs
        rivalBand.addSong(new Song("Never Ever", 3.30, 8500));
        rivalBand.addSong(new Song("Pure Shores", 3.00, 7100));
        rivalBand.addSong(new Song("Black Coffee", 3.50, 6800));
        rivalBand.addSong(new Song("Under the Bridge", 3.48, 5500));
        String rivalSongHeader = "Repertoire (" + rivalBand.numberOfSongs + " songs)";

        rivalBand.printBandProfile();
        rivalBand.printRepertoire(rivalSongHeader);


        //======== Status checks: ========
        //Hvis fans er under 25% af max fans, udskriv “WARNING: Losing relevance! Consider a comeback strategy.”
        System.out.println();
        System.out.println("\u001B[32m=== My Band Status ===\u001B[0m");
        if (myBand.isLosingRelevance()){
            System.out.println("WARNING: Losing relevance! Consider a comeback strategy.");
        } else {
            System.out.println("You go girls!");
        } // Der er et if statement for at kunne bruge metodens return.

        //Hvis bandet har 0 eller færre fans, sæt isActive til false og udskriv “The band has broken up…”
        //Udskriv forskellige beskeder baseret på genre (‘R’, ‘E’, ‘H’, ‘P’)
        if (!myBand.isActive()){
            myBand.printBandType();
        }

        //Fame system:
        //Hvis XP er over en threshold (fx 2000 * current fame level), udskriv “Ready to level up!”
        System.out.println();
        System.out.println("\u001B[32m=== My Band Fame Level ===\u001B[0m");
        if (myBand.isReadyToLevelUp()){
            System.out.println("Ready to level up!");
        }
        //Udskriv bandets nuværende status baseret på fame level:
        System.out.println(myBand.getStatusTitle());



        //Simpel “gig” simulation:
        System.out.println();
        System.out.println("\u001B[32m=== Spice Girls GIG Night ===\u001B[0m");

        myBand.playGig(500, 420);

        //Random event:
        System.out.println();
        System.out.println("\u001B[32m=== Random Event ===\u001B[0m");
        myBand.eventGainOrLoseFans(1);



        // ===== Event =====
        Venue venue = new Venue("Store Vega", 2000);
        ArrayList<Band> bands = new ArrayList<Band>();
        bands.add(myBand);
        bands.add(rivalBand);

        Event gigNight = new Event(venue, bands);

        System.out.println();

        // Both play at a festival!
        System.out.println("\u001B[33m=== " + venue.name + " === \u001B[0m");
        myBand.playGig(gigNight.venue.capacity, 1800);
        System.out.println();
        rivalBand.playGig(gigNight.venue.capacity, 1650);
        System.out.println();

        // Who's winning?
        if (myBand.currentFans > rivalBand.currentFans) {
            System.out.println(myBand.name + " is dominating the scene!");
        } else {
            System.out.println(rivalBand.name + " is the crowd favorite!");
        }
        System.out.println();
        myBand.printBandProfile();
        System.out.println();
        rivalBand.printBandProfile();




        //Udfordring (valgfri)
        System.out.println();
        System.out.println("\u001B[32m=== TOUR ===\u001B[0m");

        //Simuler en hel “tour” med et loop – fx 5 koncerter i træk med varierende attendance.
        int[] venuesCapacity = {500, 350, 700, 500, 450};
        int[] venuesAttendance = {420, 200, 645, 300, 350};
        int totalCapacity = 0;
        int totalAttendance = 0;
        for (int i = 0; i < venuesCapacity.length; i++){
            System.out.println("Concert: " + (i + 1)  + ", Capacity: " + venuesCapacity[i] + ", Attendance: " + venuesAttendance[i]);
            totalCapacity += venuesCapacity[i];
            totalAttendance += venuesAttendance[i];
        }
        //Udskriv en tour-summary til sidst.
        System.out.println("\u001B[32m=== summery ===\u001B[0m");
        System.out.println("Total Tour, Capacity: " + totalCapacity + ", Attendance: " + totalAttendance);
    }


}
