package PoliticalZones;

public enum PoliticalZone {
    NORTH_CENTRAL("Benue", "FCT", "Kogi", "Kwara", "Nasarawa", "Niger", "Plateau"),
    NORTH_EAST("Adamawa", "Bauchi", "Borno", "Gombe", "Taraba", "Yobe"),
    NORTH_WEST("Kaduna", "Katsina", "Kano", "Kebbi", "Sokoto", "Jigawa", "Zamfara"),
    SOUTH_EAST("Abia", "Anambra", "Ebonyi", "Enugu", "Imo"),
    SOUTH_SOUTH("Akwa Ibom", "Bayelsa", "Cross River", "Delta", "Edo", "Rivers"),
    SOUTH_WEST("Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo");

    private final String[] states;

    PoliticalZone(String... states) {
        this.states = states;
    }

    public static PoliticalZone getZone(String state) {
        for (PoliticalZone zoneHolder : PoliticalZone.values()) {
            for (String stateHolder : zoneHolder.states) {
                if (stateHolder.equalsIgnoreCase(state)) {
                    return zoneHolder;
                }
            }
        }
       return null;
    }

}

