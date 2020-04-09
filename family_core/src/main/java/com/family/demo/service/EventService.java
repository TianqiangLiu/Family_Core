package com.family.demo.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.family.demo.domain.Event;
import com.family.demo.dto.CalendarEvent;

public interface EventService {
	HashMap<String,ArrayList<CalendarEvent>> findbyAccountId(Long accountId);
	Event save(Event event);

}
