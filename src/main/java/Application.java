public class Application {

    /*@Loggable
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        BookingService bookingSvc = context.getBean(BookingService.class);


        User userById = bookingSvc.getUserById(1);
        userById.setEmail("modifiedEmail@test.com");
        bookingSvc.updateUser(userById);
        User userByEmail = bookingSvc.getUserByEmail("modifiedEmail@test.com");
        List<User> test = bookingSvc.getUsersByName("Test", 1, 20);
        bookingSvc.deleteUser(1);
        User userByEmail1 = bookingSvc.getUserByEmail("modifiedEmail@test.com");
        List<User> test1 = bookingSvc.getUsersByName("Test", 1, 20);


        Event eventById = bookingSvc.getEventById(1);
        eventById.setTitle("Star Wars Andor");
        bookingSvc.updateEvent(eventById);
        List<Event> eventByTitle = bookingSvc.getEventsByTitle("Star Wars Andor", 1, 20);
        List<Event> eventsForDay = bookingSvc.getEventsForDay(new Date(31), 1, 20);
        bookingSvc.deleteEvent(1);
        List<Event> eventByTitle1 = bookingSvc.getEventsByTitle("Star Wars Andor", 1, 20);
        List<Event> eventsForDay1 = bookingSvc.getEventsForDay(new Date(31), 1, 20);


        User testUser = new UserImp(1, "Test", "test@test.com");
        Event event = new EventImp(1, "Halál a Níluson 3", new Date(31));
        List<Ticket> bookedTicketsByUser = bookingSvc.getBookedTickets(testUser, 1, 20);
        List<Ticket> bookedTicketsByEvent = bookingSvc.getBookedTickets(event, 1, 20);
        bookingSvc.cancelTicket(1);
        List<Ticket> bookedTicketsByUser1 = bookingSvc.getBookedTickets(testUser, 1, 20);
        List<Ticket> bookedTicketsByEvent1 = bookingSvc.getBookedTickets(event, 1, 20);
    }*/
}
