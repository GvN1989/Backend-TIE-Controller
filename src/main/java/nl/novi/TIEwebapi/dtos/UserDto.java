package nl.novi.TIEwebapi.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import nl.novi.TIEwebapi.models.Authority;

import java.util.Set;

@Valid
public class UserDto {
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "Password is mandatory")
    @Size(max = 255)
    private String password;
    @NotNull
    private Boolean enabled;
    @NotNull(message = "API key cannot be null")
    @Size(min = 20, max = 40, message = "API key must be between 20 and 40 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "API key must be alphanumeric")
    private String apikey;
    @Email
    private String email;

    @JsonSerialize
    public Set<Authority> authorities;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public String getEmail() {
        return email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
