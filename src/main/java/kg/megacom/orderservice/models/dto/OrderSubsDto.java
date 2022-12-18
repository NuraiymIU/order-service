package kg.megacom.orderservice.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderSubsDto {

    private String name;
    private Date dateOfBirth;
    private String phone;
    private String schoolName;
    private String address;

}
