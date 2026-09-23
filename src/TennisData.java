import java.util.List;

public class TennisData {

    private int version;
    private List<TennisCourt> courts;
    private List<TennisBooking> bookings;

    public TennisData() {
    }

    public int getVersion() {
        return version;
    }

    public List<TennisCourt> getCourts() {
        return courts;
    }

    public List<TennisBooking> getBookings() {
        return bookings;
    }
}
