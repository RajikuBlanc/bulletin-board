package chalkboard.me.bulletinboard.application.usecase;

import chalkboard.me.bulletinboard.application.auth.UserAuthRepository;
import chalkboard.me.bulletinboard.application.form.UserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class UserAuthUseCase {
    private final UserAuthRepository userAuthRepository;

    /*
        HttpServletRequest
        ユーザーが問題なく作成できたら、自動でログインを行う
     */
    public void userCreate(UserForm form, HttpServletRequest request) throws ServletException {
        userAuthRepository.createUser(
                form.getUsername(),
                form.getPassword()
        );

        request.login(form.getUsername(), form.getPassword());
    }
}
