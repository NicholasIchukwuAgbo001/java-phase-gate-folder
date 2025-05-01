package SchoolBuilding;

public class Facilitator {
    private  String facilitatorName;
    private String languageTaking;

    public Facilitator(String facilitatorName, String languageTaking) {
        this.facilitatorName = facilitatorName;
        this.languageTaking = languageTaking;
    }

    public String getFacilitatorName() {
        return facilitatorName;
    }

    public String getLanguageTaking() {
        return languageTaking;
    }

    @Override
    public String toString() {
        return "\nName: " + facilitatorName + ", Language: " + languageTaking + "\n";
    }
}


