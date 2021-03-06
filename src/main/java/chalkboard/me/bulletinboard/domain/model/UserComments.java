package chalkboard.me.bulletinboard.domain.model;

import chalkboard.me.bulletinboard.domain.type.Comment;
import chalkboard.me.bulletinboard.domain.type.DateTime;
import chalkboard.me.bulletinboard.domain.type.Email;
import chalkboard.me.bulletinboard.domain.type.Name;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserComments {
    private final List<UserComment> value;

    public static UserComments from(List<UserComment> comments) {
        if (CollectionUtils.isEmpty(comments)) return new UserComments(Collections.emptyList());
        return new UserComments(comments);
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class UserComment {
        private final int id;
        private final UserId userId;
        private final Name name;
        private final Email email;
        private final Comment comment;
        private final DateTime dateTime;

        public static UserComment from(
                int id,
                String userId,
                String name,
                String email,
                String comment,
                LocalDateTime dateTime
        ) {
            return new UserComment(
                    id, UserId.from(userId),
                    Name.from(name),
                    Email.from(email),
                    Comment.from(comment),
                    DateTime.from(dateTime)
            );
        }

    }
}
