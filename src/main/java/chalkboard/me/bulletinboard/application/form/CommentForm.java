package chalkboard.me.bulletinboard.application.form;

import lombok.Data;

/*
    @Dataはコンストラクタとアクセサを自動で同時に作成するアノテーション。
    乱用は控える。
    以下のようなデータを受け渡すためのオブジェクトにのみ使用する
 */
@Data
public class CommentForm {
    private String name;
    private String email;
    private String comment;
}
