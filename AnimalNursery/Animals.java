package AnimalNursery;

public abstract class Animals {
    private String name;
    private String commands;
    private String birthday;

    public Animals(String name, String birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCommands() {
        return commands;
    }

    public void newCommands(String newcommands) {
        this.commands = newcommands;
    }

    public void showAnimalCommands() {
        System.out.println(commands);
    }


}