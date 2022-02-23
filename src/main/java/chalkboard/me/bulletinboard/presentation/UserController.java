package chalkboard.me.bulletinboard.presentation;

import chalkboard.me.bulletinboard.application.form.UserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    // 登録ページの表示
    @GetMapping("/signup")
    public ModelAndView signup(ModelAndView modelAndView) {
        modelAndView.setViewName("user/signup");
        modelAndView.addObject("userForm", new UserForm());
        return modelAndView;
    }

    // 新規登録フォーム
    @PostMapping("/signup")
    public ModelAndView register(@Validated @ModelAttribute UserForm userForm, BindingResult bindingResult) {
        // もし送信エラーが起こった場合はフォーム画面を表示する
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("user/signup");
            modelAndView.addObject("userForm", new UserForm());
            return modelAndView;
        }

        // TODO:作成処理
        return new ModelAndView("redirect:/board");
    }

}
