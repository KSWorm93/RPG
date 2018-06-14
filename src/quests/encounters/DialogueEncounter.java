package quests.encounters;

public class DialogueEncounter implements IEncounter {


    private String before;
    private String after;

    public DialogueEncounter(String before, String after) {
        this.before = before;
        this.after = after;
    }

    @Override
    public String beforeDialogue() {
        return before;
    }

    @Override
    public String afterDialogue() {
        return after;
    }
}
