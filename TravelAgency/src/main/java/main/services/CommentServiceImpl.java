package main.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.CommentDAO;
import main.models.Comment;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO commentRepository;

	@Override
	public void saveComment(Comment comment) {
		commentRepository.save(comment);
	}

}
