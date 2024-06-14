public class GoogleAuth implements AuthenticationStrategy{

    String id;
    String password;

    public GoogleAuth(String id, String password){
        this.id = id;
        this.password = password;
    }

    @Override
    public boolean login() {
        if(id=="vishal7785@gmail.com" && password=="g1234"){
            System.out.println("Authentication success!");
            System.out.println();
            return true;
        }
        System.out.println("Authentication Failed! please re enter id and password ");
        System.out.println();
        return false;
    }
    
}
