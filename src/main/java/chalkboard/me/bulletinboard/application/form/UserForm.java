package chalkboard.me.bulletinboard.application.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
    正規表現の書き方
    https://userweb.mnet.ne.jp/nakama/
 */
@Data
public class UserForm {
    // UserName
    @Size(max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @NotNull
    private String username;

    // PassWord
    @Size(max = 64)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @NotNull
    private String password;
}
