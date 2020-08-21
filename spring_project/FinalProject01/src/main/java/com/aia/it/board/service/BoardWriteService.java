package com.aia.it.board.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.it.board.dao.BoardDaoInterface;
import com.aia.it.board.model.Board;
import com.aia.it.board.model.BoardRequest;

@Service
public class BoardWriteService {

	private BoardDaoInterface dao;

	@Autowired
	private SqlSessionTemplate template;

	public int boardWrite(BoardRequest bRequest, HttpServletRequest request) {

		dao = template.getMapper(BoardDaoInterface.class);

		int result = 0;

		Board board = bRequest.toBoard();
		System.out.println(board);
		System.out.println("입력 전 bid : " + board.getBidx());

		try {

			MultipartFile file1 = bRequest.getBphoto1();
			MultipartFile file2 = bRequest.getBphoto2();

			System.out.println(bRequest);

			// 사진이 있다면 사진 파일을 물리적으로 저장하고, 없다면 기본 이미지 파일의 경로를 저장한다.
			if (file1 != null && !file1.isEmpty() && file1.getSize() > 0) {

				// 서버 내부의 경로
				String uri = request.getSession().getServletContext().getInitParameter("boardUploadPath");

				// 시스템의 실제(절대) 경로
				String realPath = request.getSession().getServletContext().getRealPath(uri);

				// 저장할 이미지 파일의 새로운 이름 생성
				String newFileName = System.nanoTime() + "_" + file1.getOriginalFilename();

				// 서버의 저장소에 실제 저장
				File saveFile = new File(realPath, newFileName);
				file1.transferTo(saveFile);
				System.out.println("저장 완료 : " + newFileName);

				// 데이터베이스에 저장할 Member 객체의 데이터를 완성한다. : 사진 경로
				board.setBphoto1(newFileName);
				// board.setBphoto2(newFileName);

			} else {
				board.setBphoto1("defalult.png");
				// board.setBphoto2("defalult.png");

			}

			// 사진이 있다면 사진 파일을 물리적으로 저장하고, 없다면 기본 이미지 파일의 경로를 저장한다.
			if (file2 != null && !file2.isEmpty() && file2.getSize() > 0) {

				// 서버 내부의 경로
				String uri = request.getSession().getServletContext().getInitParameter("boardUploadPath");

				// 시스템의 실제(절대) 경로
				String realPath = request.getSession().getServletContext().getRealPath(uri);

				// 저장할 이미지 파일의 새로운 이름 생성
				String newFileName = System.nanoTime() + "_" + file2.getOriginalFilename();

				// 서버의 저장소에 실제 저장
				File saveFile = new File(realPath, newFileName);
				file2.transferTo(saveFile);
				System.out.println("저장 완료 : " + newFileName);

				// 데이터베이스에 저장할 Member 객체의 데이터를 완성한다. : 사진 경s로
				// board.setBphoto1(newFileName);
				board.setBphoto2(newFileName);

			} else {
				// board.setBphoto1("defalult.png");
				board.setBphoto2("defalult.png");

			}
			
			System.out.println("여기까지 왔는지 확인: "+ dao.insertBoard(board));
			System.out.println("입력 후 IDX ===> " + board.getBidx());
			
			result = dao.insertBoard(board);

			System.out.println("입력 후 IDX ===> " + board.getBidx());

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return result;

	}

}
