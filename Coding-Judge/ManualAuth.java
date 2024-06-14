public class ManualAuth implements AuthenticationStrategy{

    String id;
    String password;

    public ManualAuth(String id, String password){
        this.id = id;
        this.password = password;
    }

    @Override
    public boolean login() {
        if((id=="vishal7785" || id=="vishal") && password=="1234"){
            System.out.println("Authentication success!");
            System.out.println();
            return true;
        }
        System.out.println("Authentication Failed! please re enter id and password ");
        System.out.println();
        return false;
    }
    
}
