import app.service.Service;
public class test {

    public static void main(String[] args) {
        var Service = new Service();
        var usercompany = Service.findCompany(2);
        usercompany.stream().forEach(System.out::println);

    }
}
