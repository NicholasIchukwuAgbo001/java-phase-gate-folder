package SchoolBuilding;

public class Facilitator extends Person {
    private  String facilitatorName;
    private LanguageType languageTaking;

    public Facilitator(String facilitatorName, LanguageType languageTaking) {
        super(facilitatorName);
        this.facilitatorName = facilitatorName;
        this.languageTaking = languageTaking;
    }

    public String getFacilitatorName() {
        return facilitatorName;
    }

    public LanguageType getLanguageTaking() {
        return languageTaking;
    }

    @Override
    public String toString() {
        return "\nName: " + facilitatorName + ", Language: " + languageTaking + "\n";
    }
}


