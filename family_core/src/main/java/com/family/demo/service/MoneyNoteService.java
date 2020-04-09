package com.family.demo.service;

import java.util.ArrayList;

import com.family.demo.domain.MoneyNote;
import com.family.demo.dto.PieList;

public interface MoneyNoteService {
	ArrayList<MoneyNote> findbyAccountId(long accountId);
	MoneyNote save(MoneyNote moneyNote);
	MoneyNote deleteMoneyNoteById(Long id);
	ArrayList<PieList> getPieLists(Long accountId, int valueOfTimeLimit);
}
