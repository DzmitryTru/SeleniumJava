package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

@Data


public class CustomerAddress {

    private String phoneNumber;
    private String street;
    private String city;
    private String postalCode;
    private String country;
}
