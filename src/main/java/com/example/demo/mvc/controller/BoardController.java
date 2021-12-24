package com.example.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	/*
	 * 목록리턴
	 * @return
	 */
	@GetMapping
	public List<Board> getList(){
		return boardService.getList();
	}

	/*
	 * 상세정보리턴
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/{boardSeq}") //boardSeq를 url path로 받게 한다. 
	public Board get(@PathVariable int boardSeq) { 
		return boardService.get(boardSeq);
	}

	/*
	 * 등록/수정 처리
	 * @param board
	 */
	@GetMapping("/save") //실무에서는 data를 저장,삭제 할 때 Get보다는 POST,PUT,DELETE를 사용하는 것이 좋다.
	public int save(Board parameter) {
		boardService.save(parameter);
		return parameter.getBoardSeq();
	}

	/*
	 * 삭제처리
	 * @param boardSeq
	 */
	@GetMapping("/delete/{boardSeq}")
	public void delete(@PathVariable int boardSeq) {
		boardService.delete(boardSeq);
	}
}
