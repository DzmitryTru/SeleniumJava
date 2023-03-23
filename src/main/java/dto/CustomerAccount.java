package dto;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccount {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public CustomerAccount createFakeAccount() {
        return new CustomerAccount(
                new Faker().name().firstName(),
                new Faker().name().lastName(),
                new Faker().internet().emailAddress(),
                new Faker().internet().password(8, 10, true, true));
    }

}
