package com.alessandragodoy.forohub.controller;

import com.alessandragodoy.forohub.dto.TopicDTO;
import com.alessandragodoy.forohub.service.TopicService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {

	private final TopicService topicService;

	@GetMapping
	public ResponseEntity<Page<TopicDTO>> getAllTopics(@PageableDefault(size = 5, sort = "creationDate") Pageable pageable) {
		return ResponseEntity.ok(topicService.getAllTopics(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<TopicDTO> requestTopicById(@PathVariable Long id) {
		return ResponseEntity.ok(topicService.getTopicById(id));
	}


}
