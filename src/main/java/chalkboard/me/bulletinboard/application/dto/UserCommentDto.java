package chalkboard.me.bulletinboard.application.dto;

import chalkboard.me.bulletinboard.domain.model.UserComment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserCommentDto {
    private final String name;
    private final String userId;
    private final String email;
    private final String comment;

    public static UserCommentDto from(
            UserComment userComment) {
        return new UserCommentDto(
                userComment.getName().toString(),
                userComment.getUserId().toString(),
                userComment.getEmail().toString(),
                userComment.getComment().toString()
        );
    }
}