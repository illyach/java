
public class DVD extends Item {
    private int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    @Override
    public void borrowItem() {
        if (!isBorrowed()) {
            this.isBorrowed = true;
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed()) {
            this.isBorrowed = false;
        }
    }
}