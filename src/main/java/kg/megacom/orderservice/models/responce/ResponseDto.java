package kg.megacom.orderservice.models.responce;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {

    private int code;
    private String message;
    private Object object;

    public static ResponseDto getResponse() {

        return ResponseDto.builder().code(1).message("Успешно!").build();
    }

}
