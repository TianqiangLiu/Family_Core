package com.family.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.family.demo.domain.Event;
import com.family.demo.dto.CalendarEvent;
import com.family.demo.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public Event save(Event event) {
		Date date = event.getDate();
		date = DateUtils.setHours(date, 0);
		date = DateUtils.setMinutes(date, 0);
		date = DateUtils.setSeconds(date, 0);
		event.setDate(date);
		return eventRepository.save(event);
	}

	@Override
	public HashMap<String,ArrayList<CalendarEvent>> findbyAccountId(Long accountId) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Event> arrayList = new ArrayList<Event>(eventRepository.findbyAccountId(accountId));
		
		HashMap<String,ArrayList<CalendarEvent>> resultMap = new HashMap<String,ArrayList<CalendarEvent>>();
		for (int i = 0; i < arrayList.size(); i++) {
			String string = dateFormat.format(arrayList.get(i).getDate());
			if(resultMap.containsKey(string)) {
				CalendarEvent calendarEvent = new CalendarEvent(arrayList.get(i).getType(), arrayList.get(i).getContent());
				ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>(resultMap.get(string));
				events.add(calendarEvent);
				resultMap.put(string, events);
			}else {
				CalendarEvent calendarEvent = new CalendarEvent(arrayList.get(i).getType(), arrayList.get(i).getContent());
				ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();
				events.add(calendarEvent);
				resultMap.put(string, events);
			}
			
		}
		
		return resultMap.size()>0?resultMap:null;
	}

}
