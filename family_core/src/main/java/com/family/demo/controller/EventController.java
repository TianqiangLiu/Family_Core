package com.family.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.family.demo.domain.Event;
import com.family.demo.dto.CalendarEvent;
import com.family.demo.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/api/event", method = RequestMethod.POST)
	public Event addEvent(@RequestBody Event event) {
		return eventService.save(event);
	}

	@RequestMapping(value = "/api/canlendar", method = RequestMethod.GET)
	public HashMap<String, ArrayList<CalendarEvent>> getPieListByAccountId(
			@RequestParam(name = "accountId", required = true) String accountId) {
		return eventService.findbyAccountId(Long.parseLong(accountId));
	}
}
