import training.HayStore;

import java.util.Optional;

public class ForTests {
    public static void main(String[] args) {

        Address address = null;
        Optional<Address> addrs1 = Optional.ofNullable (address);

    }

    private static void x(Address o) {


    }

    class Address {
        String city = "New York";

        public String getCity() {
            return city;
        }

        public String toString() {
            return city;
        }
    }

}
