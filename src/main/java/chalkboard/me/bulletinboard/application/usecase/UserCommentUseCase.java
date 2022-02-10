package chalkboard.me.bulletinboard.application.usecase;

import chalkboard.me.bulletinboard.application.form.CommentForm;
import chalkboard.me.bulletinboard.domain.model.UserComment;
import chalkboard.me.bulletinboard.domain.model.UserCommentRepository;
import chalkboard.me.bulletinboard.domain.model.UserComments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommentUseCase {
    private final UserCommentRepository repository;

    public void write(CommentForm commentForm) {
        UserComment userComment = UserComment.from(
                commentForm.getName(),
                commentForm.getEmail(),
                commentForm.getComment()
        );
        repository.save(userComment);
    }

    public UserComments read() {
        return repository.select();
    }
}
