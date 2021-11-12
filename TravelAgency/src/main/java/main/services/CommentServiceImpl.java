package main.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.models.Comment;
import main.repository.CommentRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void saveComment(Comment comment) {
		commentRepository.save(comment);
	}

}
