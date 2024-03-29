package com.family.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.family.demo.domain.MoneyNote;
import com.family.demo.dto.PieList;
import com.family.demo.service.MoneyNoteService;

@RestController
public class MoneyNoteController {

	@Autowired
	private MoneyNoteService moneyNoteService;

	@RequestMapping(value = "/api/costingList", method = RequestMethod.POST)
	public MoneyNote addcostingList(@RequestBody MoneyNote moneyNote) {
		return moneyNoteService.save(moneyNote);
	}

	@RequestMapping(value = "/api/costingList", method = RequestMethod.GET)
	public ArrayList<MoneyNote> getCostingListByAccountId(
			@RequestParam(name = "accountId", required = true) String accountId) {
		return moneyNoteService.findbyAccountId(Long.parseLong(accountId));
	}

	@RequestMapping(value = "/api/costingList", method = RequestMethod.DELETE)
	public MoneyNote deleteCostingListById(@RequestParam(name = "id", required = true) String id) {
		return moneyNoteService.deleteMoneyNoteById(Long.parseLong(id));
	}

	@RequestMapping(value = "/api/costingList/pieList", method = RequestMethod.GET)
	public ArrayList<PieList> getPieListByAccountId(
			@RequestParam(name = "accountId", required = true) String accountId,
			@RequestParam(name = "choose", required = true) String valueOfTimeLimit) {
		return moneyNoteService.getPieLists(Long.parseLong(accountId),Integer.parseInt(valueOfTimeLimit));
	}

}
