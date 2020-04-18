package com.example.mongo.service.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongo.model.memo.dao.MemoDAO;
import com.example.mongo.model.memo.dto.MemoDTO;

@Service
public class MemoServiceImpl implements MemoService {
	
	@Autowired
	MemoDAO memoDAO;

	@Override
	public List<MemoDTO> getMemoList() {
		return (memoDAO.getMemoList());
	}

	@Override
	public void memoInsert(MemoDTO dto) {
		memoDAO.memoInsert(dto);
	}

	@Override
	public MemoDTO memoDetail(String _id) {
		return (memoDAO.memoDetail(_id));
	}

	@Override
	public void memoUpdate(MemoDTO dto) {
		memoDAO.memoUpdate(dto);
	}

	@Override
	public void memoDelete(String _id) {
		memoDAO.memoDelete(_id);
	}

}
