package chalkboard.me.bulletinboard.application.form;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
    @Dataはコンストラクタとアクセサを自動で同時に作成するアノテーション。
    乱用は控える。
    以下のようなデータを受け渡すためのオブジェクトにのみ使用する
 */
@Data
public class CommentForm {
    @Nullable
    @Size(max = 20)
    private String name;
    @Nullable
    @Email
    @Size(max = 100)
    private String email;
    @NotNull
    @Size(min = 1, max = 400)
    private String comment;
}
