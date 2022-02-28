package chalkboard.me.bulletinboard.application.dto;

import chalkboard.me.bulletinboard.domain.model.UserComments;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserCommentRead {
    private final int id;
    private final String userId;
    private final String name;
    private final String email;
    private final String comment;
    private final LocalDateTime createdAt;

    // RESTAPIのレスポンス変換
    public static List<UserCommentRead> from(UserComments comments) {
        return comments.getValue().stream().map(
                comment -> new UserCommentRead(
                        comment.getId(),
                        comment.getUserId().toString(),
                        comment.getName().toString(),
                        comment.getEmail().toString(),
                        comment.getComment().toString(),
                        LocalDateTime.parse(comment.getDateTime().toString())
                )
        ).collect(Collectors.toUnmodifiableList());
    }
}

