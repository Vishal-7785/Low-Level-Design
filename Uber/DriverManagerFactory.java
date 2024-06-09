public class DriverManagerFactory {
    DriverManager driverManager;

    public DriverManager getDriverManager(CITY city){
        switch(city){
            case CITY.KANPUR:
                return KanpurDriverManager.getInstance();
            
            case CITY.LUCKNOW:
                return LucknowDriverManager.getInstance();
            
            default:
                return null;
        }
    }
}
