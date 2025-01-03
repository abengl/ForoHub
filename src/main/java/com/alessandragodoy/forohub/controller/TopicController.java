package com.alessandragodoy.forohub.controller;

import com.alessandragodoy.forohub.dto.RequestCreateTopic;
import com.alessandragodoy.forohub.dto.TopicDTO;
import com.alessandragodoy.forohub.service.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

	private final TopicService topicService;

	@GetMapping
	public ResponseEntity<Page<TopicDTO>> requestAllTopics(
			@PageableDefault(size = 5, sort = "creationDate") Pageable pageable) {
		return ResponseEntity.ok(topicService.getAllTopics(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<TopicDTO> requestTopicById(@PathVariable Long id) {
		return ResponseEntity.ok(topicService.getTopicById(id));
	}

	@PostMapping
	public ResponseEntity<TopicDTO> requestToCreateTopic(@RequestBody @Valid RequestCreateTopic request) {
		TopicDTO createdTopic = topicService.createTopic(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdTopic);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TopicDTO> requestToUpdateTopic(@RequestBody @Valid RequestCreateTopic request, @PathVariable Long id) {
		return ResponseEntity.ok(topicService.updateTopic(request, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> requestToDeleteTopic(@PathVariable Long id) {
		topicService.deleteTopic(id);
		return ResponseEntity.status(HttpStatus.OK).body("Topic with id " + id + " deleted successfully");
	}

}
