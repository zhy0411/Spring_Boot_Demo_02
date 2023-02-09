package SpringBoot_Demo_02.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {
    private String id;

    private String password;
}
