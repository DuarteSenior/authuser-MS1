package com.ead.authuser.dtos;

import com.ead.authuser.validation.UsernameContraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    public interface UserView {
        public static interface RegistrationPost {
        }

        public static interface UserPut {
        }

        public static interface PaswordPut {
        }

        public static interface ImagePut {
        }
    }

    private UUID userId;

    @NotBlank(groups = UserView.RegistrationPost.class)
    @Size(min = 4, max = 50, groups = UserView.RegistrationPost.class)
    @UsernameContraint(groups = UserView.RegistrationPost.class)
    @JsonView(UserView.RegistrationPost.class)
    private String username;

    @NotBlank(groups = UserView.RegistrationPost.class)
    @Email(groups = UserView.RegistrationPost.class)
    @JsonView(UserView.RegistrationPost.class)
    private String email;

    @NotBlank(groups = {UserView.RegistrationPost.class, UserView.PaswordPut.class})
    @Size(min = 6, max = 20, groups = {UserView.RegistrationPost.class, UserView.PaswordPut.class})
    @JsonView({UserView.RegistrationPost.class, UserView.PaswordPut.class})
    private String password;

    @NotBlank(groups = UserView.PaswordPut.class)
    @Size(min = 6, max = 20, groups = UserView.PaswordPut.class)
    @JsonView(UserView.PaswordPut.class)
    private String oldPassword;

    @JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
    private String fullName;

    @JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
    private String phoneNumber;

    @JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
    private String cpf;

    @NotBlank(groups = UserView.ImagePut.class)
    @JsonView(UserView.ImagePut.class)
    private String imageUrl;

}
