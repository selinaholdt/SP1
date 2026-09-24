
public class Band {
    String header;
    String name;
    char genre;
    int fameLevel;
    int currentFans;
    int maxFans;
    int xp;
    double money;
    boolean isActive;
    Song songs[] = new Song[6];
    int numberOfSongs = 0;

    Band(String name, char genre) {
        this.name = name;
        this.genre = genre;
    }

    void printBandProfile() {
        //Udskriver alle stats
        System.out.println(header);
        System.out.println("Name: " + name);
        System.out.println("Genre: " + genre);
        System.out.println("Fame Level: " + fameLevel);
        System.out.println("Fans: " + currentFans + "/" + maxFans);
        System.out.println("XP: " + xp);
        System.out.println("Money: $" + money);
        System.out.println("Active: " + isActive);
        System.out.println();
    }

    void printRepertoire(String songHeader) {
        // Udskriver alle sange
        //Klart bedre at bruge en arraylist
        System.out.println(songHeader);
        for (Song s : songs) {
            if (s != null) {
                System.out.println(s.title);
            }
        }
        System.out.println();
        System.out.println("Number of songs: " + numberOfSongs);
        System.out.println();
    }

    boolean isLosingRelevance() {
        // Returnerer true hvis fans < 25% af max
        return (currentFans < (maxFans * 0.25));
    }
    boolean isActive(){
        // Returnerer true hvis fans > 0
        return (currentFans > 0);
    }
    void printBandType(){
        String bandtype = "";
        switch (genre){
            case 'P':
                bandtype = "pop";
                break;
            case 'H':
                bandtype = "hip hop";
                break;
            case 'E':
                bandtype = "electronic";
                break;
            case 'R':
                bandtype = "rock";
                break;
            default:
                bandtype = "unknown";
        }
        System.out.println("The " + bandtype +" band has broken up…");
    }

    boolean isReadyToLevelUp(){
        return (xp > (2000 * fameLevel));
    }

    String getStatusTitle(){
        //Returnerer status baseret på fame level
        String fameMessage = "";
        switch (fameLevel){
            case 1:
                fameMessage = "Level 1: Unknown - Playing in garages";
                break;
            case 2:
                fameMessage = "Level 2: Local Hero - Small venues await";
                break;
            case 3:
                fameMessage = "Level 3: Rising Star - Festival invitations coming in";
                break;
            case 4:
                fameMessage = "Level 4: Mainstream - Arena tours possible";
                break;
            case 5:
                fameMessage = "Level 5: Superstar - Stadium glory!";
                break;
            default:
                fameMessage = "Invalid level";
        }
        return fameMessage;
    }
    void playGig(int venueCapacity, int attendance){
        //Simulerer en koncert, tilføjer fans og penge
        System.out.println(name +" playing at venue (capacity: " + venueCapacity + ")");

        //Beregn hvor fyldt koncerten var (procent)
        int crowdPct = 100 * attendance / venueCapacity;
        System.out.println("Attendance: " + attendance + " (" + crowdPct + "%)");

        gigGainFans(crowdPct);

        earnMoney();

    }
    void gigGainFans(int crowdPct){
        //Tilføjer fans
        //Giv fans baseret på performance: hvis over 80% fyldt, +200 fans. Ellers +50 fans.
        int fansBefore = currentFans;
        if (crowdPct > 80){
            currentFans += 200;
            System.out.println("Great turn out!");
            System.out.println("Fans: " + fansBefore + " -> " + currentFans);
        } else {
            currentFans += 50;
            System.out.println("Fans: " + fansBefore + " -> " + currentFans);
        }
    }
    void earnMoney(){
        //Tilføjer penge
        //Tilføj penge for koncerten (fx $1500)
        double moneyBefore = money;
        money += 1500;
        System.out.println("Money: $" + moneyBefore + " -> $" + money);
    }
    void eventGainOrLoseFans(int eventType){ //------ gain og loose metoder i en metode.
        //Switch ville være en bedre løsning, fordi koden er nemmere at læse og udvide.
        //Fjerner fans, checker om bandet opløses
        //Erklær en variabel eventType (int fra 1-3) //Brug if/else til at simulere forskellige events:
        int fansBefore = currentFans;
        if (eventType == 1){
            currentFans += 500;
            System.out.println("Great review! +500 fans");
        } else if (eventType == 2) {
            System.out.println("Quiet week. Nothing happens.");
        } else {
            currentFans -= 300;
            System.out.println("Scandal! -300 fans");
        }
        System.out.println("Fans: " + fansBefore + " -> " + currentFans);

        if (isLosingRelevance()){
            System.out.println("WARNING: Losing relevance! Consider a comeback strategy.");
        } else {
            System.out.println("You go girls!");
        }

    }


    boolean spendMoney(double amount) {
        //Fjerner penge, returnerer true hvis det lykkedes
        if (amount <= money){
            money -= amount;
            return true;
        } else {
            System.out.println("Not enough money");
            return false;
        }
    }

    void addXP(int points){
        //Tilføjer XP, checker for level up
        xp += points;
        isReadyToLevelUp();
    }


    void levelUp(){
        //Øger fame level, nulstiller XP, øger maxFans
        if (isReadyToLevelUp()) {
            fameLevel += 1;
            xp = 0;
            maxFans += 5000;
        }
    }

    double getFanPercentage(){
        //Returnerer fans som procent af maxFans
        if (maxFans > 0) {
            return (100 * (double) currentFans / maxFans);
        } else {
            return 0; //Just in case max fans er 0.
        }
    }

    public void addSong(Song newSong){
        songs[numberOfSongs] = newSong;
        numberOfSongs++;
    }




}

