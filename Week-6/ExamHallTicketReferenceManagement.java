class HallTicket {

    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

class ExamHallTicketReferenceManagement {

    public static void main(String[] args) {

        HallTicket priya = new HallTicket("Priya", 0);

        // Both variables point to the same object
        HallTicket copy = priya;

        // Changing through copy also changes the same object
        copy.seatNumber = 45;

        // A separate object with identical values
        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println(
            "Priya's seatNumber (via first variable):"
        );
        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));
        System.out.println(
            "separate == priya: " + (separate == priya)
        );
    }
}