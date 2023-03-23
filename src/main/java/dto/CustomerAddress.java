package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

    private String phoneNumber;
    private String street;
    private String city;
    private String postalCode;
    private String country;
}
