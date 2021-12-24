package com.example.demo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository repository;
	
	/*
	 * 목록리턴
	 * @return
	 */
	public List<Board> getList(){
		return repository.getList();
	}

	/*
	 * 상세정보리턴
	 * @param boardSeq
	 * @return
	 */
	public Board get(int boardSeq) {
		return repository.get(boardSeq);
	}

	/*
	 * 등록 처리
	 * @param board
	 */
	public void save(Board parameter) {
		//조회하여 리턴된 정보
		Board board = repository.get(parameter.getBoardSeq());
		if(board==null) {
			repository.save(parameter);
		}else {
			repository.update(parameter);
		}
	}

	/*
	 * 삭제처리
	 * @param boardSeq
	 */
	public void delete(int boardSeq) {
		repository.delete(boardSeq);
	}
}
