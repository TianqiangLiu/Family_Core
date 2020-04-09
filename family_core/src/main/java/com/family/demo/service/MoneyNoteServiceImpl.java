package com.family.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.family.demo.domain.MoneyNote;
import com.family.demo.dto.PieList;
import com.family.demo.repository.MoneyNoteRepository;

@Service
public class MoneyNoteServiceImpl implements MoneyNoteService {
	
	@Autowired
	private MoneyNoteRepository moneyNoteRepository;

	@Override
	public ArrayList<MoneyNote> findbyAccountId(long accountId) {
		return new ArrayList<MoneyNote>(moneyNoteRepository.findbyAccountId(accountId));
	}

	@Override
	public MoneyNote save(MoneyNote moneyNote) {
		return moneyNoteRepository.save(moneyNote);
	}

	@Override
	public MoneyNote deleteMoneyNoteById(Long id) {
		MoneyNote moneyNote = moneyNoteRepository.findById(id).get();
		if(moneyNote!=null)
			moneyNoteRepository.delete(moneyNote);
		return moneyNote;
	}

	@Override
	public ArrayList<PieList> getPieLists(Long accountId, int valueOfTimeLimit) {
		ArrayList<PieList> pieArrayList = new ArrayList<PieList>();
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		ArrayList<MoneyNote> arrayList = new ArrayList<MoneyNote>(moneyNoteRepository.findbyAccountIdAndDates(accountId, DateUtils.addDays(new Date(), -1*(valueOfTimeLimit)), new Date()));
		
		for (int i = 0; i < arrayList.size(); i++) {
			String cate= arrayList.get(i).getCategories().toLowerCase();
			float amount = arrayList.get(i).getAmount();
			map.put(cate, map.containsKey(cate)?map.get(cate)+amount:amount);
		}
		for (Map.Entry<String, Double> m : map.entrySet()) {
			pieArrayList.add(new PieList(m.getKey(), m.getValue()));
		}
		return pieArrayList;
	}

}
